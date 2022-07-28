package com.group1.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group1.entities.product.ProductTechSpecs;
import com.group1.repositories.product.ProductTechSpecsRepo;

@Service
public class ProductTechSpecsService {
	
	@Resource
	ProductTechSpecsRepo techSpecsRepo;
	
	public List<ProductTechSpecs> findAllSpecsByCateID(Integer cateID)
	{
		List<ProductTechSpecs> specList = techSpecsRepo.findByCategoryID(cateID);
		for(ProductTechSpecs spec: specList) 
		{
			System.out.println(spec.toString());
		}
		
		return specList;
	}
	
}
