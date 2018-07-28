package com.shopping.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.SessionAttribute;
=======
>>>>>>> fa4671f8f918c2442df4a4820cf931e890fecf6b

import com.shopping.entity.User;
import com.shopping.service.ShoppingCartService;
import com.shopping.service.UserService;
import com.shopping.util.HttpVal;
import com.shopping.util.HttpVal.LoginStatus;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService uService;

	@Resource
	private ShoppingCartService scService;

<<<<<<< HEAD
	@GetMapping("/login")
	public String gotoLogin() {
=======
	/**
	 * Ìø×ªÖÁµÇÂ¼Ò³Ãæ
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
>>>>>>> fa4671f8f918c2442df4a4820cf931e890fecf6b
		return "loginPage";
	}

	/**
	 * µÇÂ¼
	 * 
	 * @param session
	 * @param user
	 * @return
	 */
	@RequestMapping("/beginLogin")
	public String commonLogin(HttpSession session, User user) {
		User newUser = uService.commonUserLogin(user.getUserName(), user.getUserPwd());
		session.setAttribute(HttpVal.SESSION_COMMON_USER_KEY, newUser);
		if (newUser != null) {
			Integer shoppingCarNum = scService.getUserShoppingCarCount(newUser.getUserId());
			session.setAttribute(HttpVal.SHOPPING_CAR_COUNT_KEY, shoppingCarNum);
		}
		return "redirect:/home.action";
	}

<<<<<<< HEAD
	@PostMapping("/login")
	public @ResponseBody String login(HttpSession session, User user) {
		User newUser = uService.commonUserLogin(user.getUserName(), user.getUserPwd());
		session.setAttribute(HttpVal.SESSION_COMMON_USER_KEY, newUser);
		if (newUser != null) {
			Integer shoppingCarNum = scService.getUserShoppingCarCount(newUser.getUserId());
			session.setAttribute(HttpVal.SHOPPING_CAR_COUNT_KEY, shoppingCarNum);
			return HttpVal.LoginStatus.LOGIN_STATUS_SUCCESS;
		}
		return String.format(HttpVal.LoginStatus.LOGIN_STATUS_FAILED_MSG,"ç”¨æˆ·åæˆ–å¯†ç é”™è¯¯");
	}
	
=======
	/**
	 * µÇ³ö
	 * 
	 * @param session
	 * @return
	 */
>>>>>>> fa4671f8f918c2442df4a4820cf931e890fecf6b
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home.action";
	}

	/**
	 * Ìø×ªÖÁ×¢²áÒ³Ãæ
	 * 
	 * @return
	 */
	@GetMapping(value = "/register")
	public String gotoRegister() {
		return "registerPage";
	}

	/**
	 * ×¢²á
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@PostMapping(value = "/register")
	public String register(User user, HttpSession session) {
		session.setAttribute(HttpVal.SESSION_COMMON_USER_KEY, uService.register(user));
		return "registerSuccessPage";
	}

	/**
	 * ¼ì²éÊÇ·ñµÇÂ¼
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/checkLogin")
	@ResponseBody
	public Integer checkLogin(HttpSession session) {
		Object user = session.getAttribute(HttpVal.SESSION_COMMON_USER_KEY);
		if (user == null) {
			return 0;
		}
		return 1;
	}
}
