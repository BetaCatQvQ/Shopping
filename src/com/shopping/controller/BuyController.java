package com.shopping.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entity.ProductType;
import com.shopping.entity.ShoppingCart;
import com.shopping.entity.User;
import com.shopping.service.OrderItemService;
import com.shopping.service.OrderService;
import com.shopping.service.ProductTypeService;
import com.shopping.service.ShoppingCartService;
import com.shopping.util.HttpVal;

@Controller
@RequestMapping("/common/buy")
public class BuyController {

	@Resource
	ProductTypeService ptService;

	@Resource
	OrderService oService;

	@Resource
	OrderItemService oiService;

	@Resource
	ShoppingCartService scService;

	@GetMapping("/one/{productTypeId}-{number}")
	public String buyOne(@PathVariable("productTypeId") final Long productTypeId,
			@PathVariable("number") Integer number, Model model) {
		Optional<ProductType> ptOptional = Optional.ofNullable(ptService.findById(productTypeId));
		if (ptOptional.isPresent()) {
			if (ptOptional.get().getRestQuantity() < number) {
				model.addAttribute("msg", "Exceeding stock please to re-select!");
				number = 1;
			}
			model.addAttribute("item", ptOptional.get());
			model.addAttribute("number", number);
			model.addAttribute("total", number * ptOptional.get().getSalePrice());
		}
		return "buyPage";
	}

	@GetMapping("/confirmed/{orderId}")
	public String comfirmed(@PathVariable("orderId") Long orderId) {
		if (orderId != null) {
			oiService.changeOrderStatus(1, orderId);
		}
		return "orderConfirmedPage";
	}

	@PostMapping("/createOrder")
	public String createOrder(Model model, HttpSession session, Integer[] scId) {
		User user = (User) session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY);
		List<ShoppingCart> scList = scService.getByUserIdAndShoppingCartIds(scId, user.getUserId());
		model.addAttribute("items", scList);

		// ¼ÆËã½ð¶î
		Float total = 0f;
		for (ShoppingCart sc : scList) {
			Float price = sc.getProductType().getPrice() * sc.getQuantity();
			total += price;
		}
		model.addAttribute("total", total);
		return "buyPage";
	}
}
