package com.shopping.service;

import java.util.List;

import com.shopping.entity.ProductPropertyValue;

public interface ProductPropertyValueService {
	/**
	 * 查找商品属性
	 * @param id
	 * @return 属性列表
	 */
	List<ProductPropertyValue> getPropertysByProductId(Long id);
}
