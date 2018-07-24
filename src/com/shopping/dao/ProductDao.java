package com.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Product;
import com.shopping.entity.SearchCondition;

public interface ProductDao {
	/**
	 * ͨ��һ�������Ų�ѯ��Ʒ
	 * 
	 * @param categoryOneId
	 * @return ��Ʒ�б�
	 */
	public List<Map<String,Object>> getProductListByCategoryOneId(@Param("coId") Integer categoryOneId);

	/**
	 * ����id��ȡ��Ʒ
	 * @param id ��Ʒ Id
	 * @return ��Ʒ
	 */
	Product getProductById(@Param("id") Long id);

	/**
	 * ͨ��������ѯ��Ʒ
	 * 
	 * @param categoryThreeId
	 * @param page
	 * @return
	 */
	public List<Map<String, Object>> getProductListByCondition(@Param("sc") SearchCondition sc,
			@Param("page") Page<Map<String, Object>> page);
}
