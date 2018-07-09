package com.shopping.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductDetailImageDao;
import com.shopping.service.ProductDetailImageService;

@Service
public class ProductDetailImageServiceImpl implements ProductDetailImageService {
	@Resource
	private ProductDetailImageDao pdiDao;
}
