package com.shopping.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.ProductDetailImage;

public interface ProductDetailImageService {
	/**
	 * ��ȡ��Ʒ����ͼ
	 * @param id ��Ʒ���
	 * @return ͼƬ�б�
	 */
	List<ProductDetailImage> getImagesByProductId(Long id);
}
