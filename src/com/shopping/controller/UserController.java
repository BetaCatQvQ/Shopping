package com.shopping.controller;

import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.entity.User;
import com.shopping.service.UserService;
import com.shopping.util.HttpVal;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService uService;
	

	@GetMapping(value = "/login")
	public String gotoLogin() {
		return "loginPage";
	}
	
	@GetMapping(value = "/register")
	public String gotoRegister() {
		return "registerPage";
	}

	@PostMapping(value = "/login")
	public String commonLogin(HttpSession session,User user,Model model) {
		Optional<User> userOpt = Optional.ofNullable(uService.commonUserLogin(user.getUserName(), user.getUserPwd()));
		userOpt.ifPresent(userItem ->{
			session.setAttribute(HttpVal.SESSION_COMMON_USER_KEY, userItem);
		});
		if (!userOpt.isPresent()) {
			model.addAttribute("msg", "用户名或密码不正确");
		}
		return userOpt.isPresent()?"redirect:/home.action":"loginPage";
	}
	
	@PostMapping(value = "/register")
	public String register(User user,HttpSession session) {
		session.setAttribute(HttpVal.SESSION_COMMON_USER_KEY, uService.register(user));
		return "registerSuccessPage";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
