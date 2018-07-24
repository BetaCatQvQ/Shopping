package com.shopping.service.impl;

import java.math.BigInteger;

import javax.annotation.Resource;

import org.junit.Test;

import com.shopping.service.ShoppingCartService;
import com.shopping.util.SpringTool;

public class ShoppingCartServiceImplTest {
	@Resource
	private ShoppingCartService scService = SpringTool.getBean(ShoppingCartServiceImpl.class);

	@Test
	public void getUserShoppingCarCountTest() {
		Integer shoppingCarNum = scService.getUserShoppingCarCount(new BigInteger("1"));
		System.out.println(shoppingCarNum);
	}
}
