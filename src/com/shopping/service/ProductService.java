package com.shopping.service;

<<<<<<< HEAD
import java.util.Map;

import com.shopping.entity.Page;
import com.shopping.entity.Product;
import com.shopping.entity.SearchCondition;

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
	public Page<Map<String, Object>> getProductListByCondition(SearchCondition sc);

}
