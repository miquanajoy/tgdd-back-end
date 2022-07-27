package com.group1.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group1.dto.CustomerViewProductDetails.UnboxingDetails;
import com.group1.repositories.product.ProductunboxingReviewRepo;

@Service
public class ProductUnboxingService {

	@Resource
	ProductunboxingReviewRepo pUnboxingRepo;
	
	public List<UnboxingDetails> getViewProductUnboxings(String ID)
	{
		List<UnboxingDetails> unboxImages = pUnboxingRepo.findByProductID(ID);
		return unboxImages;
	}
}
