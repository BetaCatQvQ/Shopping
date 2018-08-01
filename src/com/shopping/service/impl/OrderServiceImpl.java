package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.OrderDao;
import com.shopping.dao.OrderItemDao;
import com.shopping.entity.Order;
import com.shopping.entity.OrderItem;
import com.shopping.entity.Page;
import com.shopping.entity.User;
import com.shopping.service.OrderService;
import com.shopping.util.HttpVal;
import com.shopping.util.SnowFlake;

@Service
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderDao oDao;
	
	@Resource
	private OrderItemDao oiDao;

	@Override
	public Page<Order> findOrderByUserId(BigInteger id,Page<Order> page) {
		page.setPageCount(5);//Modify pageCount
		page.setPageNo(page.getPageNo());//Re-count pageNo
		List<Order> data = Objects.isNull(id)?null:oDao.findOrderByUserId(id,page);
		page.setData(data);
		return page;
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
		orderItems.forEach(item ->{
			oiDao.createOrderItem(order.getOrderId().longValue(), item, 0);
		});
		return order;
	}

	@Override
	public String delOrder(User user, BigInteger orderId) {
		try {
			user = Objects.requireNonNull(user);
			List<Order> oList = Objects.requireNonNull(oDao.findOrderByUserId(user.getUserId(),new Page<>(1)));
			if (oList.size() != 0) {
				for(Order item : oList) {
					if (orderId == item.getOrderId()) {
						oDao.delOrder(orderId);
						return HttpVal.OrderStatus.ORDER_STATUS_SUCCESS;
					}
				}
			}
		} catch (Exception e) {
			return HttpVal.OrderStatus.ORDER_STATUS_FAILED;
		}
		return HttpVal.OrderStatus.ORDER_STATUS_SUCCESS;
	}
	
	
}
