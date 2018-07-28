package com.shopping.util;

public class HttpVal {
	public static final String SESSION_COMMON_USER_KEY = "common_user";
	public static final String SESSION_ADMIN_USER_KEY = "admin_user";
	public static final String SHOPPING_CAR_COUNT_KEY = "shoppingCarNum";
	public static final String SHOPPING_CAR_LIST_KEY = "shoppingCarList";
	
	public interface LoginStatus{
		String LOGIN_STATUS_SUCCESS = "{status:1}";
		String LOGIN_STATUS_FAILED = "{status:0}";
		String LOGIN_STATUS_FAILED_MSG = "{msg:'%s'}";
	}
	
	public interface OrderStatus{
		/*
		 * -------------Delete status--------------
		 */
		String ORDER_DEL_STATUS_SUCCESS = "{status:1}";
		String ORDER_DEL_STATUS_FAILED = "{status:0}";
		String ORDER_DEL_STATUS_FAILED_MSG = "{status:0,msg:'%s'}";
		
	}
}
