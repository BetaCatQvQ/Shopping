package com.shopping.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

import com.shopping.annotation.FK;
import com.shopping.annotation.ID;

@Component
public class JDBCTool {
	/**
	 * 链接池
	 */
	@Resource(name = "dataSource")
	public BasicDataSource dataSource;

	/**
	 * 自动对比新旧数据
	 * 
	 * @param newObject需要更新属性的对象
	 * @param oldObject从数据库查询出来的对象
	 * @return 如果出现问题，则返回null，如果没有出现问题，就返回一个更新后的对象
	 */
	public <T> T contrast(T newObject, T oldObject) {
		try {
			// 获取类里的所有属性
			Field[] fields = oldObject.getClass().getDeclaredFields();
			// 遍历所有属性
			for (Field field : fields) {
				// 允许获取private属性值
				field.setAccessible(true);
				Object oldVal = field.get(oldObject);
				Object newVal = field.get(newObject);
				// 判断新对象的属性值是否为空
				if (newVal == null) {
					field.set(newObject, oldVal);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return newObject;
	}

	@SuppressWarnings("unused")
	private Integer autoUpdate(Object object) {
		// 操作数据库对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 受影响行数
		Integer count = -1;
		try {
			// 获取表名
			String tableName = ClassTool.getSimpleClassName(object.getClass().getName().toLowerCase());
			// 获取ID，索引0是id字段名，1是值
			Object[] id = null;
			// 设置ID的属性为空
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				if (field.isAnnotationPresent(ID.class)) {
					field.setAccessible(true);
					id = new Object[2];
					id[0] = field.getName();
					id[1] = field.get(object);
					field.set(object, null);
					break;
				}
			}
			// sql
			StringBuffer sql = new StringBuffer("UPDATE `" + tableName + "` SET ");

			// 拼接字符串 start
			// 获取属性里的字段和属性值
			List<Object[]> columnAndVal = getColumnAndVal(object);
			if (columnAndVal == null) {
				throw new Exception("获取字段和属性失败");
			}
			for (Object[] objects : columnAndVal) {
				sql.append("`" + objects[0] + "` = ?,");
			}

			sql = new StringBuffer(sql.substring(0, sql.length() - 1));
			sql.append(" WHERE 1=1 AND`" + id[0] + "` = ?");
			System.out.println(sql);
			// 拼接字符串 end

			// 执行sql
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			int lastIndex = 0;
			for (int i = 0; i < columnAndVal.size(); i++) {
				pstmt.setObject(i + 1, columnAndVal.get(i)[1]);
				lastIndex = i + 1;
			}
			pstmt.setObject(lastIndex + 1, id[1]);
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}

		return count;
	}

	/**
	 * 通过id获取对象
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz, Object id) {
		// 操作数据库对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 需要返回的对象
		T object = null;
		try {
			// 表名
			String tableName = ClassTool.getSimpleClassName(clazz.getName()).toLowerCase();
			// Id字段名
			String idName = "";
			// 获取表实体所有属性
			Field[] fields = clazz.getDeclaredFields();
			// 遍历
			for (int i = 0; i < fields.length; i++) {
				// 当前遍历到的属性是否有Id这个注解
				if (fields[i].isAnnotationPresent(ID.class)) {
					// 获取Id注解
					ID annId = fields[i].getDeclaredAnnotation(ID.class);
					// 获取Id字段名
					idName = "".equals(annId.value()) ? fields[i].getName() : annId.value();
					break;
				}
				// 如果没有找到Id注解
				if (i == fields.length - 1) {
					throw new Exception("未找到Id注解");
				}
			}
			// 执行sql
			String sql = "SELECT * FROM `" + tableName + "` WHERE `" + idName + "` = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();

			// 封装对象
			if (rs.next()) {
				// 类对象
				Class<?> objectClass = Class.forName(clazz.getName());
				// 构造器
				Constructor<T> cons = (Constructor<T>) objectClass.getConstructor();
				// 创建对象
				object = cons.newInstance();
				// 遍历类属性
				for (Field field : fields) {
					field.setAccessible(true);
					// 捕捉封装数据时的错误
					try {
						String columnName = field.getName();
						Object columnVal = rs.getObject(columnName);
						field.set(object, parseVal(columnVal));
					} catch (Exception e) {
						continue;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeAll(conn, pstmt, rs);
		}

		return object;
	}

	/**
	 * 释放资源
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 简单的数据类型转换
	 * 
	 * @param object
	 * @return
	 */
	public Object parseVal(Object object) {
		String className = object.getClass().getName();

		Object val = object;
		if ("java.lang.Long".equals(className)) {
			val = new BigInteger(object.toString());
		}
		return val;
	}

	/**
	 * 传递一个对象，就可以自动添加至数据库
	 * 
	 * @param object
	 * @return 受影响行数
	 */
	public Integer autoInsert(Object object) {
		// 操作数据库对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 受影响行数
		Integer count = -1;
		try {
			// 获取表名
			String tableName = ClassTool.getSimpleClassName(object.getClass().getName().toLowerCase());
			// sql
			StringBuffer sql = new StringBuffer("INSERT INTO `" + tableName + "`");

			// 拼接字符串 start
			StringBuffer cloumnStr = new StringBuffer("(");
			StringBuffer valStr = new StringBuffer("VALUES(");

			// 获取属性里的字段和属性值
			List<Object[]> columnAndVal = getColumnAndVal(object);
			if (columnAndVal == null) {
				throw new Exception("获取字段和属性失败");
			}
			for (Object[] objects : columnAndVal) {
				cloumnStr.append("`" + objects[0] + "`,");
				valStr.append("?,");
			}

			cloumnStr = new StringBuffer(cloumnStr.substring(0, cloumnStr.length() - 1) + ")");
			valStr = new StringBuffer(valStr.substring(0, valStr.length() - 1) + ")");
			sql.append(cloumnStr.toString() + valStr.toString());
			System.out.println(sql);
			// 拼接字符串 end

			// 执行sql
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			for (int i = 0; i < columnAndVal.size(); i++) {
				pstmt.setObject(i + 1, columnAndVal.get(i)[1]);
			}
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}

		return count;
	}

	/**
	 * 判断属性是否是基本数据类型
	 * 
	 * @return 是就返回true，不是就返回false
	 */
	public boolean checkProperty(Object obj) {
		String className = obj.getClass().getName();

		if ("java.lang.Integer".equals(className)) {
			return true;
		} else if ("java.lang.String".equals(className)) {
			return true;
		} else if ("java.math.BigInteger".equals(className)) {
			return true;
		} else if ("java.util.Date".equals(className)) {
			return true;
		} else if ("java.lang.Float".equals(className)) {
			return true;
		} else if ("java.lang.Double".equals(className)) {
			return true;
		} else if ("java.lang.Long".equals(className)) {
			return true;
		}
		return false;
	}

	/**
	 * 获取对象里的属性名和属性值
	 * 
	 * @param object
	 * @return 返回一个Object数组的集合，数组下标0的元素里是字段名，下标1的元素里是参数
	 */
	public List<Object[]> getColumnAndVal(Object object) {
		// 属性名和属性值集合
		List<Object[]> columnAndVal = new ArrayList<>();
		// 获取类属性
		Field[] fields = object.getClass().getDeclaredFields();
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				Object val = field.get(object);
				// 是否是基本数据类型，并且不为空
				if (val != null && checkProperty(val)) {
					// 存储当前属性的属性名和值
					Object[] keyVal = { field.getName(), val };
					columnAndVal.add(keyVal);
					// 是否是外键，并且不为空
				} else if (val != null && field.getDeclaredAnnotation(FK.class) != null) {
					// 遍历外键里的属性
					Field[] fkField = val.getClass().getDeclaredFields();
					for (Field field2 : fkField) {
						field2.setAccessible(true);
						// 判断外键的ID
						if (field2.getDeclaredAnnotation(ID.class) != null) {
							if (field2.get(val) == null) {
								throw new Exception("外键id为空");
							}
							// 存储当前属性的属性名和值
							Object[] keyVal = { field2.getName(), field2.get(val) };
							columnAndVal.add(keyVal);
							break;
						}
					}
				}
			}
			return columnAndVal;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
