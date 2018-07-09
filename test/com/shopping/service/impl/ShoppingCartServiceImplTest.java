package com.shopping.service.impl;

import javax.annotation.Resource;

import com.shopping.service.ShoppingCartService;
import com.shopping.util.SpringTool;

public class ShoppingCartServiceImplTest implements ShoppingCartService {
	@Resource
	private ShoppingCartService scService = SpringTool.getBean(ShoppingCartServiceImpl.class);
}
