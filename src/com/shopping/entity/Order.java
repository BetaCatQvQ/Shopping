package com.shopping.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class Order {
	/**
	 * 订单编号
	 */
	private BigInteger orderId;
	/**
	 * 用户
	 */
	private User user;
	/**
	 * 订单创建时间
	 */
	private Date orderCreateDate;
	
	/**
	 * Order item list 
	 */
	private List<OrderItem> orderItems;
	/**
	 * Total price 
	 */
	private Float total;

	// getter --- setter
	public BigInteger getOrderId() {
		return orderId;
	}

	public void setOrderId(BigInteger orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getOrderCreateDate() {
		return orderCreateDate;
	}

	public void setOrderCreateDate(Date orderCreateDate) {
		this.orderCreateDate = orderCreateDate;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

}
