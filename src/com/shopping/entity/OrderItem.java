package com.shopping.entity;

import java.math.BigInteger;

public class OrderItem {
	/**
	 * ��������
	 */
	private BigInteger orderItemId;
	/**
	 * ��Ʒ����
	 */
	private ProductType productType = new ProductType();
	/**
	 * ����
	 */
	private Order order;
	/**
	 * ����
	 */
	private Integer quantity;
	/**
	 * ��ע
	 */
	private String remark;
	/**
	 * ������״̬
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
