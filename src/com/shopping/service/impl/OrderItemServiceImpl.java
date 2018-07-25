package com.shopping.service.impl;

import java.math.BigInteger;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.OrderDao;
import com.shopping.dao.OrderItemDao;
import com.shopping.entity.Order;
import com.shopping.entity.OrderItem;
import com.shopping.service.OrderItemService;
import com.shopping.service.ProductTypeService;
import com.sun.javafx.scene.layout.region.Margins.Converter;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Resource
	private OrderItemDao oiDao;
	
	@Resource
	private OrderDao oDao;
	
	@Resource
	private ProductTypeService ptService;
	
	
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
		Order order = oDao.findOrderById(new BigInteger(orderId.toString()));
		order.getOrderItems().forEach(item ->{
			ptService.changeStock(item.getProductType().getProductTypeId().longValue(),item.getQuantity().longValue());
		});
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
