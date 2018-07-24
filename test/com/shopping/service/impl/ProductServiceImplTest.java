package com.shopping.service.impl;

import java.util.Map;

import org.junit.Test;

import com.shopping.entity.Page;
import com.shopping.service.ProductService;
import com.shopping.util.SpringTool;

public class ProductServiceImplTest {
	private ProductService userService = SpringTool.getBean(ProductServiceImpl.class);

	@Test
	public void getProductListByCategoryThreeIdTest() {
		Page<Map<String, Object>> page = new Page<>(1);
		page = userService.getProductListByCategoryThreeId(1, page);
		System.out.println("-----------testList-----------");
	}
}
