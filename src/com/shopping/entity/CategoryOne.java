package com.shopping.entity;

import java.util.List;

public class CategoryOne {
	/**
	 * 一级菜单编号
	 */
	private Integer categoryOneId;
	/**
	 * 一级菜单名称
	 */
	private String categoryOneName;

	/**
	 * 二级菜单
	 */
	private List<CategoryTwo> categoryTwos;

	// getter --- setter
	public Integer getCategoryOneId() {
		return categoryOneId;
	}

	public void setCategoryOneId(Integer categoryOneId) {
		this.categoryOneId = categoryOneId;
	}

	public String getCategoryOneName() {
		return categoryOneName;
	}

	public void setCategoryOneName(String categoryOneName) {
		this.categoryOneName = categoryOneName;
	}

	public List<CategoryTwo> getCategoryTwos() {
		return categoryTwos;
	}

	public void setCategoryTwos(List<CategoryTwo> categoryTwos) {
		this.categoryTwos = categoryTwos;
	}

}
