package com.shopping.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entity.Page;
import com.shopping.service.ProductService;

@Controller
public class SearchController {

	@Resource
	private ProductService pService;

	@RequestMapping("/search")
	public String search(Model model, Integer cthId, Integer pageNo) {
		Page<Map<String, Object>> page = new Page<>(1);
		page = this.pService.getProductListByCategoryThreeId(cthId, page);
		model.addAttribute("page", page);
		return "searchResult";
	}
}
