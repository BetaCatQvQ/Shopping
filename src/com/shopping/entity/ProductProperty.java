package com.shopping.entity;

import java.math.BigInteger;

public class ProductProperty {
	/**
	 * 产品属性编号
	 */
	private BigInteger productPropertyId;
	/**
	 * 二级菜单
	 */
	private CategoryTwo categoryTwo;
	/**
	 * 产品属性名称
	 */
	private String productPropertyName;

	// getter --- setter
	public BigInteger getProductPropertyId() {
		return productPropertyId;
	}

	public void setProductPropertyId(BigInteger productPropertyId) {
		this.productPropertyId = productPropertyId;
	}

	public CategoryTwo getCategoryTwo() {
		return categoryTwo;
	}

	public void setCategoryTwo(CategoryTwo categoryTwo) {
		this.categoryTwo = categoryTwo;
	}

	public String getProductPropertyName() {
		return productPropertyName;
	}

	public void setProductPropertyName(String productPropertyName) {
		this.productPropertyName = productPropertyName;
	}

}
