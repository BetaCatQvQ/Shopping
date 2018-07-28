package com.shopping.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.shopping.entity.User;
import com.shopping.service.ShoppingCartService;
import com.shopping.service.UserService;
import com.shopping.util.HttpVal;
import com.shopping.util.HttpVal.LoginStatus;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService uService;
	
	@Resource
	private ShoppingCartService scService;

	@GetMapping("/login")
	public String gotoLogin() {
		return "loginPage";
	}

	@RequestMapping("/beginLogin")
	public String commonLogin(HttpSession session, User user) {
		User newUser = uService.commonUserLogin(user.getUserName(), user.getUserPwd());
		session.setAttribute(HttpVal.SESSION_COMMON_USER_KEY, newUser);
		if (newUser != null) {
			Integer shoppingCarNum = scService.getUserShoppingCarCount(newUser.getUserId());
			session.setAttribute(HttpVal.SHOPPING_CAR_COUNT_KEY, shoppingCarNum);
		}
		return "redirect:/home.action";
	}

	@PostMapping("/login")
	public @ResponseBody String login(HttpSession session, User user) {
		User newUser = uService.commonUserLogin(user.getUserName(), user.getUserPwd());
		session.setAttribute(HttpVal.SESSION_COMMON_USER_KEY, newUser);
		if (newUser != null) {
			Integer shoppingCarNum = scService.getUserShoppingCarCount(newUser.getUserId());
			session.setAttribute(HttpVal.SHOPPING_CAR_COUNT_KEY, shoppingCarNum);
			return HttpVal.LoginStatus.LOGIN_STATUS_SUCCESS;
		}
		return String.format(HttpVal.LoginStatus.LOGIN_STATUS_FAILED_MSG,"用户名或密码错误");
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home.action";
	}
	
	@GetMapping(value = "/register")
	public String gotoRegister() {
		return "registerPage";
	}
	
	@PostMapping(value = "/register")
	public String register(User user,HttpSession session) {
		session.setAttribute(HttpVal.SESSION_COMMON_USER_KEY, uService.register(user));
		return "registerSuccessPage";
	}
}
