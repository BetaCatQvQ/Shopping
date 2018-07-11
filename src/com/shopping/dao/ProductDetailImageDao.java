package com.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.ProductDetailImage;

public interface ProductDetailImageDao {
	
	/**
	 * ��ȡ��Ʒ����ͼ
	 * @param id ��Ʒ���
	 * @return ͼƬ�б�
	 */
	List<ProductDetailImage> getImagesByProductId(@Param("id") Long id);
}
