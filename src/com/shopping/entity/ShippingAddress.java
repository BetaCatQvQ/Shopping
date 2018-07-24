package com.shopping.entity;

 /**
 * 收货地址类
 * @author blank
 */
public class ShippingAddress{
	/**
	 * 地址,电话,姓名,邮政编码
	 */
	private String address,phone,userName,postalcode;
	
	public ShippingAddress() {
	}

	public ShippingAddress(String address, String phone, String userName, String postalcode) {
		this.address = address;
		this.phone = phone;
		this.userName = userName;
		this.postalcode = postalcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	@Override
	public String toString() {
		return "ShippingAddress [address=" + address + ", phone=" + phone + ", userName=" + userName
				+ ", postalcode=" + postalcode + "]";
	}
	
}