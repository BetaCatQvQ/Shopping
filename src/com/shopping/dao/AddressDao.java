package com.shopping.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Address;

public interface AddressDao {
	public List<Address> getList(@Param("userId") BigInteger userId);

	public Integer update(@Param("address") Address address);

	public Integer delete(@Param("addressId") Integer addressId, @Param("userId") BigInteger userId);
	
	List<Address> findAddressByUser(BigInteger userId);

	Address findAddressByUserAndAddressId(@Param("userId") BigInteger userId, @Param("addressId") Integer addressId);
	
	Integer addAddress(Address address);
}
