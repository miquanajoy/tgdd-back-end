package com.group1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group1.entities.product.Category;
import com.group1.repositories.product.CategoryRepo;
import com.group1.repositories.product.ColorRepo;
import com.group1.repositories.product.ManufacturerRepo;
import com.group1.repositories.product.ProductRepo;
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
	ProductTechSpecsService specServ;
	
	boolean loadCateBasedSpecForm = false;
	int promoteIndex = 0;
	
	
	@GetMapping("/view-products/view-brand/choosen-category")
	public ModelAndView choosenCategory(ModelAndView model) {
		
		String chosenCategory = "";

		List<Category> categoryList = cateRepo.findAll();
		//Collections.sort(categoryList);
		model.setViewName("ProductView");
		model.addObject("CategoryList", categoryList);
		return model;
	}
	
	
	@GetMapping("/view-brand")
	public ModelAndView viewProducts(ModelAndView model) {
		
		model.setViewName("ProductViewByBrand");
		return model;
}
	
