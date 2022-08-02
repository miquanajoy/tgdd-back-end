package com.group1.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group1.dto.CustomerViewProductDetails.CameraShotsDetails;
import com.group1.repositories.product.ProductCameraShotRepo;

@Service
public class ProductCameraShotService {

	@Resource
	ProductCameraShotRepo cameraShotsRepo;

	public List<CameraShotsDetails> getCammerShotViews(String ID) 
	{
		List<CameraShotsDetails> camShots = cameraShotsRepo.getCamShotsByProductID(ID);
		return camShots;
	}
}
