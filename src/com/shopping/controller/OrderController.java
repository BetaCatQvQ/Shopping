package com.shopping.controller;

import java.math.BigInteger;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entity.User;
import com.shopping.service.OrderService;
import com.shopping.util.HttpVal;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Resource
	OrderService oService;
	
	@RequestMapping
	public String order(HttpSession session, Model model) {
		User u = new User();
		u.setUserId(new BigInteger("1"));
		session.setAttribute(HttpVal.SESSION_COMMON_USER_KEY,u);
		Optional<User> userOpt = Optional.ofNullable((User)session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY));
//		if (!userOpt.isPresent()) {
//			return "loginPage";
//		}
		userOpt.ifPresent(user ->{
			model.addAttribute("orders", oService.findOrderByUserId(user.getUserId()));
		});
		return "bought";
	}
	
}
