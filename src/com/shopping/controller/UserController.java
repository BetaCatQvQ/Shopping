package com.shopping.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entity.User;
import com.shopping.service.ShoppingCartService;
import com.shopping.service.UserService;
import com.shopping.util.HttpVal;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService uService;

	@Resource
	private ShoppingCartService scService;

	@RequestMapping("/login")
	public String login() {
		return "loginPage";
	}

	@RequestMapping("/beginLogin")
	public String commonLogin(HttpSession session, User user) {
		// 查询用户放入session
		User newUser = uService.commonUserLogin(user.getUserName(), user.getUserPwd());
		session.setAttribute(HttpVal.SESSION_COMMON_USER_KEY, newUser);
		// 查询购物车里的商品项的数量，然后放入session
		if (newUser != null) {
			Integer shoppingCarNum = scService.getUserShoppingCarCount(newUser.getUserId());
			session.setAttribute(HttpVal.SHOPPING_CAR_COUNT_KEY, shoppingCarNum);
		}
		return "redirect:/home.action";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// 删除用户
		session.removeAttribute(HttpVal.SESSION_COMMON_USER_KEY);
		// 删除购物车信息
		session.removeAttribute(HttpVal.SHOPPING_CAR_COUNT_KEY);
		return "redirect:/home.action";
	}
}
