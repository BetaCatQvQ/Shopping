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
<<<<<<< HEAD
	public Page<Map<String, Object>> getProductListByCategoryThreeId(Integer cthId, Page<Map<String, Object>> page);
=======
	public Page<Map<String, Object>> getProductListByCondition(SearchCondition sc);

>>>>>>> 321d01f818697788897939feda38b5d813fff1b5
}
