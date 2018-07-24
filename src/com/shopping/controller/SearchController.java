package com.shopping.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entity.Page;
<<<<<<< HEAD
=======
import com.shopping.entity.SearchCondition;
>>>>>>> 321d01f818697788897939feda38b5d813fff1b5
import com.shopping.service.ProductService;

@Controller
public class SearchController {

	@Resource
	private ProductService pService;

<<<<<<< HEAD
	@RequestMapping("/search")
	public String search(Model model, Integer cthId, Integer pageNo) {
		Page<Map<String, Object>> page = new Page<>(1);
		page = this.pService.getProductListByCategoryThreeId(cthId, page);
=======
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
>>>>>>> 321d01f818697788897939feda38b5d813fff1b5
		model.addAttribute("page", page);
		return "searchResult";
	}
}
