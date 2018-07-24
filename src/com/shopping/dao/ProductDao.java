package com.shopping.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Page;
import com.shopping.entity.Product;
import com.shopping.entity.SearchCondition;

public interface ProductDao {
	/**
	 * ͨ��һ�������Ų�ѯ��Ʒ
	 * 
	 * @param categoryOneId
	 * @return ��Ʒ�б�
	 */
<<<<<<< HEAD
	public List<Product> getProductListByCategoryOneId(@Param("coId") Integer categoryOneId);
=======
	public List<Map<String,Object>> getProductListByCategoryOneId(@Param("coId") Integer categoryOneId);
>>>>>>> 321d01f818697788897939feda38b5d813fff1b5

	/**
	 * ����id��ȡ��Ʒ
	 * 
	 * @param id
	 *            ��Ʒ Id
	 * @return ��Ʒ
	 */
	Product getProductById(@Param("id") Long id);

	/**
<<<<<<< HEAD
	 * ͨ�����������Ų�ѯ��Ʒ
	 * 
	 * @param categoryOneId
	 * @return ��Ʒ�б�
	 */
	public List<Map<String, Object>> getProductListByCategoryThreeId(@Param("cthId") Integer categoryThreeId,
=======
	 * ͨ��������ѯ��Ʒ
	 * 
	 * @param categoryThreeId
	 * @param page
	 * @return
	 */
	public List<Map<String, Object>> getProductListByCondition(@Param("sc") SearchCondition sc,
>>>>>>> 321d01f818697788897939feda38b5d813fff1b5
			@Param("page") Page<Map<String, Object>> page);
}
