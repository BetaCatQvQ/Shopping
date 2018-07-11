package com.shopping.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.ProductDetailImage;

public interface ProductDetailImageService {
	/**
	 * 获取商品描述图
	 * @param id 商品编号
	 * @return 图片列表
	 */
	List<ProductDetailImage> getImagesByProductId(Long id);
}
