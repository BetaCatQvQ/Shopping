package com.shopping.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.UserDao;
import com.shopping.entity.User;
import com.shopping.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao uDao;

	@Override
	public User commonUserLogin(String username, String pwd) {
		return uDao.commonUserLogin(username, pwd);
	}
}
