package com.shopping.service;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.ProductType;

public interface ProductTypeService {

	/**
	 * ��ѯ��Ʒ
	 * @param id ��Ʒid
	 * @return ��Ʒ
	 */
	ProductType findById(Long id);

	List<ProductType> findByProductId(@Param("id") BigInteger id);
}
