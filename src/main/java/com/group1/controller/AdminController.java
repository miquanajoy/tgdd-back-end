package com.group1.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group1.dto.GeneralProductViewDTO;
import com.group1.dto.ProductDiscountDTO;

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
	
	//@Autowired
	//CategoryService cateServ;
	
	@GetMapping("/ViewProduct")
	public ModelAndView showProduct(ModelAndView model) {
		Product saveproduct = new Product();
		saveproduct.setProductID("SSGN1234");
		saveproduct.setProductName("Samsung Galaxy Note A7");
		saveproduct.setPrice(14680000);
		saveproduct.setManufacturerID(1);
		saveproduct.setCategoryID(2);
		saveproduct.setProductWarranty(24);
		saveproduct.setExclusive(true);
		saveproduct.setImage("aasdklfjaklsfj");
		saveproduct.setInterestRate(4.2);
		saveproduct.setAccessoriesIncluded("Charger, mnanualguide, earphone");
		saveproduct.setEnabled(true);
		
		ProductArticle article = new ProductArticle();
		article.setProductID("SSGN1234");
		article.setArticleUrl("LinkURL");
		saveproduct.setArticle(article);
		
		ProductCameraShot camerShots = new ProductCameraShot();
		camerShots.setProductID("SSGN1234");
		camerShots.setImageGalleryPath("slfghsdkl");
		
		ProductFeature feature = new ProductFeature();
		feature.setProductID("SSGN1234");
		feature.setFeaturesGalleryPath("slasdf");
		feature.setFeaturesVideoLink("asdfasdf");
		
		ProductSpecification spec = new ProductSpecification();
		spec.setProductID("SSGN1234");
		spec.setProductSpecifications("asdlfasdfklas");
		
		ProductUnboxingReview unboxing = new ProductUnboxingReview();
		unboxing.setProductID("SSGN1234");
		unboxing.setImageGalleryPath("asdlfkasfskl");
		
		ProductVariant variant = new ProductVariant();
		variant.setProductVariantID("SSGA123");
		variant.setProductOriginalIdentifier("SSGN1234");
		variant.setProductVariantName("256GB");
		
		saveproduct.setArticle(article);
		saveproduct.setCameraShots(camerShots);
		saveproduct.setFeatures(feature);
		saveproduct.setSpecifications(spec);
		saveproduct.setUnboxing(unboxing);
		saveproduct.setVariant(variant);
		
		ProductColorVariant colorVariant = new  ProductColorVariant();
		Set<ProductColorVariant> pColors = new HashSet<ProductColorVariant>();
		colorVariant.setProductID("SSGN1234");
		colorVariant.setColorID(2);
		colorVariant.setImageGalleryPath("telkjdsfa");
		pColors.add(colorVariant);
		
		colorVariant = new  ProductColorVariant();
		colorVariant.setProductID("SSGA123");
		colorVariant.setColorID(1);
		colorVariant.setImageGalleryPath("ertlkasdf");
		pColors.add(colorVariant);
		
		saveproduct.setColorVariant(pColors);
		productServ.saveNewProduct(saveproduct);
		List<GeneralProductViewDTO> productlist = productServ.getAllProducts();
		ProductDiscountDTO productdiscountlist = productServ.getProductDiscount(1,2,"SSGA123");
		
		//ManufacturerPersistenceDTO brand = new ManufacturerPersistenceDTO(1,"Samsung");
		//manuServ.updateBrand(6,brand);
		model.setViewName("Show");
		return model;
	}
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/login")
	public ModelAndView showLoginPage() {

		return new ModelAndView("loginPage");
	}


}
