package com.shopping.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductImageDao;
import com.shopping.service.ProductImageService;

@Service
public class ProductImageServiceImpl implements ProductImageService {
	@Resource
	private ProductImageDao piDao;
}
