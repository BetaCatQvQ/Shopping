package com.shopping.service.impl;

import org.junit.Test;

import com.shopping.entity.User;
import com.shopping.service.UserService;
import com.shopping.util.SpringTool;

public class UserServiceImplTest {

	private UserService userService = SpringTool.getBean(UserServiceImpl.class);

	@Test
	public void commonUserLoginTest() {
		User user = userService.commonUserLogin("BetaCat", "123");
		System.out.println(user);
	}
}
