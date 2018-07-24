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
	 * ����һ��������
	 * @param orderId
	 * @param item
	 * @param status
	 */
	@Override
	public void createOrderItem(Long orderId, OrderItem item, Integer status) {
		oiDao.createOrderItem(orderId, item, status);
	}

	/**
	 * �޸Ķ���״̬
	 * @param status
	 * @param orderId
	 */
	@Override
	public void changeOrderStatus(Integer status, Long orderId) {
		oiDao.changeOrderStatus(status, orderId);
	}

	/**
	 * ���ݶ������޸�״̬
	 * @param status
	 * @param orderId
	 * @param orderItemId
	 */
	@Override
	public void changeOrderStatusForItem(Integer status, Long orderId, Long orderItemId) {
		oiDao.changeOrderStatusForItem(status, orderId, orderItemId);
	}
}
