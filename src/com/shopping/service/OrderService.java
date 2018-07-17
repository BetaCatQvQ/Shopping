package com.shopping.service;

import java.math.BigInteger;
import java.util.List;

import com.shopping.entity.Order;

public interface OrderService {
	
	List<Order> findOrderByUserId(BigInteger id);
}
