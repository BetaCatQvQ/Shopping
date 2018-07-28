package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductTypeDao;
import com.shopping.dao.ShoppingCartDao;
import com.shopping.entity.ShoppingCart;
import com.shopping.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Resource
	private ShoppingCartDao scDao;

	@Resource
	private ProductTypeDao ptDao;

	@Override
	public Integer getUserShoppingCarCount(BigInteger userId) {
		return scDao.getUserShoppingCarCount(userId);
	}

	@Override
	public List<ShoppingCart> getUserShoppingCar(BigInteger userId) {
		return scDao.getUserShoppingCar(userId);
	}

	@Override
	public Integer delShoppingCart(BigInteger userId, BigInteger scId) {
		return scDao.delShoppingCart(userId, scId);
	}

	@Override
	public Integer quantityMinus(BigInteger userId, BigInteger scId) {
		Integer count = -1;
		// 查询购物车的商品数量
		Integer scQuantity = scDao.getQuantity(userId, scId);
		// 商品数量是否大于1
		if (scQuantity != null && scQuantity > 1) {
			// 修改购物车里商品的数量
			count = scDao.changeQuantity(userId, scId, scQuantity - 1);
		}
		return count;
	}

	@Override
	public Integer quantityPlus(BigInteger userId, BigInteger scId) {
		Integer count = -1;
		// 查询商品的库存和购物车商品的数量
		Map<String, Integer> data = scDao.getQuantityAndProductRestQuantity(userId, scId);
		if (data != null) {
			Integer scQuantity = data.get("quantity");
			Integer restQuantity = data.get("restQuantity");
			// 购物车里商品的要增加的数量，要比商品的库存小或者等于
			if (scQuantity != null && restQuantity != null && (scQuantity + 1 <= restQuantity)) {
				count = scDao.changeQuantity(userId, scId, scQuantity + 1);
			} else {
				count = 0;
			}
		}
		return count;
	}

	@Override
	public Integer addShoppingCart(BigInteger ptId, BigInteger userId, Integer quantity) {
		Integer count = -1;
		// 获取商品的库存
		Integer restQuantity = ptDao.getRestQuantity(ptId);
		if (restQuantity == null || restQuantity < quantity) {
			return count;
		}
		// 获取用户是否将此商品添加至购物车
		ShoppingCart scCount = scDao.getByUserIdAndProductTypeId(ptId, userId);
		if (scCount != null) {
			// 查询购物车的商品数量
			Integer scQuantity = scDao.getQuantity(userId, scCount.getShoppingCartId());
			// 修改商品數量
			count = scDao.changeQuantity(userId, scCount.getShoppingCartId(), scQuantity + quantity);
		} else {
			// 添加商品至购物车
			count = scDao.addShoppingCart(ptId, userId, restQuantity);
		}
		return count;
	}
}
