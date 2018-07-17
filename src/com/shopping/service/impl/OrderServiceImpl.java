package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.OrderDao;
import com.shopping.entity.Order;
import com.shopping.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderDao oDao;

	@Override
	public List<Order> findOrderByUserId(BigInteger id) {
		if (Objects.isNull(id)) {
			return null;
		}
		return oDao.findOrderByUserId(id);
	}
	
	
}
