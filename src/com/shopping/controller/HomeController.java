package com.shopping.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.service.CategoryOneService;

@Controller
public class HomeController {
	@Resource
	private CategoryOneService coService;

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("categoriesAndProduct", coService.getAllListAndTop5Products());
		return "index";
	}
}
