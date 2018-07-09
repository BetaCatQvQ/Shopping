package com.shopping.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductPropertyValueDao;
import com.shopping.service.ProductPropertyValueService;

@Service
public class ProductPropertyValueServiceImpl implements ProductPropertyValueService {
	@Resource
	private ProductPropertyValueDao ppvDao;
}
