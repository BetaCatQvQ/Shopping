package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.stereotype.Service;

import com.shopping.dao.AddressDao;
import com.shopping.dao.OrderDao;
import com.shopping.dao.OrderItemDao;
import com.shopping.entity.Address;
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
	
	@Resource
	AddressDao aDao;
	
	@Override
	public Page<Order> findOrderByUserId(BigInteger id,Page<Order> page,String status) {
		page.setPageCount(5);//Modify pageCount
		page.setPageNo(page.getPageNo());//Re-count pageNo
		List<Order> data = Objects.isNull(id)?null:oDao.findOrderByUserId(id,page,status);
		page.setData(data);
		page.setRowTotal(oDao.countUserOrderTotal(id, status));
		return page;
	}
	public Page<Order> findOrderByUserId(BigInteger id,Page<Order> page) {
		return findOrderByUserId(id, page,"all");
	}
	
	public List<Order> findOrderByUserId(BigInteger id) {
		return Objects.isNull(id)?null:oDao.findOrderByUserId(id,null,"all");
	}

	@Override
	public Order findOrderById(BigInteger oId) {
		Order order = Objects.isNull(oId)?null:oDao.findOrderById(oId);
		float sum = 0.0F;
		for (OrderItem item : order.getOrderItems()) {
			sum = (float) (sum + (item.getProductType().getSalePrice() * item.getQuantity()));
		}
		order.setTotal(sum);
		return order;
	}

	@Override
	public Order createOrder(User user,List<OrderItem> orderItems,Address address) {
		Order order = new Order();
		order.setAddress(address);
		order.setOrderItems(orderItems);
		order.setOrderCreateDate(new Date());
		order.setOrderId(new BigInteger(SnowFlake.getId().toString()));
		order.setUser(user);
		order.setAddress(address);
		float total = 0;
		for (OrderItem item : orderItems) {
			total += item.getProductType().getSalePrice() * item.getQuantity();
		}
		order.setTotal(total);
		oDao.createOrder(order);
		orderItems.forEach(item ->{
			oiDao.createOrderItem(order.getOrderId().longValue(), item, 0);
		});
		order.setAddress(aDao.findAddressByUserAndAddressId(user.getUserId(), address.getAddressId()));
		return order;
	}

	@Override
	public String delOrder(User user, BigInteger orderId) {
		try {
			user = Objects.requireNonNull(user);
			List<Order> oList = Objects.requireNonNull(findOrderByUserId(user.getUserId()));
			if (oList.size() != 0) {
				for(Order item : oList) {
					System.out.println(orderId + "<-->" + item.getOrderId() + " : " + (item.getOrderId().equals(orderId)));
					if (item.getOrderId().equals(orderId)) {
						oDao.delOrder(user.getUserId(),orderId);
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
