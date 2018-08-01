package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.UserDao;
import com.shopping.entity.User;
import com.shopping.service.UserService;
import com.shopping.util.SnowFlake;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao uDao;

	@Override
	public User commonUserLogin(String username, String pwd) {
		return uDao.commonUserLogin(username, pwd);
	}

	@Override
	public User register(User user) {
		Optional<User> optional = Optional.ofNullable(user);
		optional.ifPresent(item -> {
			item.setRole(0);
			item.setUserCreateDate(new Date());
			item.setUserId(new BigInteger(SnowFlake.getId().toString()));
			uDao.createUser(item);
		});
		return user;
	}
}
