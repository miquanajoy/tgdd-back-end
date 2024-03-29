package com.group1.service.product;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group1.repositories.product.ProductSpecificationRepo;

@Service
public class ProductSpecificationService {

	@Resource
	ProductSpecificationRepo pSpecificationRepo;

	public String getProductSpecs(String ID) 
	{
		String productSpecifications = pSpecificationRepo.getProductSpecification(ID);
		return productSpecifications;
	}
}
