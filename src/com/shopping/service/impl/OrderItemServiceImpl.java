package com.shopping.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.OrderItemDao;
import com.shopping.entity.OrderItem;
import com.shopping.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Resource
	private OrderItemDao oiDao;

	/**
	 * 创建一个订单项
	 * @param orderId
	 * @param item
	 * @param status
	 */
	@Override
	public void createOrderItem(Long orderId, OrderItem item, Integer status) {
		oiDao.createOrderItem(orderId, item, status);
	}

	/**
	 * 修改订单状态
	 * @param status
	 * @param orderId
	 */
	@Override
	public void changeOrderStatus(Integer status, Long orderId) {
		oiDao.changeOrderStatus(status, orderId);
	}

	/**
	 * 根据订单项修改状态
	 * @param status
	 * @param orderId
	 * @param orderItemId
	 */
	@Override
	public void changeOrderStatusForItem(Integer status, Long orderId, Long orderItemId) {
		oiDao.changeOrderStatusForItem(status, orderId, orderItemId);
	}
}
