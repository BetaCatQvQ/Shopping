package com.shopping.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entity.ShoppingCart;
import com.shopping.entity.User;
import com.shopping.service.ShoppingCartService;
import com.shopping.util.HttpVal;

@Controller
@RequestMapping("/sc")
public class ShoppingCartController {
	@Resource
	private ShoppingCartService scService;

	@RequestMapping("/common/cart")
	public String showCart(HttpSession session, Model model) {
		User user = (User) session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY);
		List<ShoppingCart> scList = scService.getUserShoppingCar(user.getUserId());
		model.addAttribute(HttpVal.SHOPPING_CAR_LIST_KEY, scList);
		return "cart";
	}
}
