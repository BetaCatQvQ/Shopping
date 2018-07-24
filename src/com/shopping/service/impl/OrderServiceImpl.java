package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.OrderDao;
import com.shopping.entity.Order;
import com.shopping.entity.OrderItem;
import com.shopping.entity.User;
import com.shopping.service.OrderService;
import com.shopping.util.SnowFlake;

@Service
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderDao oDao;

	@Override
	public List<Order> findOrderByUserId(BigInteger id) {
		return Objects.isNull(id)?null:oDao.findOrderByUserId(id);
	}

	@Override
	public Order findOrderById(BigInteger oId) {
		return Objects.isNull(oId)?null:oDao.findOrderById(oId);
	}

	@Override
	public Order createOrder(User user,List<OrderItem> orderItems) {
		Order order = new Order();
		order.setOrderItems(orderItems);
		order.setOrderCreateDate(new Date());
		order.setOrderId(new BigInteger(SnowFlake.getId().toString()));
		order.setUser(user);
		float total = 0;
		for (OrderItem item : orderItems) {
			total += item.getProductType().getSalePrice() * item.getQuantity();
		}
		order.setTotal(total);
		oDao.createOrder(order);
		return order;
	}
	
	
}
