package com.shopping.service;

import java.util.Map;

import com.shopping.entity.Page;
import com.shopping.entity.Product;
<<<<<<< HEAD
=======
import com.shopping.entity.SearchCondition;
>>>>>>> 321d01f818697788897939feda38b5d813fff1b5

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
<<<<<<< HEAD
	public Page<Map<String, Object>> getProductListByCategoryThreeId(Integer cthId, Page<Map<String, Object>> page);
=======
	public Page<Map<String, Object>> getProductListByCondition(SearchCondition sc);

>>>>>>> 321d01f818697788897939feda38b5d813fff1b5
}
