package com.group1.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group1.dto.GeneralProductViewDTO;
import com.group1.dto.ProductDiscountDTO;
import com.group1.dto.PromoteForm;
import com.group1.repositories.PromoteCodeRepo;
import com.group1.Entities.productEntities.Manufacturer;
import com.group1.Entities.productEntities.Product;
import com.group1.Entities.productEntities.ProductArticle;
import com.group1.Entities.productEntities.ProductCameraShot;
import com.group1.Entities.productEntities.ProductColorVariant;
import com.group1.Entities.productEntities.ProductFeature;
import com.group1.Entities.productEntities.ProductSpecification;
import com.group1.Entities.productEntities.ProductUnboxingReview;
import com.group1.Entities.productEntities.ProductVariant;
import com.group1.Entities.shoppingEntities.PromoteCode;
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
	PromoteCodeRepo promotionServ;
	
	List<PromoteCode> promoteList = new ArrayList<PromoteCode>();
	boolean loadPromoteList = false;
	int promoteIndex = 0;
	
	
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
	
	@GetMapping("/ViewPromote")
	public ModelAndView viewPromotions(ModelAndView model) {
		
		if(!loadPromoteList) 
		{
			promoteList = promotionServ.findAll();
			loadPromoteList = true;
			promoteIndex = promoteList.get(promoteList.size()-1).getPromoteCodeID();
		}
		
		model.addObject("PromoteList", promoteList);
		model.setViewName("Promoteview");
		return model;
	}
	@GetMapping("/CreatePromote")
	public ModelAndView addNewPromotion(ModelAndView model) {
		/*Product saveproduct = new Product();
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
		saveproduct.setEnabled(true);*/
		
		/*ProductArticle article = new ProductArticle();
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
		saveproduct.setVariant(variant);*/
		
		/*ProductColorVariant colorVariant = new  ProductColorVariant();
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
		//manuServ.updateBrand(6,brand);*/
		PromoteCode promotecode = new PromoteCode();
		String enableButton = "";

		model.addObject("PromoteForm", promotecode);
		model.addObject("EnableCheck", enableButton);
		model.setViewName("PromoteAdd");
		return model;
	}

	@PostMapping("/CreatePromote")
	public ModelAndView processAddNewPromotion(ModelAndView model, @ModelAttribute("PromoteForm") PromoteCode form, 
			@ModelAttribute("EnableCheck") String checkEnable/*, RedirectAttributes rediAttr*/) 
	{
		if(checkEnable.equals("Enable")) form.setEnabled(true);
		if(checkEnable.equals("Disable")) form.setEnabled(false);
		
		LocalDateTime currentTime = LocalDateTime.now();
		
		LocalDateTime convertedCurrentTime= converttoLocalDateTime(currentTime);
		LocalDateTime convertedEndTime= converttoLocalDateTime(form.getEndDateInput());
		
		form.setStartDate(convertedCurrentTime);
		form.setEndDate(convertedEndTime);
		promoteIndex+=1;
		form.setPromoteCodeID(promoteIndex);
		promotionServ.save(form);
		promoteList.add(form);
		//model.addObject("PromoteForm", form);
		model.setViewName("redirect:/Admin/ViewPromote");
		return model;
	}
	
	@GetMapping("/UpdatePromote/{promote}")
	public ModelAndView UpdatePromotion(ModelAndView model, @PathVariable("promote") String promoteName) 
	{
		boolean breakLoop = false;
		int checkEnabled = 0;
		PromoteCode form = new PromoteCode();
		for(PromoteCode promotion: promoteList) 
		{
			
			if(promoteName.equals(promotion.getPromoteCodeName())) 
			{
				breakLoop =true;
				form = promotion;
			}
			if(breakLoop) break;
			
		}
		System.out.println("promoteID before is:"+form.getPromoteCodeID() );
		/* if(form.getEnabled()) checkEnabled =1;
		model.addObject("Enabling", checkEnabled);*/
		model.addObject("PromoteUpdateForm", form);
		model.setViewName("PromoteUpdate");
		return model;
	}
	
	@PostMapping("/UpdatePromote")
	public ModelAndView processUpdatePromotion(ModelAndView model, @ModelAttribute("PromoteUpdateForm") PromoteCode updateform, 
			@ModelAttribute("EnableCheck") String checkEnable/*, RedirectAttributes rediAttr*/) 
	{
		if(checkEnable.equals("Enable")) updateform.setEnabled(true);
		if(checkEnable.equals("Disable")) updateform.setEnabled(false);
		
		int foundForm = 0;
		int loopIndex = 0;
		Integer promoteID = 0;
		boolean breakFindLoop = false;
		LocalDateTime currentTime = LocalDateTime.now();
		
		LocalDateTime convertedCurrentTime= converttoLocalDateTime(currentTime);
		LocalDateTime convertedEndTime= converttoLocalDateTime(updateform.getEndDateInput());
		
		updateform.setStartDate(convertedCurrentTime);
		updateform.setEndDate(convertedEndTime);
		//form.setPromoteCodeID(1);
		for(PromoteCode promotion: promoteList) 
		{
			
			if(updateform.getPromoteCodeID() == promotion.getPromoteCodeID()) 
			{
				breakFindLoop =true;
				foundForm = loopIndex;
				promoteID = promotion.getPromoteCodeID();
			}
			if(breakFindLoop) break;
			loopIndex+=1;
			
		}
		System.out.println("promoteID after is:"+promoteID);
		promoteList.set(foundForm, updateform);
		updateform.setPromoteCodeID(promoteID);
		promotionServ.save(updateform);
		//model.addObject("PromoteForm", form);
		model.setViewName("redirect:/Admin/ViewPromote");
		return model;
	}
}
