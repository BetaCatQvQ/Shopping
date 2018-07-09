package com.shopping.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTool {
	private static final String CONFIG_FILE = "applicationContext.xml";
	private static ApplicationContext ctx;
	static {
		ctx = new ClassPathXmlApplicationContext(CONFIG_FILE);
	}

	public static Object getBean(String id) {
		return ctx.getBean(id);
	}

	public static <T> T getBean(Class<T> zlass) {
		return ctx.getBean(zlass);
	}
}
