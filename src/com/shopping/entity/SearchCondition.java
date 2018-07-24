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

	// getter -- setter
	public Integer getCthId() {
		return cthId;
	}

	public void setCthId(Integer cthId) {
		if (cthId == null) {
			cthId = -1;
		}
		this.cthId = cthId;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		if (pageNo == null) {
			pageNo = 1;
		}
		this.pageNo = pageNo;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		if (keywords == null) {
			keywords = "";
		}
		this.keywords = keywords;
	}

}
