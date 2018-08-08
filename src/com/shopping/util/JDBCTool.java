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
	 * ���ӳ�
	 */
	@Resource(name = "dataSource")
	public BasicDataSource dataSource;

	/**
	 * �Զ��Ա��¾�����
	 * 
	 * @param newObject��Ҫ�������ԵĶ���
	 * @param oldObject�����ݿ��ѯ�����Ķ���
	 * @return ����������⣬�򷵻�null�����û�г������⣬�ͷ���һ�����º�Ķ���
	 */
	public <T> T contrast(T newObject, T oldObject) {
		try {
			// ��ȡ�������������
			Field[] fields = oldObject.getClass().getDeclaredFields();
			// ������������
			for (Field field : fields) {
				// �����ȡprivate����ֵ
				field.setAccessible(true);
				Object oldVal = field.get(oldObject);
				Object newVal = field.get(newObject);
				// �ж��¶��������ֵ�Ƿ�Ϊ��
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
		// �������ݿ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// ��Ӱ������
		Integer count = -1;
		try {
			// ��ȡ����
			String tableName = ClassTool.getSimpleClassName(object.getClass().getName().toLowerCase());
			// ��ȡID������0��id�ֶ�����1��ֵ
			Object[] id = null;
			// ����ID������Ϊ��
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

			// ƴ���ַ��� start
			// ��ȡ��������ֶκ�����ֵ
			List<Object[]> columnAndVal = getColumnAndVal(object);
			if (columnAndVal == null) {
				throw new Exception("��ȡ�ֶκ�����ʧ��");
			}
			for (Object[] objects : columnAndVal) {
				sql.append("`" + objects[0] + "` = ?,");
			}

			sql = new StringBuffer(sql.substring(0, sql.length() - 1));
			sql.append(" WHERE 1=1 AND`" + id[0] + "` = ?");
			System.out.println(sql);
			// ƴ���ַ��� end

			// ִ��sql
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
	 * ͨ��id��ȡ����
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz, Object id) {
		// �������ݿ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// ��Ҫ���صĶ���
		T object = null;
		try {
			// ����
			String tableName = ClassTool.getSimpleClassName(clazz.getName()).toLowerCase();
			// Id�ֶ���
			String idName = "";
			// ��ȡ��ʵ����������
			Field[] fields = clazz.getDeclaredFields();
			// ����
			for (int i = 0; i < fields.length; i++) {
				// ��ǰ�������������Ƿ���Id���ע��
				if (fields[i].isAnnotationPresent(ID.class)) {
					// ��ȡIdע��
					ID annId = fields[i].getDeclaredAnnotation(ID.class);
					// ��ȡId�ֶ���
					idName = "".equals(annId.value()) ? fields[i].getName() : annId.value();
					break;
				}
				// ���û���ҵ�Idע��
				if (i == fields.length - 1) {
					throw new Exception("δ�ҵ�Idע��");
				}
			}
			// ִ��sql
			String sql = "SELECT * FROM `" + tableName + "` WHERE `" + idName + "` = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();

			// ��װ����
			if (rs.next()) {
				// �����
				Class<?> objectClass = Class.forName(clazz.getName());
				// ������
				Constructor<T> cons = (Constructor<T>) objectClass.getConstructor();
				// ��������
				object = cons.newInstance();
				// ����������
				for (Field field : fields) {
					field.setAccessible(true);
					// ��׽��װ����ʱ�Ĵ���
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
	 * �ͷ���Դ
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
	 * �򵥵���������ת��
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
	 * ����һ�����󣬾Ϳ����Զ���������ݿ�
	 * 
	 * @param object
	 * @return ��Ӱ������
	 */
	public Integer autoInsert(Object object) {
		// �������ݿ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// ��Ӱ������
		Integer count = -1;
		try {
			// ��ȡ����
			String tableName = ClassTool.getSimpleClassName(object.getClass().getName().toLowerCase());
			// sql
			StringBuffer sql = new StringBuffer("INSERT INTO `" + tableName + "`");

			// ƴ���ַ��� start
			StringBuffer cloumnStr = new StringBuffer("(");
			StringBuffer valStr = new StringBuffer("VALUES(");

			// ��ȡ��������ֶκ�����ֵ
			List<Object[]> columnAndVal = getColumnAndVal(object);
			if (columnAndVal == null) {
				throw new Exception("��ȡ�ֶκ�����ʧ��");
			}
			for (Object[] objects : columnAndVal) {
				cloumnStr.append("`" + objects[0] + "`,");
				valStr.append("?,");
			}

			cloumnStr = new StringBuffer(cloumnStr.substring(0, cloumnStr.length() - 1) + ")");
			valStr = new StringBuffer(valStr.substring(0, valStr.length() - 1) + ")");
			sql.append(cloumnStr.toString() + valStr.toString());
			System.out.println(sql);
			// ƴ���ַ��� end

			// ִ��sql
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
	 * �ж������Ƿ��ǻ�����������
	 * 
	 * @return �Ǿͷ���true�����Ǿͷ���false
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
	 * ��ȡ�������������������ֵ
	 * 
	 * @param object
	 * @return ����һ��Object����ļ��ϣ������±�0��Ԫ�������ֶ������±�1��Ԫ�����ǲ���
	 */
	public List<Object[]> getColumnAndVal(Object object) {
		// ������������ֵ����
		List<Object[]> columnAndVal = new ArrayList<>();
		// ��ȡ������
		Field[] fields = object.getClass().getDeclaredFields();
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				Object val = field.get(object);
				// �Ƿ��ǻ����������ͣ����Ҳ�Ϊ��
				if (val != null && checkProperty(val)) {
					// �洢��ǰ���Ե���������ֵ
					Object[] keyVal = { field.getName(), val };
					columnAndVal.add(keyVal);
					// �Ƿ�����������Ҳ�Ϊ��
				} else if (val != null && field.getDeclaredAnnotation(FK.class) != null) {
					// ��������������
					Field[] fkField = val.getClass().getDeclaredFields();
					for (Field field2 : fkField) {
						field2.setAccessible(true);
						// �ж������ID
						if (field2.getDeclaredAnnotation(ID.class) != null) {
							if (field2.get(val) == null) {
								throw new Exception("���idΪ��");
							}
							// �洢��ǰ���Ե���������ֵ
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
