package com.shopping.service;

import java.util.List;

import com.shopping.entity.Review;

public interface ReviewService {
	
	List<Review> findReviewByProdyctTypeId(Long productTypeId);
}
