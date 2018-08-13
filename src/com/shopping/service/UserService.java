package com.shopping.service;

import com.shopping.entity.User;

public interface UserService {
	public User commonUserLogin(String username, String pwd);

	User register(User user);

	Integer findUserName(String userName);
}
