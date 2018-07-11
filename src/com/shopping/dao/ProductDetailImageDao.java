package com.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.ProductDetailImage;

public interface ProductDetailImageDao {

	/**
	 * 根据id获取商品图片
	 * @param id 商品id
	 * @return 图片列表
	 */
	List<ProductDetailImage> getImagesByProductId(@Param("id") Long id);
}
