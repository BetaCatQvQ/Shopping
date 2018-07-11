package com.shopping.service;

import com.shopping.entity.Product;

public interface ProductService {
	
	/**
	 * 根据id获取商品信息
	 * @param id 商品id
	 * @return 商品信息
	 */
	Product getProductById(Long id);
	
}
