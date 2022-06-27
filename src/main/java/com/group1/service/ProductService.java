package com.group1.service;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group1.Entities.productEntities.Product;
import com.group1.dto.GeneralProductViewDTO;
import com.group1.dto.ProductDiscountDTO;
import com.group1.repositories.ProductRepo;

@Service
public class ProductService {

	@Resource
	private ProductRepo productReposit;
	
	public List<GeneralProductViewDTO> getAllProducts()
	{
		List<GeneralProductViewDTO> pList = productReposit.showAllProduct();
		for(GeneralProductViewDTO pr: pList) 
		{
			System.out.println(pr);
		}
		
		return pList;
	}
	
	public ProductDiscountDTO getProductDiscount(int a, int b, String c)
	{
		ProductDiscountDTO pDiscount = productReposit.showProductDiscount(a,b,c);
			System.out.println(pDiscount);
		
		return pDiscount;
	}
	
	public void saveNewProduct(Product toSaveProduct) 
	{
		System.out.println("Persist product review:");
		System.out.println(toSaveProduct.toString());
		productReposit.save(toSaveProduct);
	}
}
