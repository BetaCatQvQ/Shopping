package com.shopping.service;

import java.math.BigInteger;
import java.util.List;

import com.shopping.entity.Address;

public interface AddressService {

	List<Address> findAddressByUser(BigInteger userId);

}
