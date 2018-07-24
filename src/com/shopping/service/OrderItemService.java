package com.shopping.service;

import com.shopping.entity.OrderItem;

public interface OrderItemService {
	
	void createOrderItem(Long orderId, OrderItem item, Integer status);

	void changeOrderStatus(Integer status, Long orderId);

	void changeOrderStatusForItem(Integer status, Long orderId, Long orderItemId);
}
