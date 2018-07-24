package com.shopping.service.impl;

import java.util.Map;

import org.junit.Test;

import com.shopping.entity.Page;
import com.shopping.entity.SearchCondition;

import com.shopping.service.ProductService;
import com.shopping.util.SpringTool;

public class ProductServiceImplTest {
	private ProductService userService = SpringTool.getBean(ProductServiceImpl.class);


	@Test
	public void getProductListByCategoryThreeIdTest() {
		SearchCondition sc = new SearchCondition();
		sc.setPageNo(1);
		sc.setKeywords("È«Ãæ");
		Page<Map<String, Object>> page = userService.getProductListByCondition(sc);
		System.out.println("-----------testList-----------");
	}
}
