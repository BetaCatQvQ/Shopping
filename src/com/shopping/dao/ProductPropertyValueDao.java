package com.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.ProductPropertyValue;

public interface ProductPropertyValueDao {
	/**
	 * ������Ʒ����
	 * @param id
	 * @return �����б�
	 */
	List<ProductPropertyValue> getPropertysByProductId(@Param("id") Long id);
}
