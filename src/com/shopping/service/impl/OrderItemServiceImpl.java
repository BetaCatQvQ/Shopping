package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.OrderDao;
import com.shopping.dao.OrderItemDao;
import com.shopping.entity.Order;
import com.shopping.entity.OrderItem;
import com.shopping.service.OrderItemService;
import com.shopping.service.ProductTypeService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Resource
	private OrderItemDao oiDao;
	
	@Resource
	private OrderDao oDao;
	
	@Resource
	private ProductTypeService ptService;
	
	
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
		Order order = oDao.findOrderById(new BigInteger(orderId.toString()));
		order.getOrderItems().forEach(item ->{
			ptService.changeStock(item.getProductType().getProductTypeId().longValue(),item.getQuantity().longValue());
		});
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


	@Override
	public Boolean changeOrderItemQuantity(BigInteger orderId, BigInteger orderItemId, Integer quantity) {
		Optional<OrderItem> opt = Optional.ofNullable(oiDao.findItemByOrderIdAndItemId(orderId, orderItemId));
		opt.ifPresent(item ->{
			oiDao.changeOrderItemQuantity(orderId, orderItemId, quantity);
		});
		return opt.isPresent();
	}
}
