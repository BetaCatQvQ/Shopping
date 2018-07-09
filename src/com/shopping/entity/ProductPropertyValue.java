package com.shopping.entity;

import java.math.BigInteger;

public class ProductPropertyValue {
	/**
	 * 产品属性值编号
	 */
	private BigInteger productPropertyValueId;
	/**
	 * 产品属性
	 */
	private ProductProperty productProperty;
	/**
	 * 产品
	 */
	private Product product;
	/**
	 * 产品属性值名称
	 */
	private String productPropertyValueName;

	// getter --- setter
	public BigInteger getProductPropertyValueId() {
		return productPropertyValueId;
	}

	public void setProductPropertyValueId(BigInteger productPropertyValueId) {
		this.productPropertyValueId = productPropertyValueId;
	}

	public ProductProperty getProductProperty() {
		return productProperty;
	}

	public void setProductProperty(ProductProperty productProperty) {
		this.productProperty = productProperty;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductPropertyValueName() {
		return productPropertyValueName;
	}

	public void setProductPropertyValueName(String productPropertyValueName) {
		this.productPropertyValueName = productPropertyValueName;
	}

}
