package com.shopping.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Review;

public interface ReviewDao {

	List<Review> findReviewByProdyctTypeId(Long productTypeId);

	Integer review(@Param("orderItemId") BigInteger orderItemId,@Param("userId") BigInteger userId,@Param("content") String content,@Param("date") Date date);
}
