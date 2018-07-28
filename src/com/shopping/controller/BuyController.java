package com.shopping.controller;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entity.ProductType;
import com.shopping.service.OrderItemService;
import com.shopping.service.OrderService;
import com.shopping.service.ProductTypeService;

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
}
