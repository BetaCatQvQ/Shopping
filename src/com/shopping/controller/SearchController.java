package com.shopping.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entity.Page;
import com.shopping.entity.SearchCondition;
import com.shopping.service.ProductService;

@Controller
public class SearchController {

	@Resource
	private ProductService pService;

	/**
	 * 
	 * @param model
	 * @param cthId三级分类编号
	 * @param pageNo需要查询的页数
	 * @return
	 */
	@RequestMapping("/search")
	public String search(Model model, SearchCondition sc) {
		Page<Map<String, Object>> page = null;
		if (sc.getCthId() != -1 || !"".equals(sc.getKeywords())) {
			page = this.pService.getProductListByCondition(sc);
		}
		model.addAttribute("page", page);
		return "searchResult";
	}
}
