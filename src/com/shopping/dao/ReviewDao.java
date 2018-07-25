package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Review;

public interface ReviewDao {

	List<Review> findReviewByProdyctTypeId(Long productTypeId);
}
