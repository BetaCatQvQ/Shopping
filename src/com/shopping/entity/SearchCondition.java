package com.shopping.entity;

public class SearchCondition {
	/**
	 * 三级分类编号
	 */
	private Integer cthId = -1;
	/**
	 * 需要查询的页码
	 */
	private Integer pageNo = 1;
	/**
	 * 关键字
	 */
	private String keywords = "";

	/**
	 * 综合
	 */
	private Integer comprehensive = 1;

	/**
	 * 新品
	 */
	private Integer newProduct = 0;

	/**
	 * 销售量
	 */
	private Integer salesVolume = 0;

	/**
	 * 价格
	 */
	private Integer price = 0;

	public Integer getCthId() {
		return cthId;
	}

	public void setCthId(Integer cthId) {
		this.cthId = cthId;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getComprehensive() {
		return comprehensive;
	}

	public void setComprehensive(Integer comprehensive) {
		this.comprehensive = comprehensive;
	}

	public Integer getNewProduct() {
		return newProduct;
	}

	public void setNewProduct(Integer newProduct) {
		this.newProduct = newProduct;
	}

	public Integer getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	// getter -- setter
	

}
