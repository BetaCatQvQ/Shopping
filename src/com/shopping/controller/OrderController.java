package com.shopping.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entity.OrderItem;
import com.shopping.entity.ShippingAddress;
import com.shopping.entity.User;
import com.shopping.service.OrderService;
import com.shopping.service.ProductTypeService;
import com.shopping.util.HttpVal;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Resource
	OrderService oService;
	
	@Resource
	ProductTypeService ptService;
	
	@RequestMapping
	public String order(HttpSession session, Model model) {
		Optional<User> userOpt = Optional.ofNullable((User)session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY));
		if (!userOpt.isPresent()) {
			return "loginPage";
		}
		userOpt.ifPresent(user ->{
			model.addAttribute("orders", oService.findOrderByUserId(user.getUserId()));
		});
		return "bought";
	}
	
	@PostMapping("/createOrder")
	public String createOrder(String message,
						      Long productTypeId, 
							  Integer number,
							  ShippingAddress address,
							  HttpSession session,
							  Model model) {
		User user = (User)session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY);
		if (Objects.isNull(user)) {
			return "redirect:/user/login.action";
		}
		OrderItem item = new OrderItem();
		item.setProductType(ptService.findById(productTypeId));
		item.setQuantity(number);
		item.setStatus(0);
		item.setRemark(message==null?"":message);
		List<OrderItem> items = new ArrayList<>();
		items.add(item);
		model.addAttribute("order", oService.createOrder(user, items));
		model.addAttribute("address", address);
		return "confirmPay";
	}
	
	
}
