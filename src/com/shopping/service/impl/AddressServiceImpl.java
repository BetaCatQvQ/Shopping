package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.AddressDao;
import com.shopping.entity.Address;
import com.shopping.service.AddressService;
import com.shopping.util.JDBCTool;

@Service
public class AddressServiceImpl implements AddressService {
	@Resource
	private AddressDao aDao;

	@Resource
	private JDBCTool jdbcTool;

	@Override
	public Integer add(Address address) {
		return jdbcTool.autoInsert(address);
	}

	@Override
	public Integer upd(Address address, BigInteger userId) {
		address.getUser().setUserId(userId);
		return aDao.update(address);
	}

	@Override
	public Integer del(Integer addressId, BigInteger userId) {
		return aDao.delete(addressId, userId);
	}

	@Override
	public List<Address> getList(BigInteger userId) {
		return aDao.getList(userId);
	}
	@Override
	public List<Address> findAddressByUser(BigInteger userId){
		if (userId == null) {
			return null;
		}
		return aDao.findAddressByUser(userId);
}
