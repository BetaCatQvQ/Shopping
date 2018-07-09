package com.shopping.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductDao;
import com.shopping.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductDao pDao;
}
