package com.group1.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group1.Entities.productEntities.Manufacturer;
import com.group1.repositories.ManufacturerRepo;

@Service
public class ManufacturerService {

	@Resource
	ManufacturerRepo BrandRepo;
	
	public List<Manufacturer> getAllBrands()
	{
		List<Manufacturer> brandList =BrandRepo.findAll();
		for(Manufacturer item: brandList) 
		{
			System.out.println(item.toString());
		}
		return brandList;
	}
	
	public Manufacturer getSpecificBrand(Integer BrandID)
	{
		Manufacturer brandItem =BrandRepo.findByManufacturerID(BrandID);
			System.out.println(brandItem.toString());
		return brandItem;
	}

	public void updateBrand(Integer toUpdateBrandID ,Manufacturer brand) 
	{
		System.out.println(brand.toString());
		BrandRepo.updateBrand(toUpdateBrandID, brand);
	}
}
