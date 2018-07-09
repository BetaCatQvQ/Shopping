package com.shopping.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.OrderItemDao;
import com.shopping.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Resource
	private OrderItemDao oiDao;
}
