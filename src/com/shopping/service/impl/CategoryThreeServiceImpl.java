package com.shopping.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.CategoryThreeDao;
import com.shopping.service.CategoryThreeService;

@Service
public class CategoryThreeServiceImpl implements CategoryThreeService{
	@Resource
	private CategoryThreeDao ctDao;
}
