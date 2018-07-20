package com.shopping.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Page;
import com.shopping.entity.Product;

public interface ProductDao {
	/**
	 * ͨ��һ�������Ų�ѯ��Ʒ
	 * 
	 * @param categoryOneId
	 * @return ��Ʒ�б�
	 */
	public List<Product> getProductListByCategoryOneId(@Param("coId") Integer categoryOneId);

	/**
	 * ����id��ȡ��Ʒ
	 * 
	 * @param id
	 *            ��Ʒ Id
	 * @return ��Ʒ
	 */
<<<<<<< HEAD
	Product getProductById(Long id);

	/**
	 * ͨ�����������Ų�ѯ��Ʒ
	 * 
	 * @param categoryOneId
	 * @return ��Ʒ�б�
	 */
	public List<Map<String, Object>> getProductListByCategoryThreeId(@Param("cthId") Integer categoryThreeId,
			@Param("page") Page<Map<String, Object>> page);
=======
	Product getProductById(@Param("id") Long id);
>>>>>>> 1a6d4b613a004b006ced670703298587adc2d9ea
}
