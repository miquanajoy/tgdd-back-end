package com.group1.service.shopping;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group1.repositories.shopping.ShoppingBillRepo;

@Service
public class ShoppingBillService {

	@Resource
	ShoppingBillRepo shoppingBillRepo;

}
