package com.group1.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group1.dto.CustomerViewProductDetails.ColorVariantDetails;
import com.group1.dto.CustomerViewProductDetails.GeneralProductDetails;
import com.group1.repositories.product.ProductColorVariantRepo;

@Service
public class ProductColorVariantService {

	@Resource
	ProductColorVariantRepo pColorVariantRepo;

	public List<ColorVariantDetails> getProductColorVariants(String ID)
	{
		List<ColorVariantDetails> colorVariantList = pColorVariantRepo.getProductColorVariants(ID);
		for(ColorVariantDetails it:colorVariantList) 
		{
			String colorName = pColorVariantRepo.getProductColorName(it.getColorID());
			it.colorName = colorName;
		}
		return colorVariantList;
	}
}
