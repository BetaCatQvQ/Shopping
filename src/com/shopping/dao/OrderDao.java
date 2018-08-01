package com.shopping.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.params.ParameterizedTest;

import com.shopping.entity.Order;
import com.shopping.entity.Page;

public interface OrderDao {
	
	List<Order> findOrderByUserId(@Param("id") BigInteger userId,@Param("page") Page page);

	Order findOrderById(BigInteger oId);
	
	void createOrder(Order order);

	void delOrder(BigInteger orderId);
}
