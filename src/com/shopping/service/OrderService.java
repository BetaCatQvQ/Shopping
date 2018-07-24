package com.shopping.service;

import java.math.BigInteger;
import java.util.List;

import com.shopping.entity.Order;
import com.shopping.entity.OrderItem;
import com.shopping.entity.User;

public interface OrderService {
	
	List<Order> findOrderByUserId(BigInteger id);
	
	Order findOrderById(BigInteger oId);
	
	Order createOrder(User user, List<OrderItem> orderItems);
}
