package com.shopping.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class ProductType {
	/**
	 * 产品类型编号
	 */
	private BigInteger productTypeId;
	/**
	 * 产品
	 */
	private Product product;
	/**
	 * 产品类型名称
	 */
	private String productTypeName;
	/**
	 * 价格
	 */
	private Float price;
	/**
	 * 优惠价格
	 */
	private Float salePrice;
	/**
	 * 剩余数量
	 */
	private Integer restQuantity;
	/**
	 * 产品类型图片路径
	 */
	private String productTypeImagePath;
	/**
	 * 上架时间
	 */
	private Date productTypeCreateDate;
	/**
	 * 商品描述图片
	 */
	private List<ProductDetailImage> productDetailImages;
	/**
	 * 商品对应的属性
	 */
	private List<ProductPropertyValue> productPropertyValues;
	
	private List<ProductImage> productImages;

	// getter --- setter
	public BigInteger getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(BigInteger productTypeId) {
		this.productTypeId = productTypeId;
	}

	public List<ProductDetailImage> getProductDetailImages() {
		return productDetailImages;
	}

	public void setProductDetailImages(List<ProductDetailImage> productDetailImages) {
		this.productDetailImages = productDetailImages;
	}

	public List<ProductPropertyValue> getProductPropertyValues() {
		return productPropertyValues;
	}

	public void setProductPropertyValues(List<ProductPropertyValue> productPropertyValues) {
		this.productPropertyValues = productPropertyValues;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Float salePrice) {
		this.salePrice = salePrice;
	}

	public Integer getRestQuantity() {
		return restQuantity;
	}

	public void setRestQuantity(Integer restQuantity) {
		this.restQuantity = restQuantity;
	}

	public String getProductTypeImagePath() {
		return productTypeImagePath;
	}

	public void setProductTypeImagePath(String productTypeImagePath) {
		this.productTypeImagePath = productTypeImagePath;
	}

	public Date getProductTypeCreateDate() {
		return productTypeCreateDate;
	}

	public void setProductTypeCreateDate(Date productTypeCreateDate) {
		this.productTypeCreateDate = productTypeCreateDate;
	}

	public List<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

}
