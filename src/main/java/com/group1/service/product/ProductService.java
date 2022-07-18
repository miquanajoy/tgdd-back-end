package com.group1.service.product;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group1.dto.GeneralProductViewDTO;
import com.group1.dto.ProductDiscountDTO;
import com.group1.entities.product.Product;
import com.group1.repositories.product.ProductRepo;

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
	
	public List<Product> showAllProducts()
	{
		
		List<Product> proList = productReposit.findAllProducts();
		for(Product prod: proList) 
		{
			System.out.println(prod.toString1());
		}
		return proList ;
	}
	
	public List<Product> findProductByCategory(Integer id) 
	{
		List<Product> prodList = productReposit.findProductByCategory(id);
		return prodList;
	}
	
}
