package com.shopping.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Address;

public interface AddressDao {

	List<Address> findAddressByUser(BigInteger userId);

	Address findAddressByUserAndAddressId(@Param("userId") BigInteger userId, @Param("addressId") Integer addressId);
	
}
