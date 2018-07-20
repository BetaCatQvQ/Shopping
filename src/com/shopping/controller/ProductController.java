package com.shopping.controller;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shopping.service.ProductDetailImageService;
import com.shopping.service.ProductPropertyValueService;
import com.shopping.service.ProductService;
import com.shopping.entity.ProductType;
import com.shopping.service.ProductTypeService;
import com.shopping.entity.ProductType;
import com.shopping.service.ProductTypeService;

@Controller
@RequestMapping("/product/{id}")
public class ProductController {

	@Resource
	ProductTypeService ptSerivce;

	@RequestMapping
	public String productDetail(@PathVariable("id") Long id, Model model) {
		Optional<ProductType> productTypeOpt = Optional.ofNullable(ptSerivce.findById(id));
		productTypeOpt.ifPresent(item -> {
			model.addAttribute("defaultProduct", item);
			model.addAttribute("product", item.getProduct());
			model.addAttribute("productTypes", ptSerivce.findByProductId(item.getProduct().getProductId()));
		});
		return productTypeOpt.isPresent() ? "product" : "404";
	}

}
