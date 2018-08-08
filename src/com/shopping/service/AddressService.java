package com.shopping.service;

import java.math.BigInteger;
import java.util.List;

import com.shopping.entity.Address;

public interface AddressService {
	public Integer add(Address address);

	public List<Address> getList(BigInteger userId);

	public Integer upd(Address address, BigInteger userId);

	public Integer del(Integer addressId, BigInteger userId);
}
