package com.shopping.controller;

import java.math.BigInteger;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.entity.Address;
import com.shopping.service.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController {
	@Resource
	private AddressService aService;

	@RequestMapping("/add")
	@ResponseBody
	public Integer add(Address address) {
		address = new Address();
		address.setAddressName("ÄÏ¹Ï´óÏÃ");
		address.setConsignee("·ë»ªÅô");
		address.setPhone("1111");
		address.getUser().setUserId(new BigInteger("1"));
		return aService.add(address);
	}
}
