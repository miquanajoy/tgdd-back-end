package com.group1.service.product;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group1.repositories.product.ProductColorVariantRepo;

@Service
public class ProductColorVariantService {

	@Resource
	ProductColorVariantRepo pColorVariantRepo;

}
