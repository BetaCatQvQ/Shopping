package com.shopping.service;

import java.util.List;

import com.shopping.entity.ProductDetailImage;

public interface ProductDetailImageService {
	/**
	 * ��ȡ��Ʒ����ͼ
	 * @param id ��Ʒ���
	 * @return ͼƬ�б�
	 */
	List<ProductDetailImage> getDetailImagesByProductId(Long id);
}
