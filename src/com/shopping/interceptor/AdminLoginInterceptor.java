package com.shopping.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shopping.entity.User;
import com.shopping.util.HttpVal;

public class AdminLoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		response.setCharacterEncoding("utf-8");
		User userInfo = (User) request.getSession().getAttribute(HttpVal.SESSION_ADMIN_USER_KEY);
		
		if (userInfo == null) {
			PrintWriter out = response.getWriter();
			out.print("<script type=\"text/javascript\">");
			out.print("alert('ÇëµÇÂ¼£¡');");
			out.print("location.href='../../userInfo/goLogin.action';");
			out.print("</script>");
			closeWriter(out);
			return false;
		}
		return true;
	}

	public void closeWriter(PrintWriter out) {
		if (out != null) {
			out.close();
		}
	}
}
