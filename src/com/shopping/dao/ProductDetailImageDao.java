package com.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.ProductDetailImage;

public interface ProductDetailImageDao {
	
	/**
	 * 获取商品描述图
	 * @param id 商品编号
	 * @return 图片列表
	 */
	List<ProductDetailImage> getImagesByProductId(@Param("id") Long id);
}
