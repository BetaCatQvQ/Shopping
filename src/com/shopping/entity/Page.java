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
	 * ��¼����
	 */
	private Integer rowTotal;
	/**
	 * ҳ������
	 */
	private Integer pageTotal;
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
		calcStartRow();
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
		calcStartRow();
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

	public Integer getRowTotal() {
		return rowTotal;
	}

	public void setRowTotal(Integer rowTotal) {
		this.rowTotal = rowTotal;
		this.pageTotal = (this.rowTotal - 1) / this.pageCount + 1;
	}

	public Integer getPageTotal() {
		return pageTotal;
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
		calcStartRow();
	}

	public Page() {
	}

	// method
	/**
	 * calc Start Row
	 */
	public void calcStartRow() {
		this.startRow = (pageNo - 1) * pageCount;
	}

}
