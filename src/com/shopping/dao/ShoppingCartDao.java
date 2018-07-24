package com.shopping.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.ShoppingCart;

public interface ShoppingCartDao {
	public Integer getUserShoppingCarCount(@Param("userId") BigInteger userId);

	public List<ShoppingCart> getUserShoppingCar(@Param("userId") BigInteger userId);

	public Integer delShoppingCart(@Param("userId") BigInteger userId, @Param("scId") BigInteger scId);
}
