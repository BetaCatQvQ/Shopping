package com.shopping.service;

import java.math.BigInteger;
import java.util.List;

import com.shopping.entity.Address;
import com.shopping.entity.Order;
import com.shopping.entity.OrderItem;
import com.shopping.entity.Page;
import com.shopping.entity.User;

public interface OrderService {	
	
	Order findOrderById(BigInteger oId);
	
	String delOrder(User user, BigInteger orderId);

	Page<Order> findOrderByUserId(BigInteger id, Page<Order> page, String orderStatus);

	Order createOrder(User user, List<OrderItem> orderItems, Address address);
}
