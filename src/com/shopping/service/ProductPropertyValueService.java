package com.shopping.service;

import java.util.List;

import com.shopping.entity.ProductPropertyValue;

public interface ProductPropertyValueService {
	/**
	 * ������Ʒ����
	 * @param id
	 * @return �����б�
	 */
	List<ProductPropertyValue> getPropertysByProductId(Long id);
}
