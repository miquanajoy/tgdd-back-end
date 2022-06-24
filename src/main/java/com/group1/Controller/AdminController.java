package com.group1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group1.DTO.GeneralProductViewDTO;
import com.group1.DTO.ProductDiscountDTO;
import com.group1.Entities.Product.Product;
import com.group1.Service.ProductService;

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
