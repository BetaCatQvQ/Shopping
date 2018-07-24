package com.shopping.entity;

import java.util.List;

public class Page<T> {
	/**
	 * 要查询的页号，默认第1页
	 */
	private Integer pageNo = 1;
	/**
	 * 每页的记录数，默认30条
	 */
	private Integer pageCount = 30;
	/**
	 * 查询起始行
	 */
	private Integer startRow;
	/**
	 * 存储查询的数据
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
	 * @param pageNo页号
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
