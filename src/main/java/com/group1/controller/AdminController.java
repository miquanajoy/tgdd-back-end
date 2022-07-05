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
import com.group1.entities.product.Category;
import com.group1.entities.product.Color;
import com.group1.entities.product.Manufacturer;
import com.group1.entities.product.Product;
import com.group1.entities.product.ProductArticle;
import com.group1.entities.product.ProductCameraShot;
import com.group1.entities.product.ProductColorVariant;
import com.group1.entities.product.ProductFeature;
import com.group1.entities.product.ProductSpecification;
import com.group1.entities.product.ProductUnboxingReview;
import com.group1.entities.product.ProductVariant;
import com.group1.entities.shopping.PromoteCode;
import com.group1.repositories.product.CategoryRepo;
import com.group1.repositories.product.ColorRepo;
import com.group1.repositories.product.ManufacturerRepo;
import com.group1.repositories.product.ProductRepo;
import com.group1.repositories.shopping.PromoteCodeRepo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.group1.service.product.CategoryService;
import com.group1.service.product.ManufacturerService;
import com.group1.service.product.ProductService;
import com.group1.service.shopping.PromoteCodeService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
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
	
	boolean loadCateBasedSpecForm = false;
	int promoteIndex = 0;
	
	List<CategoryBasedSpecification> specFormList =new ArrayList<CategoryBasedSpecification>();
	
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
	
	@GetMapping("/products-management/create-product/choose-category")
	public ModelAndView chooseProductCategory(ModelAndView model) 
	{
		String chosenCategory = "";
		if(!loadCateBasedSpecForm) 
		{
			try {
				loadAllCateBasedSpecificationForm();
			} catch (IOException e) {
				e.printStackTrace();
			}
			loadCateBasedSpecForm =true;
		}
		List<Category> categoryList = cateRepo.findAll();
		//Collections.sort(categoryList);
		model.setViewName("Show");
		model.addObject("Categorychosen", chosenCategory);
		model.addObject("CategoryList", categoryList);
		return model;
	}
	
	/*String json = "";
	ObjectMapper mapper = new ObjectMapper();
	mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	try {
		json = mapper.writeValueAsString(specFormList.get(0));
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Product p= productRepo.findByProductID("SSGN1234");
	ProductSpecification pSpec = new ProductSpecification();
	pSpec.setProductID("SSGN1234");
	pSpec.setProductSpecifications(json);
	
	p.setSpecifications(pSpec);
	productRepo.save(p);
	
	Product newP= productRepo.findByProductID("SSGN1234");
	try {
		currSpec = mapper.readValue(newP.getSpecifications().getProductSpecifications().getBytes(), CategoryBasedSpecification.class);
		System.out.println(currSpec.toString().replace("[", "").replace("]", "") );
	} catch (JsonParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	@GetMapping("/products-management/create-product/step-1")
	public ModelAndView AddProductStep1(ModelAndView model, @ModelAttribute("Categorychosen") String catechosen) 
	{
		//if(!catechosen.isEmpty()) System.out.println("Category is:"+catechosen);
		//else System.out.println("Category is empty");
		Product productInputForm = new Product();
		String Exclusive = "";
		String Enabled = "";
		int categoryID = 0;
		List<Category> categoryList = cateRepo.findAll();
		List<Manufacturer> manuList = manuRepo.findAll();
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
	
	/*@PostMapping("/CreateProductStep2")
	public ModelAndView AddProductStep2(ModelAndView model, @ModelAttribute("ProductInputForm") Product productForm, @ModelAttribute("CheckExclusive") String exclusive,
			@ModelAttribute("CheckEnabled") String enabled, @ModelAttribute("CateChosen") String catechosen) 
	{
		
		
		//if(!catechosen.isEmpty()) System.out.println("Category is:"+catechosen);
		//else System.out.println("Category is empty");
		//ProductColorVariant colorVariant = new  ProductColorVariant();
		//productForm.getColorVariant().add(colorVariant);
		String pID =productForm.getProductID();
		
		//productForm.getSpecifications().setProductID(pID);
		System.out.println("At create product step 2"+productForm.toString());
		
		model.addObject("ProductInputForm1", productForm);
		model.setViewName("Show");
		model.addObject("SelectedCate", catechosen);
		//model.addObject("SpecInputForm", specInputForm);
		//model.addObject("CategoryList", categoryList);
		return model;
	}*/
	
	/*@PostMapping("/CreateProductStep3")
	public ModelAndView AddProductStep3(ModelAndView model, @ModelAttribute("ProductInputForm") Product productForm, @ModelAttribute("CheckExclusive") String exclusive,
			@ModelAttribute("CheckEnabled") String enabled, @ModelAttribute("SelectedCate") String selectedCate) 
	{
		if(exclusive.contains("Exclusive")) productForm.setExclusive(true);
		if(exclusive.contains("NotExclusive")) productForm.setExclusive(false);
		
		if(enabled.contains("Enable")) productForm.setEnabled(true);
		if(enabled.contains("Disable")) productForm.setEnabled(false);
		//if(!catechosen.isEmpty()) System.out.println("Category is:"+catechosen);
		//else System.out.println("Category is empty");
		//ProductColorVariant colorVariant = new  ProductColorVariant();
		//productForm.getColorVariant().add(colorVariant);
		CategoryBasedSpecification specInputForm = new CategoryBasedSpecification();
		if(specFormList != null) 
		{
			for(CategoryBasedSpecification specForm: specFormList) 
			{
				if(specForm.getCategory().equals(selectedCate)) 
				{
					specInputForm = specForm;
				}
			}
			if(specInputForm == null) System.out.println("No suitable Spec form found");
			else System.out.println(specInputForm.toString().replace("[", "").replace("]", ""));
		}
		else System.out.println("Spec form is null");
		String proID = productForm.getProductID();
		if(proID.isEmpty()) System.out.println("Product ID is null");
		else System.out.println("Product ID="+proID);
		//model.addObject("ProductInputForm2", productForm);
		model.setViewName("ProductView");
		model.addObject("SpecInputForm", specInputForm);
		model.addObject("ColorList", colorList);
		model.addObject("ProductID", proID);
		//model.addObject("CategoryList", categoryList);
		return model;
	}*/
	
	@PostMapping("/products-management/create-product")
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
		/*boolean stopLoop =false;
		boolean addSpec =true;
		for(SpecSection sect: specform1.getSection()) 
		{
			for(Attributes kvpair : sect.getAttributes()) 
			{
				if(kvpair.getValue().toString().contains("split multiple values with ;") )
				{
					stopLoop =true;
					addSpec = false;
					break;
				}
				if(stopLoop) break;
			}
		}
		if(addSpec) 
		{
			String json = "";
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			try {
				json = mapper.writeValueAsString(specform1);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			productForm.getSpecifications().setProductSpecifications(json);
		}*/
		
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
	
	@GetMapping("/products-management/view-products")
	public ModelAndView viewProducts(ModelAndView model) {
		
		String path ="/images/3x4.jpg";
		List<Product> productList = productServ.showAllProducts();
		//Product p = productRepo.findByProductID("XR123");
		//System.out.println(p.toString());
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		model.setViewName("ProductView");
		return model;
	}
	
	@GetMapping("/promotions-management/view-promotions")
	public ModelAndView viewPromotions(ModelAndView model) {
	
		List<PromoteCode> promoteList = promotionServ.getAllPromotes();
		model.addObject("PromoteList", promoteList);
		model.setViewName("Promoteview");
		return model;
	}
	
	@GetMapping("/products-management/view-or-update-product/{proID}")
	public ModelAndView viewOrUpdateProducts(ModelAndView model, @PathVariable("proID") String productIdentity) {
		
		Product p = productRepo.findByProductID(productIdentity);
		//System.out.println(p.toString());
		model.addObject("ProductUpdateForm", p);
		//model.addObject("ProductList", productList);
		model.setViewName("ProductDetailsOrUpdate");
		return model;
	}
	
	@PostMapping("/products-management/update-product/")
	public ModelAndView UpdateProduct(ModelAndView model, @ModelAttribute("ProductUpdateForm") Product toUpdateForm,
			@ModelAttribute("CheckExclusive") String exclusiveSetter, @ModelAttribute("CheckEnable") String enableSetter) {
		
		//System.out.println(p.toString());
		if(exclusiveSetter.contains("Exclusive")) toUpdateForm.setExclusive(true);
		if(exclusiveSetter.contains("NotExclusive")) toUpdateForm.setExclusive(false);
		
		if(enableSetter.contains("Enable")) toUpdateForm.setEnabled(true);
		if(enableSetter.contains("Disable")) toUpdateForm.setEnabled(false);
		
		int foundForm = 0;
		int loopIndex = 0;
		/*String productIdentifier = "";
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
			
		}*/
		System.out.println("product after update is:"+toUpdateForm);
		
		//productList.set(foundForm, toUpdateForm);
		//toUpdateform.setPromoteCodeID(promoteID);
		//productRepo.save(toUpdateForm);
		//model.addObject("PromoteForm", form);
		model.setViewName("redirect:/Admin/ViewProduct");
		//model.addObject("ProductList", productList);
		return model;
	}
	
	@GetMapping("/promotions-management/create-promotion")
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

	@PostMapping("/promotions-management/create-promotion")
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
		promotionServ.savePromote(form);
		//promoteList.add(form);
		//model.addObject("PromoteForm", form);
		model.setViewName("redirect:/Admin/ViewPromote");
		return model;
	}
	
	@GetMapping("/promotions-management/update-promotion/{promote}")
	public ModelAndView UpdatePromotion(ModelAndView model, @PathVariable("promote") String promoteName) 
	{
		boolean breakLoop = false;
		int checkEnabled = 0;
		PromoteCode promote= promotionServ.getPromoteByName(promoteName);
		/*PromoteCode form = new PromoteCode();
		for(PromoteCode promotion: promoteList) 
		{
			
			if(promoteName.equals(promotion.getPromoteCodeName())) 
			{
				breakLoop =true;
				form = promotion;
			}
			if(breakLoop) break;
			
		}*/
		//System.out.println("promoteID before is:"+form.getPromoteCodeID() );
		/* if(form.getEnabled()) checkEnabled =1;
		model.addObject("Enabling", checkEnabled);*/
		model.addObject("PromoteUpdateForm", promote);
		model.setViewName("PromoteUpdate");
		return model;
	}
	
	@PostMapping("/promotions-management/update-promotion")
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
		/*for(PromoteCode promotion: promoteList) 
		{
			
			if(updateform.getPromoteCodeID() == promotion.getPromoteCodeID()) 
			{
				breakFindLoop =true;
				foundForm = loopIndex;
				promoteID = promotion.getPromoteCodeID();
			}
			if(breakFindLoop) break;
			loopIndex+=1;
			
		}*/
		System.out.println("promoteID after is:"+promoteID);
		//promoteList.set(foundForm, updateform);
		updateform.setPromoteCodeID(promoteID);
		promotionServ.savePromote(updateform);
		//model.addObject("PromoteForm", form);
		model.setViewName("redirect:/Admin/ViewPromote");
		return model;
	}
}
