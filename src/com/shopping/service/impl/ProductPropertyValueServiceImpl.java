package com.shopping.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductPropertyValueDao;
import com.shopping.entity.ProductPropertyValue;
import com.shopping.service.ProductPropertyValueService;

@Service
public class ProductPropertyValueServiceImpl implements ProductPropertyValueService {
	@Resource
	private ProductPropertyValueDao ppvDao;

	@Override
	public List<ProductPropertyValue> getPropertysByProductId(Long id) {
		if (id == null) {
			return null;
		}
		return ppvDao.getPropertysByProductId(id);
	}
}
