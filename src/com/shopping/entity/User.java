package com.shopping.entity;

import java.math.BigInteger;
import java.util.Date;

import com.shopping.annotation.ID;

public class User {
	/**
	 * 用户编号
	 */
	@ID
	private BigInteger userId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String userPwd;
	/**
	 * 用户角色
	 */
	private Integer role;
	/**
	 * 创建日期
	 */
	private Date userCreateDate;

	// getter --- setter
	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Date getUserCreateDate() {
		return userCreateDate;
	}

	public void setUserCreateDate(Date userCreateDate) {
		this.userCreateDate = userCreateDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", role=" + role
				+ ", userCreateDate=" + userCreateDate + "]";
	}

}
