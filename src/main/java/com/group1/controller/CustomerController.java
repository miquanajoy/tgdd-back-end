package com.group1.controller;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.group1.entities.product.Category;
import com.group1.entities.product.Manufacturer;
import com.group1.entities.product.Product;
import com.group1.repositories.product.CategoryRepo;
import com.group1.repositories.product.ColorRepo;
import com.group1.repositories.product.ManufacturerRepo;
import com.group1.repositories.user.UserRepo;
import com.group1.service.product.CategoryService;
import com.group1.service.product.ManufacturerService;
import com.group1.service.product.ProductService;
import com.group1.service.product.ProductTechSpecsService;
import com.group1.service.shopping.PromoteCodeService;

@RestController
public class CustomerController {
	@Autowired
	PromoteCodeService promotionServ;
	
	@Autowired
	ProductService productServ;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ManufacturerService manuServ;
	
	@Autowired
	CategoryRepo cateRepo;
	
	@Autowired
	CategoryService cateServ;

	@Autowired
	ManufacturerRepo manuRepo;
	
	@Autowired
	ColorRepo colorRepo;
	
	@Autowired
	ProductTechSpecsService specServ;
	
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/view-products")
	public List<Product> viewProducts(ModelAndView model, 
			@RequestParam(name = "category", required = false) Integer category,
			@RequestParam(name = "manufacturer", required = false) Integer manufacturer,
			@RequestParam(name = "name", required = false) String name) {

		List<Product> productList = null;

		if (category != null) {
			if (manufacturer != null) {
				productList = productServ.findProductByManufacturer(manufacturer);
			} else {
				productList = productServ.findProductByCategory(category);
			}

		} else {
			productList = productServ.showAllProducts();
		}
		
		if (name != null) {
			productList = productList.stream().filter(p->p.getProductName()
									 .toLowerCase().contains(name))
									 .collect(Collectors.toList());					
		} 
		
		for (Product pro : productList) {
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		return productList;
	}
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/view-category")
	public List<Category> viewByCategory(ModelAndView model) {

		List<Category> categoryList = cateServ.getAllCategorys();
		return categoryList;

	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/view-manufacturer")
	public List<Manufacturer> viewByManufacturerByCategory(ModelAndView model,
			@RequestParam(required = true) Integer categoryId) {

		List<Manufacturer> manufacturerList = manuServ.getAllCateBrands(categoryId);
		return manufacturerList;
	}
}
