package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductTypeDao;
import com.shopping.entity.ProductType;
import com.shopping.service.ProductTypeService;
import com.sun.org.apache.regexp.internal.recompile;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
	@Resource
	private ProductTypeDao ptDao;

	@Override
	public ProductType findById(Long id) {
		if(Objects.isNull(id)) {
			return null;
		}
		return ptDao.findById(id);
	}

	@Override
	public List<ProductType> findByProductId(BigInteger id) {
		return ptDao.findByProductId(id);
	}

	
	@Override 
	public boolean changeStock(Long productTypeId, Long minusStock) {
		ProductType productType = findById(productTypeId);
		if (Objects.nonNull(productType)) {
			if (productType.getRestQuantity() >= minusStock) {
				ptDao.setProductTypeStock(productTypeId,(productType.getRestQuantity() - minusStock));
				return true;
			}
		}
		return false;
	}

	
}
