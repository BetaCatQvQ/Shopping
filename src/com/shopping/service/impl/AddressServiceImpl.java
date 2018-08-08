package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.AddressDao;
import com.shopping.entity.Address;
import com.shopping.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	@Resource
	private AddressDao aDao;
	
	@Override
	public List<Address> findAddressByUser(BigInteger userId){
		if (userId == null) {
			return null;
		}
		return aDao.findAddressByUser(userId);
	}
}
