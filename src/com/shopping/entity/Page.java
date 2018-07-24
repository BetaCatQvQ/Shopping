package com.shopping.entity;

import java.util.List;

public class Page<T> {
	/**
	 * Ҫ��ѯ��ҳ�ţ�Ĭ�ϵ�1ҳ
	 */
	private Integer pageNo = 1;
	/**
	 * ÿҳ�ļ�¼����Ĭ��30��
	 */
	private Integer pageCount = 30;
	/**
	 * ��ѯ��ʼ��
	 */
	private Integer startRow;
	/**
	 * �洢��ѯ������
	 */
	private List<T> data;

	// getter -- setter
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
		this.startRow = (pageNo - 1) * pageCount;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	/**
	 * 
	 * @param pageNoҳ��
	 */
	public Page(Integer pageNo) {
		super();
		if (pageNo == null) {
			pageNo = 1;
		}
		this.pageNo = pageNo;
		this.startRow = (pageNo - 1) * pageCount;
	}

}
