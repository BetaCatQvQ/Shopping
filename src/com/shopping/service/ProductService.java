package com.shopping.service;

<<<<<<< HEAD
import java.util.Map;

import com.shopping.entity.Page;
import com.shopping.entity.Product;

public interface ProductService {

	/**
	 * 根据id获取商品信息
	 * 
	 * @param id
	 *            商品id
	 * @return 商品信息
	 */
	Product getProductById(Long id);

	/**
	 * 通过三级分类的编号获取商品的信息
	 * 
	 * @param cthId
	 * @return 返回的是map集合
	 */
	public Page<Map<String, Object>> getProductListByCategoryThreeId(Integer cthId, Page<Map<String, Object>> page);

=======
public interface ProductService {
	
>>>>>>> 1a6d4b613a004b006ced670703298587adc2d9ea
}
