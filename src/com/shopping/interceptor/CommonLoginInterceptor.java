package com.shopping.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shopping.util.HttpVal;

@Component
public class CommonLoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		response.setCharacterEncoding("utf-8");
		Object userInfo = request.getSession().getAttribute(HttpVal.SESSION_COMMON_USER_KEY);

		if (userInfo == null) {
			request.getRequestDispatcher("/user/login.action").forward(request, response);
			return false;
		}
		return true;
	}
}
