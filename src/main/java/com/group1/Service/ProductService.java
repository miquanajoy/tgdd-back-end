package com.group1.Service;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group1.DTO.GeneralProductViewDTO;
import com.group1.Entities.Product;
import com.group1.Repositories.ProductRepo;

@Service
public class ProductService {

	@Resource
	private ProductRepo productReposit;
	
	public List<Product> getAllProducts()
	{
		List<Product> pList = productReposit.showAllProduct();
		for(Product pr: pList) 
		{
			System.out.println(pr);
		}
		
		return pList;
	}
}
