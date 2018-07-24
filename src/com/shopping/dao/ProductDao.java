package com.shopping.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Page;
import com.shopping.entity.Product;
import com.shopping.entity.SearchCondition;

public interface ProductDao {
	/**
	 * 通过一级分类编号查询商品
	 * 
	 * @param categoryOneId
	 * @return 产品列表
	 */
<<<<<<< HEAD
	public List<Product> getProductListByCategoryOneId(@Param("coId") Integer categoryOneId);
=======
	public List<Map<String,Object>> getProductListByCategoryOneId(@Param("coId") Integer categoryOneId);
>>>>>>> 321d01f818697788897939feda38b5d813fff1b5

	/**
	 * 根据id获取产品
	 * 
	 * @param id
	 *            产品 Id
	 * @return 产品
	 */
	Product getProductById(@Param("id") Long id);

	/**
<<<<<<< HEAD
	 * 通过三级分类编号查询商品
	 * 
	 * @param categoryOneId
	 * @return 产品列表
	 */
	public List<Map<String, Object>> getProductListByCategoryThreeId(@Param("cthId") Integer categoryThreeId,
=======
	 * 通过条件查询商品
	 * 
	 * @param categoryThreeId
	 * @param page
	 * @return
	 */
	public List<Map<String, Object>> getProductListByCondition(@Param("sc") SearchCondition sc,
>>>>>>> 321d01f818697788897939feda38b5d813fff1b5
			@Param("page") Page<Map<String, Object>> page);
}
