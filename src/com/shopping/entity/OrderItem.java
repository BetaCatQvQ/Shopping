package com.shopping.entity;

import java.math.BigInteger;

public class OrderItem {
	/**
	 * 订单项编号
	 */
	private BigInteger orderItemId;
	/**
	 * 产品类型
	 */
	private ProductType productType;
	/**
	 * 订单
	 */
	private Order order;
	/**
	 * 数量
	 */
	private Integer quantity;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 订单项状态
	 */
	private Integer status;

	// getter --- setter
	public BigInteger getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(BigInteger orderItemId) {
		this.orderItemId = orderItemId;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
