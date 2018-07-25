package com.shopping.controller;

import java.util.Optional;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entity.ProductType;
import com.shopping.service.ProductTypeService;
import com.shopping.service.ReviewService;

@Controller
@RequestMapping("/product/{id}")
public class ProductController {

	@Resource
	ProductTypeService ptSerivce;
	
	@Resource
	ReviewService rService;

	@RequestMapping
	public String productDetail(@PathVariable("id") Long id, Model model) {
		Optional<ProductType> productTypeOpt = Optional.ofNullable(ptSerivce.findById(id));
		productTypeOpt.ifPresent(item -> {
			model.addAttribute("defaultProduct", item);
			model.addAttribute("product", item.getProduct());
			model.addAttribute("productTypes", ptSerivce.findByProductId(item.getProduct().getProductId()));
			model.addAttribute("reviews", rService.findReviewByProdyctTypeId(id));
			model.addAttribute("salesVolume", ((Double)(Math.random() * 1000)).intValue());
		});
		return productTypeOpt.isPresent() ? "product" : "404";
	}

}
