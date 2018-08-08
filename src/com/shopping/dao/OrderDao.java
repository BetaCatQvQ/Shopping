package com.shopping.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Order;
import com.shopping.entity.Page;

public interface OrderDao {
	
	List<Order> findOrderByUserId(@Param("id") BigInteger userId,@Param("page") Page page,@Param("orderStatus") String status);

	Order findOrderById(BigInteger oId);
	
	void createOrder(Order order);

	void delOrder(@Param("userId") BigInteger userId,@Param("orderId") BigInteger orderId);
	
	int countUserOrderTotal(@Param("userId") BigInteger userId,@Param("status") String status);
}
