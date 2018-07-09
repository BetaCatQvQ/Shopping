package com.shopping.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.CategoryTwoDao;
import com.shopping.service.CategoryTwoService;
@Service
public class CategoryTwoServiceImpl implements CategoryTwoService{
	@Resource
	private CategoryTwoDao ctDao;
}
