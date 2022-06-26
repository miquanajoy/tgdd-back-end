package com.group1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group1.Entities.productEntities.Product;
import com.group1.dto.GeneralProductViewDTO;
import com.group1.dto.ProductDiscountDTO;
import com.group1.service.ProductService;

@Controller
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	ProductService productserv;
	
	@GetMapping("/ViewProduct")
	public ModelAndView showProduct(ModelAndView model) {
		
		List<GeneralProductViewDTO> productlist = productserv.getAllProducts();
		List<ProductDiscountDTO> productdiscountlist = productserv.getProductDiscount(1,2,"SSGA123");
		model.setViewName("Show");
		return model;
	}

}
