package com.shopping.service;

import com.shopping.entity.Product;

public interface ProductService {
	
	/**
	 * ����id��ȡ��Ʒ��Ϣ
	 * @param id ��Ʒid
	 * @return ��Ʒ��Ϣ
	 */
	Product getProductById(Long id);
	
}
