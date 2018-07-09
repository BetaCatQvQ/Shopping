package com.shopping.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductPropertyDao;
import com.shopping.service.ProductPropertyService;

@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {
	@Resource
	private ProductPropertyDao ppDao;
}
