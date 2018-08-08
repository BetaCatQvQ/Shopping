package com.shopping.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.shopping.entity.ProductType;
import com.shopping.entity.User;
import com.shopping.service.AddressService;
import com.shopping.service.OrderItemService;
import com.shopping.service.OrderService;
import com.shopping.service.ProductTypeService;
import com.shopping.util.HttpVal;

import static java.lang.System.out;

@Controller
@RequestMapping("/common/buy")
public class BuyController {

	@Resource
	ProductTypeService ptService;

	@Resource
	OrderService oService;

	@Resource
	OrderItemService oiService;

	@GetMapping("/one/{productTypeId}-{number}")
	public String buyOne(@PathVariable("productTypeId") final Long productTypeId,
			             @PathVariable("number") Integer number,
			             @SessionAttribute(HttpVal.SESSION_COMMON_USER_KEY) User user,
			             Model model) {
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
	
	@GetMapping
	public String buyForCart(List<Integer> orderItemIds) {
		for(Integer item : orderItemIds) {
			out.println(item);
		}
		return "buyPage";
	}
}
