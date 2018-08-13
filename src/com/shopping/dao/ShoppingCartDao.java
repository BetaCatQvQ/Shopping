package com.shopping.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.ShoppingCart;

public interface ShoppingCartDao {
	/**
	 * ��ȡ�û��Ĺ��ﳵ��Ʒ����
	 * 
	 * @param userId�û����
	 * @return
	 */
	public Integer getUserShoppingCarCount(@Param("userId") BigInteger userId);

	/**
	 * ��ȡ�û��Ĺ��ﳵ��Ʒ�б�
	 * 
	 * @param userId�û����
	 * @return
	 */
	public List<ShoppingCart> getUserShoppingCar(@Param("userId") BigInteger userId);

	/**
	 * ɾ�����ﳵ��Ʒ
	 * 
	 * @param userId�û����
	 * @param scId���ﳵ���
	 * @return
	 */
	public Integer delShoppingCart(@Param("userId") BigInteger userId, @Param("scId") BigInteger scId);
	
	/**
	 * ͨ����Ʒ���ɾ�����ﳵ��Ʒ
	 * 
	 * @param userId�û����
	 * @param scId���ﳵ���
	 * @return
	 */
	public Integer delShoppingCartByProductTypeId(@Param("userId") BigInteger userId, @Param("ptId") BigInteger ptId);

	/**
	 * �޸Ĺ��ﳵ��Ʒ����
	 * 
	 * @param userId�û����
	 * @param scId���ﳵ���
	 * @param quantity����
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
