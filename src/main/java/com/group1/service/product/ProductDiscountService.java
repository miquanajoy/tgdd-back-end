package com.group1.service.product;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group1.repositories.product.ProductDiscountRepo;

@Service
public class ProductDiscountService {

	@Resource
	ProductDiscountRepo pdiscountRepo;

}
