package com.shopping.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductDao;
import com.shopping.entity.Product;
import com.shopping.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductDao pDao;

	@Override
	public Product getProductById(Long id) {
		if (id == null) {
			return null;
		}
		Product product =pDao.getProductById(id);
		System.out.println(id);
		System.out.println(product);
		return product;
	}
	
	
}
