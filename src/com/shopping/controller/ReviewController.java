package com.shopping.controller;

import java.math.BigInteger;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.shopping.entity.OrderItem;
import com.shopping.entity.User;
import com.shopping.service.ReviewService;
import com.shopping.util.HttpVal;
@Controller
@RequestMapping("/common/review")
public class ReviewController {
	
	@Resource
	ReviewService rService;
	
	@PostMapping("/add") 
	public @ResponseBody String addReview
	(
		BigInteger orderItemId,
		String review,
		@SessionAttribute(HttpVal.SESSION_COMMON_USER_KEY) User user
    ) {
		Integer status = rService.addReview(orderItemId, user.getUserId(), review);
		return String.format("{status:%d}", status);
	}
}
