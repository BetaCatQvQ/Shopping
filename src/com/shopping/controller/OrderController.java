package com.shopping.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.shopping.entity.Address;
import com.shopping.entity.Order;
import com.shopping.entity.OrderItem;
import com.shopping.entity.Page;
import com.shopping.entity.User;
import com.shopping.service.OrderService;
import com.shopping.service.ProductTypeService;
import com.shopping.util.HttpVal;

@Controller
@RequestMapping("/common/order")
public class OrderController {

	@Resource
	OrderService oService;

	@Resource
	ProductTypeService ptService;

	@RequestMapping
	public String order(HttpSession session, Integer pageNo,String orderStatus, Model model) {
		Optional<User> userOpt = Optional.ofNullable((User) session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY));
		userOpt.ifPresent(user -> {
			Page<Order> page = new Page<Order>(pageNo);
			page = oService.findOrderByUserId(user.getUserId(), page,orderStatus==null?"all":orderStatus);
			model.addAttribute("page_def", page);
			model.addAttribute("orders", page.getData());
		});
		return "bought";
	}

	@PostMapping("/createOrder")
	public String createOrder(String message, Long productTypeId, Integer number,
			Integer addressId,
			@SessionAttribute(HttpVal.SESSION_COMMON_USER_KEY) User user, Model model) {
		OrderItem item = new OrderItem();
		Address address = new Address();
		address.setAddressId(addressId);
		item.setProductType(ptService.findById(productTypeId));
		item.setQuantity(number);
		item.setStatus(0);
		item.setRemark(message == null ? "" : message);
		List<OrderItem> items = new ArrayList<>();
		items.add(item);
		model.addAttribute("order", oService.createOrder(user, items,address));
		return "confirmPay";
	}

	@GetMapping("/payOrder/{orderId}")
	public String payOrder(@PathVariable("orderId") BigInteger orderid,
						   @SessionAttribute(HttpVal.SESSION_COMMON_USER_KEY) User user, 
						   Model model) {
		Order order = oService.findOrderById(orderid);		
		order.setUser(user);
		model.addAttribute("order", order);
		return "confirmPay";
	}

	@PostMapping("/delOrder/{orderid}")
	public @ResponseBody String delOrder(@PathVariable("orderid") BigInteger orderId,HttpSession session) {
		User user = (User)session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY);
		return oService.delOrder(user, orderId);
	}
	
	
}
