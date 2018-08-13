package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ReviewDao;
import com.shopping.entity.Review;
import com.shopping.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Resource
	private ReviewDao rDao;

	@Override
	public List<Review> findReviewByProdyctTypeId(Long productTypeId) {
		return rDao.findReviewByProdyctTypeId(productTypeId);
	}

	@Override
	public Integer addReview(BigInteger orderItemId, BigInteger userId, String content) {
		return rDao.review(orderItemId,userId,content,new Date());
	}
}
