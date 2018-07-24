package com.shopping.entity;

public class SearchCondition {
	/**
	 * ����������
	 */
	private Integer cthId = -1;
	/**
	 * ��Ҫ��ѯ��ҳ��
	 */
	private Integer pageNo = 1;
	/**
	 * �ؼ���
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
