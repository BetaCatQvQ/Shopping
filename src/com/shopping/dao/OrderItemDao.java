package com.shopping.dao;

import java.math.BigInteger;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.OrderItem;

public interface OrderItemDao {
	void createOrderItem(@Param("orderId") Long orderId, 
			             @Param("item") OrderItem item,
			             @Param("status") Integer status);

	void changeOrderStatus(@Param("status") Integer status, 
			               @Param("orderId") Long orderId);

	void changeOrderStatusForItem(@Param("status") Integer status, 
			                      @Param("orderId") Long orderId,
			                      @Param("orderItemId") Long orderItemId);

	void changeOrderItemQuantity(@Param("orderId") BigInteger orderId, @Param("orderItemId") BigInteger orderItemId, @Param("quantity") Integer quantity);

	OrderItem findItemByOrderIdAndItemId(@Param("orderId") BigInteger orderId, @Param("orderItemId") BigInteger orderItemId);
}
