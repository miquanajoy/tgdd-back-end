package com.group1.Service;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group1.DTO.GeneralProductViewDTO;
import com.group1.DTO.ProductDiscountDTO;
import com.group1.Entities.Product.Product;
import com.group1.Repositories.ProductRepo;

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
	
	public List<ProductDiscountDTO> getProductDiscount(int a, int b, String c)
	{
		List<ProductDiscountDTO> dList = productReposit.showProductDiscount(a,b,c);
		for(ProductDiscountDTO d: dList) 
		{
			System.out.println(d);
		}
		
		return dList;
	}
}
