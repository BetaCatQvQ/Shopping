package com.shopping.dao;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Product;

public interface ProductDao {
	public List<Product> getProductListByCategoryOneId(@Param("coId")Integer categoryOneId);
	
	/**
	 * ����id��ȡ��Ʒ
	 * @param id ��Ʒ Id
	 * @return ��Ʒ
	 */
	Product getProductById(Long id);
}
