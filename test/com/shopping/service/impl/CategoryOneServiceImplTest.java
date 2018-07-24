package com.shopping.service.impl;

import java.util.Map;

import org.junit.Test;

import com.shopping.service.CategoryOneService;
import com.shopping.util.SpringTool;

public class CategoryOneServiceImplTest {
	private CategoryOneService coService = SpringTool.getBean(CategoryOneServiceImpl.class);

	@Test
	public void getAllListAndTop5ProductsTest() {
		Map<String, Object> coList = coService.getAllListAndTop5Products();
		System.out.println("------test---------");
	}
}
