package com.shopping.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Order;

public interface OrderDao {
	
	List<Order> findOrderByUserId(@Param("id") BigInteger id);

	Order findOrderById(BigInteger oId);
	
	Order createOrder(Order order);
}
