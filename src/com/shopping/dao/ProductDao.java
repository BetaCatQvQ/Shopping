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
<<<<<<< HEAD
	Product getProductById(Long id);

	/**
	 * 通过三级分类编号查询商品
	 * 
	 * @param categoryOneId
	 * @return 产品列表
	 */
	public List<Map<String, Object>> getProductListByCategoryThreeId(@Param("cthId") Integer categoryThreeId,
			@Param("page") Page<Map<String, Object>> page);
=======
	Product getProductById(@Param("id") Long id);
>>>>>>> 1a6d4b613a004b006ced670703298587adc2d9ea
}
