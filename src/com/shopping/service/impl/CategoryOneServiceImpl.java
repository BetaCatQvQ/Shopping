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
		// ��ѯһ������
		List<CategoryOne> categoryOnes = coDao.getAllList();
		// ��Map�洢һ��������������top5����Ʒ��KeyֵΪһ��������
		Map<Integer, List<Map<String, Object>>> productes = new HashMap<>();
		// ����һ������
		categoryOnes.forEach(co -> {
			// ��ȡһ��������
			Integer categoryOneId = co.getCategoryOneId();
			// ��ѯһ��������������top5����Ʒ
			List<Map<String, Object>> p = pDao.getProductListByCategoryOneId(co.getCategoryOneId());
			if (p.size() != 0) {
				// ����map
				productes.put(categoryOneId, p);
			}
		});

		// ����map����
		Map<String, Object> data = new HashMap<>();
		data.put("categoryOnes", categoryOnes);
		data.put("productes", productes);
		return data;
	}
}
