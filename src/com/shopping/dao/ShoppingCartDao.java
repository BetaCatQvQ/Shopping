package com.shopping.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.ShoppingCart;

public interface ShoppingCartDao {
	/**
	 * 获取用户的购物车商品总数
	 * 
	 * @param userId用户编号
	 * @return
	 */
	public Integer getUserShoppingCarCount(@Param("userId") BigInteger userId);

	/**
	 * 获取用户的购物车商品列表
	 * 
	 * @param userId用户编号
	 * @return
	 */
	public List<ShoppingCart> getUserShoppingCar(@Param("userId") BigInteger userId);

	/**
	 * 删除购物车商品
	 * 
	 * @param userId用户编号
	 * @param scId购物车编号
	 * @return
	 */
	public Integer delShoppingCart(@Param("userId") BigInteger userId, @Param("scId") BigInteger scId);
	
	/**
	 * 通过商品编号删除购物车商品
	 * 
	 * @param userId用户编号
	 * @param scId购物车编号
	 * @return
	 */
	public Integer delShoppingCartByProductTypeId(@Param("userId") BigInteger userId, @Param("ptId") BigInteger ptId);

	/**
	 * 修改购物车商品数量
	 * 
	 * @param userId用户编号
	 * @param scId购物车编号
	 * @param quantity数量
	 * @return
	 */
	public Integer changeQuantity(@Param("userId") BigInteger userId, @Param("scId") BigInteger scId,
			@Param("quantity") Integer quantity);

	public Integer getQuantity(@Param("userId") BigInteger userId, @Param("scId") BigInteger scId);

	public Map<String, Integer> getQuantityAndProductRestQuantity(@Param("userId") BigInteger userId,
			@Param("scId") BigInteger scId);

	public Integer addShoppingCart(@Param("ptId") BigInteger ptId, @Param("userId") BigInteger userId,
			@Param("quantity") Integer quantity);

	public ShoppingCart getByUserIdAndProductTypeId(@Param("ptId") BigInteger ptId, @Param("userId") BigInteger userId);

	public List<ShoppingCart> getByUserIdAndShoppingCartIds(@Param("scIds") Integer[] scIds,
			@Param("userId") BigInteger userId);
}
