package com.shopping.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.CategoryOneDao;
import com.shopping.dao.ProductDao;
import com.shopping.entity.CategoryOne;
import com.shopping.service.CategoryOneService;

@Service
public class CategoryOneServiceImpl implements CategoryOneService {
	@Resource
	private CategoryOneDao coDao;

	@Resource
	private ProductDao pDao;

	@Override
	public Map<String, Object> getAllListAndTop5Products() {
		// 查询一级分类
		List<CategoryOne> categoryOnes = coDao.getAllList();
		// 用Map存储一级分类下销售量top5的商品，Key值为一级分类编号
		Map<Integer, List<Map<String, Object>>> productes = new HashMap<>();
		// 遍历一级分类
		categoryOnes.forEach(co -> {
			// 获取一级分类编号
			Integer categoryOneId = co.getCategoryOneId();
			// 查询一级分类下销售量top5的商品
			List<Map<String, Object>> p = pDao.getProductListByCategoryOneId(co.getCategoryOneId());
			if (p.size() != 0) {
				// 存入map
				productes.put(categoryOneId, p);
			}
		});

		// 返回map集合
		Map<String, Object> data = new HashMap<>();
		data.put("categoryOnes", categoryOnes);
		data.put("productes", productes);
		return data;
	}
}
