package com.shopping.service;

import java.math.BigInteger;
import java.util.List;

import com.shopping.entity.ShoppingCart;

public interface ShoppingCartService {
	public Integer getUserShoppingCarCount(BigInteger userId);

	public List<ShoppingCart> getUserShoppingCar(BigInteger userId);
}
