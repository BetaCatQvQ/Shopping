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
import com.shopping.service.ShoppingCartService;
import com.shopping.util.HttpVal;

@Controller
@RequestMapping("/common/order")
public class OrderController {

	@Resource
	OrderService oService;

	@Resource
	ProductTypeService ptService;

	@Resource
	ShoppingCartService scService;

	@RequestMapping
	public String order(HttpSession session, Integer pageNo, String orderStatus, Model model) {
		Optional<User> userOpt = Optional.ofNullable((User) session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY));
		userOpt.ifPresent(user -> {
			Page<Order> page = new Page<Order>(pageNo);
			page = oService.findOrderByUserId(user.getUserId(), page, orderStatus == null ? "all" : orderStatus);
			model.addAttribute("page_def", page);
			model.addAttribute("orders", page.getData());
		});
		return "bought";
	}

	@RequestMapping("/createOrder")
	public String createOrder(String message, String[] productTypeIdAndNumber,
			@ModelAttribute("address") Address address, @SessionAttribute(HttpVal.SESSION_COMMON_USER_KEY) User user,
			Model model,HttpSession session) {
		// 存储订单项
		List<OrderItem> oiList = new ArrayList<>();
		for (String string : productTypeIdAndNumber) {
			// 分割数据
			String[] ptIdAndNum = string.split("-");
			OrderItem oi = new OrderItem();
			oi.setProductType(ptService.findById(Long.parseLong(ptIdAndNum[0])));
			oi.setQuantity(Integer.parseInt(ptIdAndNum[1]));
			oi.setStatus(0);
			oiList.add(oi);
		}
		// 添加订单
		address = new Address();
		address.setAddressId(1);
		Order order = oService.createOrder(user, oiList, address);
		model.addAttribute("order", order);
		// 删除购物车里面的商品
		if (order != null) {
			for (String string : productTypeIdAndNumber) {
				String[] ptIdAndNum = string.split("-");
				scService.delShoppingCartByProductTypeId(user.getUserId(), new BigInteger(ptIdAndNum[0]));
			}
			resetCartNum(session);
		}

		return "confirmPay";
	}

	@GetMapping("/payOrder/{orderId}")
	public String payOrder(@PathVariable("orderId") BigInteger orderid,
			@SessionAttribute(HttpVal.SESSION_COMMON_USER_KEY) User user, Model model) {
		Order order = oService.findOrderById(orderid);
		order.setUser(user);
		model.addAttribute("order", order);
		return "confirmPay";
	}

	@PostMapping("/delOrder/{orderid}")
	public @ResponseBody String delOrder(@PathVariable("orderid") BigInteger orderId, HttpSession session) {
		User user = (User) session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY);
		return oService.delOrder(user, orderId);
	}

	// method
	/**
	 * 重新设置购物车数量
	 * 
	 * @param session
	 * @param userId用户编号
	 */
	public void resetCartNum(HttpSession session) {
		// 查询购物车里的商品项的数量，然后放入session
		User user = (User) session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY);
		Integer shoppingCarNum = scService.getUserShoppingCarCount(user.getUserId());
		session.setAttribute(HttpVal.SHOPPING_CAR_COUNT_KEY, shoppingCarNum);
	}

}
