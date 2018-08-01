package com.shopping.controller;

import java.math.BigInteger;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.service.OrderItemService;
import com.shopping.util.HttpVal;

@Controller
@RequestMapping("/orderItem")
public class OrderItemController {

	@Resource OrderItemService oiService;
	
	
	@PostMapping("/change")
	public @ResponseBody String change(BigInteger orderId,BigInteger orderItemId, Integer quantity) {
		Boolean result = oiService.changeOrderItemQuantity(orderId, orderItemId, quantity);
		if (result) {
			return HttpVal.OrderStatus.ORDER_STATUS_SUCCESS;
		}else {
			return HttpVal.OrderStatus.ORDER_STATUS_FAILED;
		}
	}
}
