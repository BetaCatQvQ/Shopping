package com.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.ProductPropertyValue;

public interface ProductPropertyValueDao {
	/**
	 * 查找商品属性
	 * @param id
	 * @return 属性列表
	 */
	List<ProductPropertyValue> getPropertysByProductId(@Param("id") Long id);
}
