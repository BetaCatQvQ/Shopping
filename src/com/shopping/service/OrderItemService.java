package com.shopping.service;

import java.math.BigInteger;

import com.shopping.entity.OrderItem;

public interface OrderItemService {
	
	void createOrderItem(Long orderId, OrderItem item, Integer status);

	void changeOrderStatus(Integer status, Long orderId);

	void changeOrderStatusForItem(Integer status, Long orderId, Long orderItemId);
	
	Boolean changeOrderItemQuantity(BigInteger orderId, BigInteger orderItemId, Integer quantity);
}
