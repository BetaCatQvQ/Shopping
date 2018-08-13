package com.shopping.service;

import java.math.BigInteger;
import java.util.List;

import com.shopping.entity.Review;

public interface ReviewService {
	
	List<Review> findReviewByProdyctTypeId(Long productTypeId);
	
	Integer addReview(BigInteger orderItemId,BigInteger userId,String content);
}
