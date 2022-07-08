package com.group1.controller;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group1.dto.Attributes;
import com.group1.dto.CategoryBasedSpecification;
import com.group1.dto.GeneralProductViewDTO;
import com.group1.dto.ProductDiscountDTO;
import com.group1.dto.PromoteForm;
import com.group1.dto.SpecSection;
import com.group1.repositories.CategoryRepo;
import com.group1.repositories.ColorRepo;
import com.group1.repositories.ManufacturerRepo;
import com.group1.repositories.ProductRepo;
import com.group1.repositories.PromoteCodeRepo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.group1.Entities.productEntities.Category;
import com.group1.Entities.productEntities.Color;
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
	ProductRepo productRepo;
	
	@Autowired
	ManufacturerService manuServ;
	
	@Autowired
	PromoteCodeRepo promotionServ;
	
	@Autowired
	CategoryRepo cateRepo;
	
	@Autowired
	ManufacturerRepo manuRepo;
	
	@Autowired
	ColorRepo colorRepo;
	
	boolean loadProductList = false;
	boolean loadPromoteList = false;
	boolean loadCateList = false;
	boolean loadManuList = false;
	boolean loadColorList = false;
	boolean loadCateBasedSpecForm = false;
	int promoteIndex = 0;
	
	List<Product> productList = new ArrayList<Product>();
	List<PromoteCode> promoteList = new ArrayList<PromoteCode>();
	List<Category> categoryList = new ArrayList<Category>();
	List<Manufacturer> manuList = new ArrayList<Manufacturer>();
	List<CategoryBasedSpecification> specFormList =new ArrayList<CategoryBasedSpecification>();
	List<Color> colorList =new  ArrayList<Color>();
	
	public void loadAllCateBasedSpecificationForm() throws IOException 
	{
		List<String> txtFile = new ArrayList<String>();
		File file =ResourceUtils.getFile("classpath:TGDD_Cate");
		FileReader fr = new FileReader(file); 
		BufferedReader br = new BufferedReader(fr);
		//StringBuffer sb = new StringBuffer();
		String line;
		
		List<SpecSection> sectionList =new ArrayList<SpecSection>();
		List<Attributes> attrList =new ArrayList<Attributes>();
		CategoryBasedSpecification specForm = new CategoryBasedSpecification();
		SpecSection section =new SpecSection();
		while((line=br.readLine()) != null) 
		{
			txtFile.add(line);
		}
		fr.close();
		//int count = 0;
		for(String txtline: txtFile) 
		{
			//System.out.println(txtline);
			if(txtline.contains("endcate")) 
			{
				specForm.setSection(sectionList);
				specFormList.add(specForm);
				/*for(CategoryBasedSpecification f: specFormList) 
				{
					f.toString();
				}*/
				sectionList = new ArrayList<SpecSection>();
				specForm =new CategoryBasedSpecification();
			}
			if(txtline.contains("startcate")) 
			{
				String[] cateSplit = txtline.split("-");
				specForm.setCategory(cateSplit[1]);
				//specFormList.add(specForm);
			} 
			if(txtline.contains("endsection")) 
			{
				section.setAttributes(attrList);
				sectionList.add(section);
				section =new SpecSection();
				attrList =new ArrayList<Attributes>();
			}
			if(txtline.contains("startsection")) 
			{
				String[] cateSectionSplit = txtline.split("-");
				//section = new SpecSection();
				section.setSectionHeader(cateSectionSplit[1]);
				//specFormList.get(specFormList.size()-1).;
			}
			if(txtline.contains(",") )
			{
				
				String[] cateKeyValPairSplit = txtline.split(",");
				for(String key: cateKeyValPairSplit) 
				{
					Attributes attr = new Attributes();
					attr.setKey(key);
					attr.setValue("split multiple values with ;");
					attrList.add(attr);
				}
			}
			
		}
	}
	
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
	
	@GetMapping("/AddProductChooseCategory")
	public ModelAndView chooseProductCategory(ModelAndView model) 
	{
		String chosenCategory = "";
		if(!loadCateList) 
		{
			categoryList = cateRepo.findAll();
			loadCateList = true;
		}
		if(!loadManuList) 
		{
			manuList = manuRepo.findAll();
			loadManuList = true;
		}
		if(!loadColorList) 
		{
			colorList = colorRepo.findAll();
			loadManuList = true;
		}
		if(!loadCateBasedSpecForm) 
		{
			try {
				loadAllCateBasedSpecificationForm();
			} catch (IOException e) {
				e.printStackTrace();
			}
			loadCateBasedSpecForm =true;
		}
		
		//Collections.sort(categoryList);
		model.setViewName("Show");
		model.addObject("Categorychosen", chosenCategory);
		model.addObject("CategoryList", categoryList);
		return model;
	}
	
	
	
	@PostMapping("/CreateProductStep1") 
	public ModelAndView AddProductStep1(ModelAndView model, @ModelAttribute("Categorychosen") String catechosen) 
	{//side
		//if(!catechosen.isEmpty()) System.out.println("Category is:"+catechosen);
		//else System.out.println("Category is empty");
		Product productInputForm = new Product();
		String Exclusive = "";
		String Enabled = "";
		int categoryID = 0;
		for(Category cate: categoryList) 
		{
			if(cate.getCategoryName().equals(catechosen) ) 
			{
				categoryID = cate.getCategoryID();
			}
		}
		productInputForm.setCategoryID(categoryID);
		
		ProductArticle article = new ProductArticle();
		productInputForm.setArticle(article);
		
		ProductCameraShot camShots = new ProductCameraShot();
		productInputForm.setCameraShots(camShots);
		
		
		ProductFeature feature = new ProductFeature();
		productInputForm.setFeatures(feature);
		
		
		ProductUnboxingReview unboxing = new ProductUnboxingReview();
		productInputForm.setUnboxing(unboxing);
		
		ProductVariant variant = new ProductVariant();
		productInputForm.setVariant(variant);
		
		model.addObject("ProductInputForm", productInputForm);
		model.setViewName("Show");
		model.addObject("CateChosen", catechosen);
		model.addObject("CheckExclusive", Exclusive);
		model.addObject("CheckEnabled", Enabled);
		//model.addObject("SpecInputForm", specInputForm);
		model.addObject("ManuList", manuList);
		//model.addObject("ColorList", colorList);
		//model.addObject("CategoryList", categoryList);
		return model;
	}
		
	@PostMapping("/CreateProduct")
	public ModelAndView AddProductProcess(ModelAndView model, @ModelAttribute("ProductInputForm1") Product productForm,
			/*@ModelAttribute("SpecInputForm1") CategoryBasedSpecification specform1,*/ @ModelAttribute("CheckExclusive") String exclusive,
			@ModelAttribute("CheckEnabled") String enabled) 
	{

		if(exclusive.contains("Exclusive")) productForm.setExclusive(true);
		if(exclusive.contains("NotExclusive")) productForm.setExclusive(false);
		
		if(enabled.contains("Enable")) productForm.setEnabled(true);
		if(enabled.contains("Disable")) productForm.setEnabled(false);
		
		String pID = productForm.getProductID();
		//productForm.setCategoryID(cateID);
		
		if(productForm.getArticle().getArticleUrl().isEmpty()) 
		{
			System.out.println("Article is null");
			productForm.setArticle(null);
		} 
		else productForm.getArticle().setProductID(pID);
		
		if(productForm.getCameraShots().getImageGalleryPath().isEmpty()) 
		{
			System.out.println("Camera shots is null");
			productForm.setCameraShots(null);
		} 
		else productForm.getCameraShots().setProductID(pID);
		/*for(Iterator<ProductColorVariant> t = productForm.getColorVariant().iterator(); t.hasNext();) 
		{
			ProductColorVariant el = t.next();
			if()
		}
		colorVariant.setProductID(pID);*/
		//if(productForm.getDiscount().get().isEmpty()) 
		//productForm.getDiscount().setProductID(pID);
		if(productForm.getFeatures().getFeaturesVideoLink().isEmpty() 
				|| productForm.getFeatures().getFeaturesGalleryPath().isEmpty()) {
			System.out.println("Feature is null");
			productForm.setFeatures(null);
		}
		else productForm.getFeatures().setProductID(pID);
		
		
		if(productForm.getUnboxing().getImageGalleryPath().isEmpty()) 
		{
			System.out.println("Unboxing is null");
			productForm.setUnboxing(null);
		}
		else productForm.getUnboxing().setProductID(pID);
		if(productForm.getVariant().getProductOriginalIdentifier().isEmpty()) 
		{
			System.out.println("Variant is null");
			productForm.setVariant(null);
		}
		else productForm.getVariant().setProductVariantID(pID);
		System.out.println("At final create product step"+productForm.toString());
		productRepo.save(productForm);
		//model.addObject("ProductInputForm1", productForm);
		model.setViewName("ProductView");
		//model.addObject("SpecInputForm1", specform);
		//model.addObject("ColorList", colorList);
		//model.addObject("CategoryList", categoryList);
		return model;
	}
	
	@GetMapping("/ViewProduct")
	public ModelAndView viewProducts(ModelAndView model) {
		
		if(!loadProductList) 
		{
			System.out.println("Loading product list from Db:");
			productList = productRepo.findAll();
			loadProductList = true;
			//promoteIndex = promoteList.get(promoteList.size()-1).getPromoteCodeID();
		}
		//Product p = productRepo.findByProductID("XR123");
		//System.out.println(p.toString());
		model.addObject("ProductList", productList);
		//model.addObject("ProductList", productList);
		model.setViewName("ProductView");
		return model;
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
	
	@GetMapping("/ViewDetailsOrUpdateProduct/{proID}")
	public ModelAndView viewOrUpdateProducts(ModelAndView model, @PathVariable("proID") String productIdentity) {
		
		Product p = productRepo.findByProductID(productIdentity);
		//System.out.println(p.toString());
		model.addObject("ProductUpdateForm", p);
		//model.addObject("ProductList", productList);
		model.setViewName("ProductDetailsOrUpdate");
		return model;
	}
	
	@PostMapping("/UpdateProduct")
	public ModelAndView UpdateProduct(ModelAndView model, @ModelAttribute("ProductUpdateForm") Product toUpdateForm,
			@ModelAttribute("CheckExclusive") String exclusiveSetter, @ModelAttribute("CheckEnable") String enableSetter) {
		
		//System.out.println(p.toString());
		if(exclusiveSetter.contains("Exclusive")) toUpdateForm.setExclusive(true);
		if(exclusiveSetter.contains("NotExclusive")) toUpdateForm.setExclusive(false);
		
		if(enableSetter.contains("Enable")) toUpdateForm.setEnabled(true);
		if(enableSetter.contains("Disable")) toUpdateForm.setEnabled(false);
		
		int foundForm = 0;
		int loopIndex = 0;
		String productIdentifier = "";
		boolean breakFindLoop = false;
		//LocalDateTime currentTime = LocalDateTime.now();
		
		//LocalDateTime convertedCurrentTime= converttoLocalDateTime(currentTime);
		//LocalDateTime convertedEndTime= converttoLocalDateTime(updateform.getEndDateInput());
		
		//updateform.setStartDate(convertedCurrentTime);
		//updateform.setEndDate(convertedEndTime);
		
		//form.setPromoteCodeID(1);
		for(Product productEl: productList) 
		{
			
			if(toUpdateForm.getProductID() == productEl.getProductID()) 
			{
				breakFindLoop =true;
				foundForm = loopIndex;
				productIdentifier = productEl.getProductID();
			}
			if(breakFindLoop) break;
			loopIndex+=1;
			
		}
		System.out.println("product after update is:"+toUpdateForm);
		
		//productList.set(foundForm, toUpdateForm);
		//toUpdateform.setPromoteCodeID(promoteID);
		//productRepo.save(toUpdateForm);
		//model.addObject("PromoteForm", form);
		model.setViewName("redirect:/Admin/ViewProduct");
		//model.addObject("ProductList", productList);
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
