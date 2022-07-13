package com.group1.controller;

import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group1.entities.product.Category;
import com.group1.entities.product.Product;
import com.group1.entities.shopping.PromoteCode;
import com.group1.repositories.product.CategoryRepo;
import com.group1.repositories.product.ColorRepo;
import com.group1.repositories.product.ManufacturerRepo;
import com.group1.repositories.product.ProductRepo;
import com.group1.service.product.CategoryService;
import com.group1.service.product.ManufacturerService;
import com.group1.service.product.ProductService;
import com.group1.service.product.ProductTechSpecsService;
import com.group1.service.shopping.PromoteCodeService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	ProductService productServ;
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	ManufacturerService manuServ;
	
	@Autowired
	PromoteCodeService promotionServ;
	
	@Autowired
	CategoryRepo cateRepo;
	
	@Autowired
	ManufacturerRepo manuRepo;
	
	@Autowired
	ColorRepo colorRepo;
	
	@Autowired
	CategoryService cateServ;
	
	
	@Autowired
	ProductTechSpecsService specServ;
	
	boolean loadCateBasedSpecForm = false;
	int promoteIndex = 0;
	
	@GetMapping("/view-products")
	public ModelAndView viewProducts(ModelAndView model) {
		
		model.setViewName("ProductViewByCategory");
		return model;
	}
	
	@GetMapping("/view-products/phone")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/điện thoại/SSGN1234/Image/4x6.jpg";
		List<Product> productList = productServ.showProductByPhone();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByPhone");
		return model;
	}
	
	
	
	
	
	
}