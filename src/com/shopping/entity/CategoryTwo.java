package com.shopping.entity;

import java.util.List;

public class CategoryTwo {
	/**
	 * 二级菜单编号
	 */
	private Integer categoryTwoId;
	/**
	 * 一级菜单
	 */
	private CategoryOne categoryOne;
	/**
	 * 二级菜单名称
	 */
	private String categoryTwoName;
	
	/**
	 * 三级菜单
	 */
	private List<CategoryThree> CategoryThrees;

	// getter --- setter
	public Integer getCategoryTwoId() {
		return categoryTwoId;
	}

	public void setCategoryTwoId(Integer categoryTwoId) {
		this.categoryTwoId = categoryTwoId;
	}

	public CategoryOne getCategoryOne() {
		return categoryOne;
	}

	public void setCategoryOne(CategoryOne categoryOne) {
		this.categoryOne = categoryOne;
	}

	public String getCategoryTwoName() {
		return categoryTwoName;
	}

	public void setCategoryTwoName(String categoryTwoName) {
		this.categoryTwoName = categoryTwoName;
	}

	public List<CategoryThree> getCategoryThrees() {
		return CategoryThrees;
	}

	public void setCategoryThrees(List<CategoryThree> categoryThrees) {
		CategoryThrees = categoryThrees;
	}

}
