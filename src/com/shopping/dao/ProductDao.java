package com.shopping.dao;

import com.shopping.entity.Product;

public interface ProductDao {
	/**
	 * ����id��ȡ��Ʒ
	 * @param id ��Ʒ Id
	 * @return ��Ʒ
	 */
	Product getProductById(Long id);
}
