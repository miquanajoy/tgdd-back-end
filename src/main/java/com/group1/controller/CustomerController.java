package com.group1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group1.entities.product.Category;
import com.group1.entities.product.Manufacturer;
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
	
	
	@GetMapping("/products-management/view-products")
	public ModelAndView viewProductsByManufacturer(ModelAndView model, @RequestParam(required = false) Integer maufacturer) {
		
		String path ="/image/product/điện thoại/SSGN1234/Image/4x6.jpg";
		List<Product> productList;
		List<Manufacturer> manufacturerList=manuServ.getAllBrands();
		if( manufacturerList== null) {
			productList = productServ.showAllProducts();
		} else {
			productList = productServ.findProductByCategoryId(category);
		}

		for(Product pro: productList) 
		{
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		model.addObject("ProductList", productList);
		model.addObject("ManufacturerList", manufacturerList);
		model.addObject("ImgPath", path);
		model.setViewName("ProductView");
		return model;
	}
}
