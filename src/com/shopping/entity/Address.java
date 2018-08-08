package com.shopping.entity;

import com.shopping.annotation.FK;
import com.shopping.annotation.ID;

public class Address {
	/**
	 * 收货地址编号
	 */
	@ID
	private Integer addressId;
	/**
	 * 用户
	 */
	@FK
	private User user = new User();
	/**
	 * 收货地址名称
	 */
	private String addressName;
	/**
	 * 收货人
	 */
	private String consignee;
	/**
	 * 手机号码
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
	
	// toString
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", user=" + user + ", addressName=" + addressName + ", consignee="
				+ consignee + ", phone=" + phone + "]";
	}

}
