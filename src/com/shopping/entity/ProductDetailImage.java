package com.shopping.entity;

import java.math.BigInteger;

public class ProductDetailImage {
	/**
	 * 产品详情图片编号
	 */
	private BigInteger productDetailImageId;
	/**
	 * 产品
	 */
	private Product product;
	/**
	 * 产品详情图片路径
	 */
	private String productDetailImagePath;

	// getter --- setter
	public BigInteger getProductDetailImageId() {
		return productDetailImageId;
	}

	public void setProductDetailImageId(BigInteger productDetailImageId) {
		this.productDetailImageId = productDetailImageId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductDetailImagePath() {
		return productDetailImagePath;
	}

	public void setProductDetailImagePath(String productDetailImagePath) {
		this.productDetailImagePath = productDetailImagePath;
	}

}
