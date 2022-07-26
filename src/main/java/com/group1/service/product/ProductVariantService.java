package com.group1.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group1.dto.CustomerViewProductDetails.ProductVariantDetails;
import com.group1.repositories.product.ProductVariantRepo;

@Service
public class ProductVariantService {

	@Resource
	ProductVariantRepo pVariantRepo;

	/*public Boolean checkProductIsOrigin(String piD) 
	{
		Boolean productIsOrigin = pVariantRepo.existsByProductOriginalIdentifier(piD);
		return productIsOrigin;
	}*/
	
	public List<ProductVariantDetails> getVariantsOfProduct(String ID)
	{
		List<ProductVariantDetails> productVariants = pVariantRepo.getProductVariantDetails(ID);
		return productVariants;
	}
}
