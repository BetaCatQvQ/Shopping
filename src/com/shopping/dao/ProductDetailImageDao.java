package com.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.ProductDetailImage;

public interface ProductDetailImageDao {

	/**
	 * 查询商品描述图片
	 * @param id 商品id
	 * @return 图片列表
	 */
	List<ProductDetailImage> getDetailImagesByProductId(@Param("id") Long id);
}
