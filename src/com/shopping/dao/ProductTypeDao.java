package com.shopping.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.ProductType;

public interface ProductTypeDao {


	ProductType findById(@Param("id") Long id);

	List<ProductType> findByProductId(@Param("id") BigInteger id);
}
