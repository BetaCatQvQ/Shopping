package com.shopping.entity;

import java.math.BigInteger;
import java.util.Date;

public class Product {
	/**
	 * 产品编号
	 */
	private BigInteger productId;
	/**
	 * 三级分类
	 */
	private CategoryThree categoryThree;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 产品上架日期
	 */
	private Date productCreateDate;

	// getter --- setter
	public BigInteger getProductId() {
		return productId;
	}

	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}

	public CategoryThree getCategoryThree() {
		return categoryThree;
	}

	public void setCategoryThree(CategoryThree categoryThree) {
		this.categoryThree = categoryThree;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getProductCreateDate() {
		return productCreateDate;
	}

	public void setProductCreateDate(Date productCreateDate) {
		this.productCreateDate = productCreateDate;
	}
}
