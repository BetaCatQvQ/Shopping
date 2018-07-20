package com.shopping.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Page;
import com.shopping.entity.Product;

public interface ProductDao {
	/**
	 * 通过一级分类编号查询商品
	 * 
	 * @param categoryOneId
	 * @return 产品列表
	 */
	public List<Product> getProductListByCategoryOneId(@Param("coId") Integer categoryOneId);

	/**
	 * 根据id获取产品
	 * 
	 * @param id
	 *            产品 Id
	 * @return 产品
	 */
	Product getProductById(@Param("id") Long id);

	/**
	 * 通过三级分类编号查询商品
	 * 
	 * @param categoryOneId
	 * @return 产品列表
	 */
	public List<Map<String, Object>> getProductListByCategoryThreeId(@Param("cthId") Integer categoryThreeId,
			@Param("page") Page<Map<String, Object>> page);
}
