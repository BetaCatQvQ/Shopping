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
	 * ����id��ȡ��Ʒ
	 * @param id ��Ʒ Id
	 * @return ��Ʒ
	 */
	Product getProductById(Long id);
<<<<<<< HEAD
>>>>>>> 9dc307aa1529c0ce11d1c044b4b4209f0cebb170
=======
>>>>>>> 9dc307aa1529c0ce11d1c044b4b4209f0cebb170
}
