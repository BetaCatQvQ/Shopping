package com.shopping.controller;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.entity.ShoppingCart;
import com.shopping.entity.User;
import com.shopping.service.ShoppingCartService;
import com.shopping.util.HttpVal;

@Controller
@RequestMapping("/sc")
public class ShoppingCartController {
	@Resource
	private ShoppingCartService scService;

	@RequestMapping("/common/cart")
	public String showCart(HttpSession session, Model model) {
		User user = (User) session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY);
		List<ShoppingCart> scList = scService.getUserShoppingCar(user.getUserId());
		model.addAttribute(HttpVal.SHOPPING_CAR_LIST_KEY, scList);
		return "cart";
	}

	@RequestMapping("/common/del")
	@ResponseBody
	public Integer delCartItem(HttpSession session, BigInteger sCartId) {
		User user = (User) session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY);
		Integer count = scService.delShoppingCart(user.getUserId(), sCartId);
		this.resetCartNum(session);
		return count;
	}

	@RequestMapping("/common/minus")
	@ResponseBody
	public Integer quantityMinus(HttpSession session, BigInteger sCartId) {
		User user = (User) session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY);
		return scService.quantityMinus(user.getUserId(), sCartId);
	}

	@RequestMapping("/common/plus")
	@ResponseBody
	public Integer quantityPlus(HttpSession session, BigInteger sCartId) {
		User user = (User) session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY);
		return scService.quantityPlus(user.getUserId(), sCartId);
	}

	@RequestMapping("/common/addsc")
	@ResponseBody
	public Integer getCarNum(HttpSession session, BigInteger ptId, Integer quantity) {
		User user = (User) session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY);
		Integer count = scService.addShoppingCart(ptId, user.getUserId(), quantity);
		if (count > 0) {
			this.resetCartNum(session);
		}
		return count;
	}

	@RequestMapping("/common/getCarNum")
	@ResponseBody
	public Integer addShoppingCart(HttpSession session) {
		resetCartNum(session);
		Integer count = (Integer) session.getAttribute(HttpVal.SHOPPING_CAR_COUNT_KEY);
		return count;
	}

	// method
	/**
	 * 重新设置购物车数量
	 * 
	 * @param session
	 * @param userId用户编号
	 */
	public void resetCartNum(HttpSession session) {
		// 查询购物车里的商品项的数量，然后放入session
		User user = (User) session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY);
		Integer shoppingCarNum = scService.getUserShoppingCarCount(user.getUserId());
		session.setAttribute(HttpVal.SHOPPING_CAR_COUNT_KEY, shoppingCarNum);
	}
}
