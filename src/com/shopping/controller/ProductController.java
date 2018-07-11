package com.shopping.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entity.Product;
import com.shopping.service.ProductDetailImageService;
import com.shopping.service.ProductPropertyValueService;
import com.shopping.service.ProductService;

@Controller
@RequestMapping("/product/{id}")
public class ProductController {

	@Resource
	ProductService pService;
	
	@Resource
	ProductPropertyValueService ppService;
	
	@Resource
	ProductDetailImageService pdiService;
	
	@RequestMapping()
	public String productDetail(@PathVariable("id") Long id, HttpSession session) {
		session.setAttribute("product", pService.getProductById(id));
		session.setAttribute("propertyValues", ppService.getPropertysByProductId(id));
		session.setAttribute("productDetailImages", pdiService.getImagesByProductId(id));
		System.out.println("product");
		return "product";
	}

}
