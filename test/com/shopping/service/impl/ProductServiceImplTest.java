package com.shopping.service.impl;

import java.util.Map;

import org.junit.Test;

import com.shopping.entity.Page;
<<<<<<< HEAD
=======
import com.shopping.entity.SearchCondition;

>>>>>>> 321d01f818697788897939feda38b5d813fff1b5
import com.shopping.service.ProductService;
import com.shopping.util.SpringTool;

public class ProductServiceImplTest {
	private ProductService userService = SpringTool.getBean(ProductServiceImpl.class);

<<<<<<< HEAD
	@Test
	public void getProductListByCategoryThreeIdTest() {
		Page<Map<String, Object>> page = new Page<>(1);
		page = userService.getProductListByCategoryThreeId(1, page);
=======

	@Test
	public void getProductListByCategoryThreeIdTest() {
		SearchCondition sc = new SearchCondition();
		sc.setPageNo(1);
		sc.setKeywords("È«Ãæ");
		Page<Map<String, Object>> page = userService.getProductListByCondition(sc);
>>>>>>> 321d01f818697788897939feda38b5d813fff1b5
		System.out.println("-----------testList-----------");
	}
}
