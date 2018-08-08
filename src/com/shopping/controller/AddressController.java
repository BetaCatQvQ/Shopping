package com.shopping.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.shopping.entity.Address;
import com.shopping.entity.User;
import com.shopping.service.AddressService;
import com.shopping.util.HttpVal;

@Controller
@RequestMapping("/address")
public class AddressController {
	@Resource
	private AddressService aService;

	@GetMapping("/list")
	public @ResponseBody List<Address> list(HttpSession session) {
		User user = (User)session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY);
		if (user == null) {
			return null;
		}
		return aService.findAddressByUser(user.getUserId());
	}

}
