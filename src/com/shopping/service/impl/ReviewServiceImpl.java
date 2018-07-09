package com.shopping.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ReviewDao;
import com.shopping.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Resource
	private ReviewDao rDao;
}
