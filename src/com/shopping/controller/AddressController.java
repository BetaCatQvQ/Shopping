package com.shopping.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.shopping.service.AddressService;

@Controller
public class AddressController {
	@Resource
	private AddressService aService;
}
