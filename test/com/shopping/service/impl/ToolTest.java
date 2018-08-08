package com.shopping.service.impl;

import java.math.BigInteger;

import com.shopping.entity.Order;
import com.shopping.util.JDBCTool;
import com.shopping.util.SpringTool;

public class ToolTest {
	public static void main(String[] args) {
		Order order = new Order();
		order.setOrderId(new BigInteger("185659691295182946"));
		order.getAddress().setAddressId(1);
		order.getUser().setUserId(new BigInteger("1"));
		
		JDBCTool jdbcTool = SpringTool.getBean(JDBCTool.class);
		Integer count = jdbcTool.autoInsert(order);
		System.out.println(count);
	}
}
