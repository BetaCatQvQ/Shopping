package com.shopping.service;

import java.util.Map;

import com.shopping.entity.Page;
import com.shopping.entity.Product;

public interface ProductService {

	/**
	 * ����id��ȡ��Ʒ��Ϣ
	 * 
	 * @param id
	 *            ��Ʒid
	 * @return ��Ʒ��Ϣ
	 */
	Product getProductById(Long id);

	/**
	 * ͨ����������ı�Ż�ȡ��Ʒ����Ϣ
	 * 
	 * @param cthId
	 * @return ���ص���map����
	 */
	public Page<Map<String, Object>> getProductListByCategoryThreeId(Integer cthId, Page<Map<String, Object>> page);
}
