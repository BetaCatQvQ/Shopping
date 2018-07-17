package com.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Product;

public interface ProductDao {
	public List<Product> getProductListByCategoryOneId(@Param("coId")Integer categoryOneId);
	
	/**
	 * 根据id获取产品
	 * @param id 产品 Id
	 * @return 产品
	 */
	Product getProductById(@Param("id") Long id);
}
