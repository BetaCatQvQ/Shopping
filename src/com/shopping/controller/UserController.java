package com.shopping.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entity.User;
import com.shopping.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService uService;

	@RequestMapping("/login")
	public String commonLogin(HttpSession session, User user) {
		User newUser = uService.commonUserLogin(user.getUserName(), user.getUserPwd());
		System.out.println(newUser);
		return null;
	}
}
