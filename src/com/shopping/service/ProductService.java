package com.shopping.service;

<<<<<<< HEAD
import java.util.Map;

import com.shopping.entity.Page;
import com.shopping.entity.Product;
import com.shopping.entity.SearchCondition;

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
	public Page<Map<String, Object>> getProductListByCondition(SearchCondition sc);

}
