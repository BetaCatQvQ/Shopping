package com.shopping.entity;

import java.math.BigInteger;
import java.sql.Date;

public class Review {
	/**
	 * 评论编号
	 */
	private BigInteger reviewId;
	/**
	 * 用户
	 */
	private User user;
	/**
	 * 订单项
	 */
	private OrderItem orderItem;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 评论日期
	 */
	private Date reviewCreateDate;

	// getter --- setter
	public BigInteger getReviewId() {
		return reviewId;
	}

	public void setReviewId(BigInteger reviewId) {
		this.reviewId = reviewId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReviewCreateDate() {
		return reviewCreateDate;
	}

	public void setReviewCreateDate(Date reviewCreateDate) {
		this.reviewCreateDate = reviewCreateDate;
	}

}
