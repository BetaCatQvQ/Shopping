package com.shopping.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.shopping.annotation.FK;
import com.shopping.annotation.ID;

public class Order {
	/**
	 * 订单编号
	 */
	@ID
	private BigInteger orderId;
	/**
	 * 用户
	 */
	@FK
	private User user = new User();
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
	/**
	 * 收货地址
	 */
	@FK
	private Address address = new Address();

	private String remark;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
