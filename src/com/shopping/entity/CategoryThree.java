package com.shopping.entity;

import java.util.List;

public class CategoryThree {
	/**
	 * �����˵����
	 */
	private Integer categoryThreeId;
	/**
	 * �����˵�
	 */
	private CategoryTwo categoryTwo;
	/**
	 * �����˵�����
	 */
	private String categoryThreeName;

	/**
	 * ��Ʒ�б�
	 */
	private List<Product> products;

	// getter --- setter
	public Integer getCategoryThreeId() {
		return categoryThreeId;
	}

	public void setCategoryThreeId(Integer categoryThreeId) {
		this.categoryThreeId = categoryThreeId;
	}

	public CategoryTwo getCategoryTwo() {
		return categoryTwo;
	}

	public void setCategoryTwo(CategoryTwo categoryTwo) {
		this.categoryTwo = categoryTwo;
	}

	public String getCategoryThreeName() {
		return categoryThreeName;
	}

	public void setCategoryThreeName(String categoryThreeName) {
		this.categoryThreeName = categoryThreeName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
