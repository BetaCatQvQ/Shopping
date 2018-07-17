package com.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.ProductDetailImage;

public interface ProductDetailImageDao {

	/**
	 * ��ѯ��Ʒ����ͼƬ
	 * @param id ��Ʒid
	 * @return ͼƬ�б�
	 */
	List<ProductDetailImage> getDetailImagesByProductId(@Param("id") Long id);
}
