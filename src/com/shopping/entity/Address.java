package com.shopping.entity;

public class Address {
	/**
	 * �ջ���ַ���
	 */
	private Integer addressId;
	/**
	 * �û�
	 */
	private User user;
	/**
	 * �ջ���ַ����
	 */
	private String addressName;
	/**
	 * �ջ���
	 */
	private String consignee;
	/**
	 * �ֻ�����
	 */
	private String phone;

	// getter -- setter
	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
