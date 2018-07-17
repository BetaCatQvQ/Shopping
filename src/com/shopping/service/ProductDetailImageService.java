package com.shopping.service;

import java.util.List;

import com.shopping.entity.ProductDetailImage;

public interface ProductDetailImageService {
	/**
	 * 获取商品描述图
	 * @param id 商品编号
	 * @return 图片列表
	 */
	List<ProductDetailImage> getDetailImagesByProductId(Long id);
}
