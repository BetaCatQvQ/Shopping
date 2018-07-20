package com.shopping.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductDao;
import com.shopping.entity.Page;
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
		Product product = pDao.getProductById(id);
		System.out.println(id);
		System.out.println(product);
		return product;
	}

	@Override
	public Page<Map<String, Object>> getProductListByCategoryThreeId(Integer cthId, Page<Map<String, Object>> page) {
		List<Map<String, Object>> products = pDao.getProductListByCategoryThreeId(cthId, page);
		page.setData(products);
		return page;
	}
}
