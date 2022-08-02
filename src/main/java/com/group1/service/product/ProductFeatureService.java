package com.group1.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group1.dto.CustomerViewProductDetails.FeatureDetails;
import com.group1.repositories.product.ProductFeatureRepo;

@Service
public class ProductFeatureService {

	@Resource
	ProductFeatureRepo pFeatureRepo;

	public List<FeatureDetails> getViewProductFeatures(String ID)
	{
		List<FeatureDetails> featureImages = pFeatureRepo.getFeatureByProductID(ID);
		return featureImages;
	}
}
