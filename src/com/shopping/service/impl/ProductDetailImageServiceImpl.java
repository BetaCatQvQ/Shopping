package com.shopping.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductDetailImageDao;
import com.shopping.entity.ProductDetailImage;
import com.shopping.service.ProductDetailImageService;

@Service
public class ProductDetailImageServiceImpl implements ProductDetailImageService {
	@Resource
	private ProductDetailImageDao pdiDao;

	@Override
	public List<ProductDetailImage> getDetailImagesByProductId(Long id) {
		if (id == null) {
			return null;
		}
		return pdiDao.getDetailImagesByProductId(id);
	}
}
