package com.shopping.service;

<<<<<<< HEAD
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

=======
public interface ProductService {
	
>>>>>>> 1a6d4b613a004b006ced670703298587adc2d9ea
}
