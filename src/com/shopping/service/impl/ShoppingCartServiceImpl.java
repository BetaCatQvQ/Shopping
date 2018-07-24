package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ShoppingCartDao;
import com.shopping.entity.ShoppingCart;
import com.shopping.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Resource
	private ShoppingCartDao scDao;

	@Override
	public Integer getUserShoppingCarCount(BigInteger userId) {
		return scDao.getUserShoppingCarCount(userId);
	}

	@Override
	public List<ShoppingCart> getUserShoppingCar(BigInteger userId) {
		return scDao.getUserShoppingCar(userId);
	}
}
