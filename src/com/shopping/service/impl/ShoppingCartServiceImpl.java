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
		// ��ѯ���ﳵ����Ʒ����
		Integer scQuantity = scDao.getQuantity(userId, scId);
		// ��Ʒ�����Ƿ����1
		if (scQuantity != null && scQuantity > 1) {
			// �޸Ĺ��ﳵ����Ʒ������
			count = scDao.changeQuantity(userId, scId, scQuantity - 1);
		}
		return count;
	}

	@Override
	public Integer quantityPlus(BigInteger userId, BigInteger scId) {
		Integer count = -1;
		// ��ѯ��Ʒ�Ŀ��͹��ﳵ��Ʒ������
		Map<String, Integer> data = scDao.getQuantityAndProductRestQuantity(userId, scId);
		if (data != null) {
			Integer scQuantity = data.get("quantity");
			Integer restQuantity = data.get("restQuantity");
			// ���ﳵ����Ʒ��Ҫ���ӵ�������Ҫ����Ʒ�Ŀ��С���ߵ���
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
		// ��ȡ��Ʒ�Ŀ��
		Integer restQuantity = ptDao.getRestQuantity(ptId);
		if (restQuantity == null || restQuantity < quantity) {
			return count;
		}
		// ��ȡ�û��Ƿ񽫴���Ʒ��������ﳵ
		ShoppingCart scCount = scDao.getByUserIdAndProductTypeId(ptId, userId);
		if (scCount != null) {
			// ��ѯ���ﳵ����Ʒ����
			Integer scQuantity = scDao.getQuantity(userId, scCount.getShoppingCartId());
			// �޸���Ʒ����
			count = scDao.changeQuantity(userId, scCount.getShoppingCartId(), scQuantity + quantity);
		} else {
			// �����Ʒ�����ﳵ
			count = scDao.addShoppingCart(ptId, userId, restQuantity);
		}
		return count;
	}
}
