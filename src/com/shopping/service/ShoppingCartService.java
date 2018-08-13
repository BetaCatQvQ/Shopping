package com.shopping.service;

import java.math.BigInteger;
import java.util.List;

import com.shopping.entity.ShoppingCart;

public interface ShoppingCartService {
	public Integer getUserShoppingCarCount(BigInteger userId);

	public List<ShoppingCart> getUserShoppingCar(BigInteger userId);

	public Integer delShoppingCart(BigInteger userId, BigInteger scId);

	public Integer quantityMinus(BigInteger userId, BigInteger scId);

	public Integer quantityPlus(BigInteger userId, BigInteger scId);

	public Integer addShoppingCart(BigInteger ptId, BigInteger userId, Integer quantity);
	
	public List<ShoppingCart> getByUserIdAndShoppingCartIds(Integer[] scIds,BigInteger userId);
	
	public Integer delShoppingCartByProductTypeId(BigInteger userId, BigInteger ptId);
	
}
