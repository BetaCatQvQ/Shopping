package com.shopping.entity;

import java.math.BigInteger;

public class ProductImage {
	/**
	 * 产品图片编号
	 */
	private BigInteger productImageId;
	/**
	 * 产品
	 */
	private Product product;
	/**
	 * 产品图片路径
	 */
	private String productImagePath;

	// getter --- setter
	public BigInteger getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(BigInteger productImageId) {
		this.productImageId = productImageId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

}
