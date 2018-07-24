package com.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Product;
import com.shopping.entity.SearchCondition;

public interface ProductDao {
	/**
	 * 通过一级分类编号查询商品
	 * 
	 * @param categoryOneId
	 * @return 产品列表
	 */
	public List<Map<String,Object>> getProductListByCategoryOneId(@Param("coId") Integer categoryOneId);

	/**
	 * 根据id获取产品
	 * @param id 产品 Id
	 * @return 产品
	 */
	Product getProductById(@Param("id") Long id);

	/**
	 * 通过条件查询商品
	 * 
	 * @param categoryThreeId
	 * @param page
	 * @return
	 */
	public List<Map<String, Object>> getProductListByCondition(@Param("sc") SearchCondition sc,
			@Param("page") Page<Map<String, Object>> page);
}
