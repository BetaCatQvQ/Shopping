package com.shopping.dao;

import com.shopping.entity.Product;

public interface ProductDao {
	/**
	 * 根据id获取产品
	 * @param id 产品 Id
	 * @return 产品
	 */
	Product getProductById(Long id);
}
