package com.group1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group1.Entities.Product;
import com.group1.Service.ProductService;

@Controller
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	ProductService productserv;
	
	@GetMapping("/ViewProduct")
	public ModelAndView showProduct(ModelAndView model) {
		
		List<Product> productlist = productserv.getAllProducts();
		model.setViewName("Show");
		return model;
	}

}
