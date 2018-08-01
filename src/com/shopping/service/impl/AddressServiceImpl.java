package com.shopping.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.AddressDao;
import com.shopping.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	@Resource
	private AddressDao aDao;
}
