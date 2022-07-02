package com.group1.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group1.dto.GeneralProductViewDTO;
import com.group1.dto.ProductDiscountDTO;
import com.group1.repositories.ProductRepo;
import com.group1.Entities.productEntities.Manufacturer;
import com.group1.Entities.productEntities.Product;
import com.group1.Entities.productEntities.ProductArticle;
import com.group1.Entities.productEntities.ProductCameraShot;
import com.group1.Entities.productEntities.ProductColorVariant;
import com.group1.Entities.productEntities.ProductFeature;
import com.group1.Entities.productEntities.ProductSpecification;
import com.group1.Entities.productEntities.ProductUnboxingReview;
import com.group1.Entities.productEntities.ProductVariant;
import com.group1.service.CategoryService;
import com.group1.service.ManufacturerService;
import com.group1.service.ProductService;

@Controller
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	ProductService productServ;
	
	@Autowired
	ManufacturerService manuServ;
	
	@Autowired
	ProductRepo prodcutRepo;
	List<Product> productList = new ArrayList<Product>();
	public LocalDateTime converttoLocalDateTime(LocalDateTime toConvertTime) 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("Date time:"+toConvertTime);
		
		String formatedDateTime = toConvertTime.format(dtf);
		System.out.println("Formatted date time:"+formatedDateTime);
		
		LocalDateTime finalFormatedTime = LocalDateTime.parse(formatedDateTime, dtf); 
		
		System.out.println("Formatted end time in objec:"+finalFormatedTime);
		return finalFormatedTime;
	}
	
	@GetMapping("/EditProduct")
	public ModelAndView editProduct(ModelAndView model,@PathVariable("proID") String productId) {
		Product p = prodcutRepo.findByProductID(productId);
		System.out.println(p.toString());
		model.addObject("ProductUpdateForm", p);
		model.addObject("ProductList", productList);
		model.setViewName("ProductEdit");
		return model;
	}
	@PostMapping("/UpdateProduct")
	public ModelAndView UpdateProduct(ModelAndView model, @ModelAttribute("ProductUpdateForm") Product toUpdateForm,
			@ModelAttribute("CheckExclusive") String exclusiveSetter, @ModelAttribute("CheckEnable") String enableSetter) {
		if(exclusiveSetter.contains("Exclusive")) toUpdateForm.setExclusive(true);
		if(exclusiveSetter.contains("NotExclusive")) toUpdateForm.setExclusive(false);
		if(enableSetter.contains("Enable")) toUpdateForm.setEnabled(true);
		if(enableSetter.contains("Disable")) toUpdateForm.setEnabled(false);
		int foundForm = 0;
		int loopIndex = 0;
		String productId = "";
		boolean breakFindLoop = false;
		//LocalDateTime currentTime = LocalDateTime.now();
		//LocalDateTime convertedCurrentTime= converttoLocalDateTime(currentTime);
		//LocalDateTime convertedEndTime= converttoLocalDateTime(updateform.getEndDateInput());
		//updateform.setStartDate(convertedCurrentTime);
		//updateform.setEndDate(convertedEndTime);
		for(Product pro: productList) 
		{
			if(toUpdateForm.getProductID() == pro.getProductID()) 
			{
				breakFindLoop =true;
				foundForm = loopIndex;
				productId = pro.getProductID();
			}
			if(breakFindLoop) break;
			loopIndex+=1;
		}
		System.out.println("product after update is:"+toUpdateForm);
		productList.set(foundForm, toUpdateForm);
	    prodcutRepo.save(toUpdateForm);
		model.setViewName("redirect:/Admin/ViewProduct");
		model.addObject("ProductList", productList);
		return model;
	}

}
