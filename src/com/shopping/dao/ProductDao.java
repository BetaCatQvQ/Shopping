package com.shopping.dao;

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Product;

public interface ProductDao {
	public List<Product> getProductListByCategoryOneId(@Param("coId")Integer categoryOneId);
=======
=======
>>>>>>> 9dc307aa1529c0ce11d1c044b4b4209f0cebb170
import com.shopping.entity.Product;

public interface ProductDao {
	/**
	 * 根据id获取产品
	 * @param id 产品 Id
	 * @return 产品
	 */
	Product getProductById(Long id);
<<<<<<< HEAD
>>>>>>> 9dc307aa1529c0ce11d1c044b4b4209f0cebb170
=======
>>>>>>> 9dc307aa1529c0ce11d1c044b4b4209f0cebb170
}
