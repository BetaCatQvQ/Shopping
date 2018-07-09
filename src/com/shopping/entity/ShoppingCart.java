package com.shopping.entity;

import java.math.BigInteger;
import java.util.Date;

public class ShoppingCart {
	/**
	 * 购物车编号
	 */
	private BigInteger shoppingCartId;
	/**
	 * 产品类型
	 */
	private ProductType productType;
	/**
	 * 用户
	 */
	private User user;
	/**
	 * 数量
	 */
	private Integer quantity;
	/**
	 * 创建时间
	 */
	private Date shoppingCartCreateDate;

	// getter --- setter
	public BigInteger getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(BigInteger shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public User getUser() {
		return user;
	}

	public void setUserId(User user) {
		this.user = user;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getShoppingCartCreateDate() {
		return shoppingCartCreateDate;
	}

	public void setShoppingCartCreateDate(Date shoppingCartCreateDate) {
		this.shoppingCartCreateDate = shoppingCartCreateDate;
	}

}
