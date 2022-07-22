package com.group1.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.hibernate.annotations.Parameter;
import org.hibernate.boot.model.source.internal.hbm.ModelBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.group1.dto.Attributes;
import com.group1.dto.MultiFieldsFilePathDTO;
import com.group1.dto.SpecSection;
import com.group1.dto.ColorVariantUpdateDTO;
import com.group1.entities.user.User;
import com.group1.entities.user.Role;
import com.group1.entities.product.Category;
import com.group1.entities.product.Color;
import com.group1.entities.product.Manufacturer;
import com.group1.entities.product.Product;
import com.group1.entities.product.ProductArticle;
import com.group1.entities.product.ProductCameraShot;
import com.group1.entities.product.ProductColorVariant;
import com.group1.entities.product.ProductDiscount;
import com.group1.entities.product.ProductFeature;
import com.group1.entities.product.ProductSpecification;
import com.group1.entities.product.ProductTechSpecs;
import com.group1.entities.product.ProductUnboxingReview;
import com.group1.entities.product.ProductVariant;
import com.group1.entities.shopping.PromoteCode;
import com.group1.repositories.product.CategoryRepo;
import com.group1.repositories.product.ColorRepo;
import com.group1.repositories.product.ManufacturerRepo;
import com.group1.repositories.user.UserRepo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.group1.service.product.CategoryService;
import com.group1.service.product.ColorService;
import com.group1.service.product.ManufacturerService;
import com.group1.service.product.ProductService;
import com.group1.service.product.ProductTechSpecsService;
import com.group1.service.shopping.PromoteCodeService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	PromoteCodeService promotionServ;
	
	@Autowired
	ProductService productServ;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ManufacturerService manuServ;
	
	@Autowired
	CategoryService cateServ;

	@Autowired
	ManufacturerRepo manuRepo;
	
	@Autowired
	ColorService colorServ;
	
	@Autowired
	ProductTechSpecsService specServ;
	
	boolean loadCateBasedSpecForm = false;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/convert-specs-to-form")
	public List<SpecSection> loadCateBasedSpecificationForm(@RequestBody List<ProductTechSpecs> specList) 
	{
		List<SpecSection> sectionList =new ArrayList<SpecSection>();
		List<Attributes> attrList =new ArrayList<Attributes>();
		SpecSection section =new SpecSection();

		for(ProductTechSpecs spec: specList) 
		{
			if(sectionList.size() == 0) 
			{
				section.setSection(spec.getSection());
				section.setAttributes(attrList);
				Attributes attr = new Attributes();
				attr.setKey(spec.getSpecName());
				attr.setValue("");
				section.getAttributes().add(attr);
				sectionList.add(section);
				continue;
			}

			if(sectionList.get(sectionList.size()-1).getSection().equals(spec.getSection()) ) 
			{
				Attributes attr = new Attributes();
				attr.setKey(spec.getSpecName());
				attr.setValue("");
				sectionList.get(sectionList.size()-1).getAttributes().add(attr);
			} 
			else
			{
				section = new SpecSection();
				section.setSection(spec.getSection());
				attrList = new ArrayList<Attributes>();
				
				Attributes attr = new Attributes();
				attr.setKey(spec.getSpecName());
				attr.setValue("");
				attrList.add(attr);
				section.setAttributes(attrList);
				sectionList.add(section);
			}
		}
		return sectionList;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/convert-to-json-string")
	public String convertToJsonString(@RequestBody Object objectToConvert) 
	{
		String jsonConverted = "";
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		mapper.registerModule(new JavaTimeModule());
		try {
			jsonConverted = mapper.writeValueAsString(objectToConvert);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return jsonConverted;
	}
	
	
	public List<SpecSection> convertToSpecSection(String jsonString)
	{
		ObjectMapper mapper = new ObjectMapper();
		List<SpecSection> specList = new ArrayList<SpecSection>();
		try {
			specList = mapper.readValue(jsonString.getBytes(), 
					new TypeReference<List<SpecSection>>() {});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
		
		return specList;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/convert-date-time")
	public LocalDateTime converttoLocalDateTime(@RequestBody LocalDateTime toConvertTime) 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("Date time:"+toConvertTime);
		
		String formatedDateTime = toConvertTime.format(dtf);
		System.out.println("Formatted date time:"+formatedDateTime);
		
		LocalDateTime finalFormatedTime = LocalDateTime.parse(formatedDateTime, dtf); 
		
		System.out.println("Formatted end time in object:"+finalFormatedTime);
		return finalFormatedTime;
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

		return new ModelAndView("LoginPage");
	}
	
	
	@PostMapping("/loginAction") 
	  public ModelAndView checkLogin(@ModelAttribute("login") User user, HttpSession session) {
	  
		  ModelAndView model =new ModelAndView();
		  User userdata = UserRepo.findByUserNameAndPassWord(user.getUserName(),user.getPassword()); 
			  if (userdata != null) 
			  {   
				  Long createdTime= session.getCreationTime();
				  System.out.println("Session created at:" + createdTime);
				  session.setMaxInactiveInterval(60*30);
				  int sessionage= session.getMaxInactiveInterval();
				  System.out.println("Session will self-destroy in:" + sessionage);
				  
				  if (userdata.getRoleId().equals("1")) 
				  {
					  model.setViewName("index");
					  return model; 
				  }
				  model.setViewName("ProductView");
				  
				  return model; 
				  
	          } 
			  else 	          
	        	 return model; 
	          
	  }
	
	@CrossOrigin(origins = "*")
	@GetMapping("/get-categories")
	public List<Category> getAllCategories() 
	{

		List<Category> categoryList = cateServ.getAllCategories();

		return categoryList;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/get-specific-category")
	public Category findCertainCategory(@RequestBody int ID) 
	{
		Integer cateID = Integer.valueOf(ID);
		//System.out.println("Cate name BE:"+cateName);
		Category category = cateServ.getSpecificCategory(cateID);
		return category;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/get-colors")
	public List<Color> getAllColors() 
	{
		List<Color> colorList = colorServ.retrieveAllColors();
		return colorList;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/get-category-brands")
	public List<Manufacturer> getBrandsOfACate(@RequestBody Integer id) 
	{
		List<Manufacturer> brandList = manuServ.getAllCateBrands(id);
		return brandList;
	}
		
	@CrossOrigin(origins = "*")
	@PostMapping("/get-category-specs")
	public List<ProductTechSpecs> getSpecsOfACate(@RequestBody Integer id) 
	{
		List<ProductTechSpecs> cateSpecList = specServ.findAllSpecsByCateID(id);
		return cateSpecList;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/get-specific-product")
	public Product getAnExistingProduct(@RequestBody String proID) 
	{
		Product product = productServ.getProductByID(proID);
		return product;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/check-product-exist")
	public Boolean testIfProductExist(@RequestBody String prodID) 
	{
		Boolean prodExist = productServ.checkProductExist(prodID);
		return prodExist;
	}
	
	/*@CrossOrigin(origins = "*")
	@GetMapping(value="/products-management/create-product/step-1")
	public Product AddProductStep1(@RequestParam("catechosen") int catechosen, @RequestParam("addColor") int colorVarNum) 
	{
		
	}*/
	
	@CrossOrigin(origins = "*")
	@PostMapping(value="/products-management/create-product")
	public Product AddProductProcess(@RequestBody Product productForm) 
	{
		System.out.println("At final create product step"+productForm.toString());
		return productForm;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/products-management/view-products")
	public List<Product> viewProducts(ModelAndView model, 
			@RequestParam(name = "category", required = false) Integer category,
			@RequestParam(name = "manufacturer", required = false) Integer manufacturer) {

		List<Product> productList = null;

		if (category != null) {
			if (manufacturer != null) {
				productList = productServ.findProductByManufacturer(manufacturer);
			} else {
				productList = productServ.findProductByCategory(category);
			}

		} else {
			productList = productServ.showAllProducts();
		}

		for (Product pro : productList) {
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		return productList;
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/products-management/view-category")
	public List<Category> viewByCategory(ModelAndView model) {

		List<Category> categoryList = cateServ.getAllCategories();
		return categoryList;

	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/products-management/view-manufacturer")
	public List<Manufacturer> viewByManufacturerByCategory(ModelAndView model,
			@RequestParam(required = true) Integer categoryId) {

		List<Manufacturer> manufacturerList = manuServ.getAllCateBrands(categoryId);
		return manufacturerList;

	}
	
	@GetMapping("/products-management/view-or-update-product/step-1/{proID}")
	public ModelAndView viewOrUpdateProductsStep1(ModelAndView model, @PathVariable("proID") String productIdentifier) {
	
		model.addObject("pID", productIdentifier);
		model.setViewName("ProductDetailsOrUpdate");
		return model;

	}
	
	@GetMapping("/products-management/view-or-update-product/step-2/{proID}")
	public Product viewOrUpdateProducts( @PathVariable("proID") String productIdentity, 
			@ModelAttribute("AddColor") String additionColor) {
		
		Integer additionalColor = Integer.valueOf(additionColor);
		//Product p = productRepo.findByProductID(productIdentity);
		
		Product p = getAnExistingProduct(productIdentity);
		//MultiFieldsFilePathDTO multi = new MultiFieldsFilePathDTO();
		List<ProductColorVariant> colorInputFormList = new ArrayList<ProductColorVariant>();
		List<Color> colorList = getAllColors();
		List<Color> backUpColorList = new ArrayList<Color>();
		backUpColorList.addAll(colorList);
		List<ColorVariantUpdateDTO> colorVarUpdateList = new ArrayList<ColorVariantUpdateDTO>();
		p.setImageToShow(Base64.getEncoder().encodeToString(p.getImage()) );
		
		if(p.getArticle() == null) 
		{
			ProductArticle articleObj = new ProductArticle();
			p.setArticle(articleObj);
		}
		
		if(p.getCameraShots() != null) {
			for(Iterator<ProductCameraShot> t = p.getCameraShots().iterator(); t.hasNext();) 
			{ 
				ProductCameraShot el = t.next();
				el.setToShowImage(Base64.getEncoder().encodeToString(el.getImage()) );
			}
		}
		
		if(p.getColorVariant() != null) 
		{
			Integer setColorID = 0;
			Integer colorListColorID = 0;
			for(Iterator<ProductColorVariant> t = p.getColorVariant().iterator(); t.hasNext();) 
			{ 
				ProductColorVariant el = t.next();
				setColorID = el.getColorID();
				el.setToShowImage(Base64.getEncoder().encodeToString(el.getImage()) );
				
				if(colorVarUpdateList.size() == 0) {
					ColorVariantUpdateDTO colUpdateForm = new ColorVariantUpdateDTO();
					colUpdateForm.setForColorID(el.getColorID());
					colorVarUpdateList.add(colUpdateForm);
				}
				
				int countOccur = 0;
				if(colorVarUpdateList.size() > 0) {
					for(ColorVariantUpdateDTO obj: colorVarUpdateList) {
						if(obj.getForColorID() != el.getColorID()) {
							countOccur +=1;
						}
					}
					if(countOccur == colorVarUpdateList.size()) {
						ColorVariantUpdateDTO colUpdateForm = new ColorVariantUpdateDTO();
						colUpdateForm.setForColorID(el.getColorID());
						colorVarUpdateList.add(colUpdateForm);
					}
				}
				
				if(additionalColor >0) 
				{	
					if(setColorID != colorListColorID)
					{
						for(Iterator<Color>  col = colorList.iterator(); col.hasNext();) 
						{
							Color colorCheck = col.next();
							if(colorCheck.getColorID() == el.getColorID()) 
							{
								colorListColorID = colorCheck.getColorID();
								col.remove();
								break;
							}
						}	
					}
				}
			}
			p.setColorVarUpdateList(colorVarUpdateList);
			for(ColorVariantUpdateDTO updateEL: p.getColorVarUpdateList()) 
			{	
				for(Color colour: backUpColorList) 
				{
					if(colour.getColorID() == updateEL.getForColorID()) 
					{
						updateEL.setForColorName(colour.getColorName());
						break;
					}
				}
			}
		}
		
		if(additionalColor >0) {
			p.setColorVariantInputList(colorInputFormList);
			
				for(int i = 0; i < additionalColor;i++) {
					ProductColorVariant colorvar = new ProductColorVariant();
					p.getColorVariantInputList().add(colorvar);
				}
			
			}
		
		if(p.getDiscount() == null) 
		{
			ProductDiscount discountObj = new ProductDiscount();
			p.setDiscount(discountObj);
		}
		else 
		{
			p.getDiscount().setStartDateInput(p.getDiscount().getStartDate());
			p.getDiscount().setEndDateInput(p.getDiscount().getEndDate());
		}
		
		if(p.getFeatures() != null)
		{
			for(Iterator<ProductFeature> t = p.getFeatures().iterator(); t.hasNext();) 
			{ 
				ProductFeature el = t.next();
				el.setToShowImage(Base64.getEncoder().encodeToString(el.getImage()) );
			}
		}
		
		
		if(p.getUnboxing() != null) 
		{
			for(Iterator<ProductUnboxingReview> t = p.getUnboxing().iterator(); t.hasNext();) 
			{ 
				ProductUnboxingReview el = t.next();
				el.setToShowImage(Base64.getEncoder().encodeToString(el.getImage()) );
			}
		}
		
		if(p.getVariant() == null) 
		{
			ProductVariant variantObj = new ProductVariant();
			p.setVariant(variantObj);
		}
		
		if(p.getSpecifications() != null) 
		{
			List<SpecSection> specShow = convertToSpecSection(p.getSpecifications().getProductSpecifications());
			p.setSpecList(specShow);
		}
		System.out.println("Before update:"+p.toString());
		
		return p;
	}
	
	@PostMapping("/products-management/update-product")
	public ModelAndView UpdateProduct(ModelAndView model, @ModelAttribute("ProductUpdateForm") Product toUpdateForm,
			@ModelAttribute("CheckExclusive") String exclusiveSetter, @ModelAttribute("CheckEnable") String enableSetter, 
			@ModelAttribute("MultiField") MultiFieldsFilePathDTO filepath, 
			@ModelAttribute("CheckDiscountEnable") String discountSetter, 
			@ModelAttribute("AddColor") String addCountColor) {
		
			Integer countAdditionColors = Integer.valueOf(addCountColor);
		
		if(exclusiveSetter.contains("Exclusive")) toUpdateForm.setExclusive(true);
		if(exclusiveSetter.contains("NotExclusive")) toUpdateForm.setExclusive(false);
		
		if(enableSetter.contains("Enable")) toUpdateForm.setEnabled(true);
		if(enableSetter.contains("Disable")) toUpdateForm.setEnabled(false);
		
		if(discountSetter.contains("Enable")) toUpdateForm.getDiscount().setEnabled(true);
		if(discountSetter.contains("Disable"))  toUpdateForm.getDiscount().setEnabled(false);
		int errorCount = 0;
		Product compareProduct = productServ.getProductByID(toUpdateForm.getProductID());
		
		//List<ColorVariantUpdateDTO> colorVarUpdateList = new ArrayList<ColorVariantUpdateDTO>();
		List<Color> colorList  = colorServ.retrieveAllColors();
		List<Color> backUpColorList  = new ArrayList<Color>();
		backUpColorList.addAll(colorList);
		if(toUpdateForm.getColorVariantInputList() != null && toUpdateForm.getColorVariantInputList().size() >1)
		{
			Integer prevID = 0;
			Integer currID =0;
			boolean foundDup = false;
			for(ProductColorVariant colorVar: toUpdateForm.getColorVariantInputList()) 
			{
				if(prevID == 0) 
				{
					prevID =  colorVar.getColorID();
					currID = colorVar.getColorID();
					continue;
				}
				currID = colorVar.getColorID();
				if(currID == prevID) 
				{
					foundDup = true;
					break;
				}
				prevID = currID;
			
			}
			if(foundDup) 
			{
				System.out.println("Duplicating color found");
				errorCount +=1;
				String duplicateColorWarning = "Duplicating color";
				model.addObject("dupColor1", duplicateColorWarning);
			}	
		}

		if(toUpdateForm.getDiscount().getDiscountedPrice() != null && toUpdateForm.getDiscount().getDiscountPercent() != null 
				&& toUpdateForm.getDiscount().getStartDateInput() != null  && toUpdateForm.getDiscount().getEndDateInput() != null 
				&& !discountSetter.isEmpty()) 
				{
					if(toUpdateForm.getDiscount().getStartDateInput().isEqual(toUpdateForm.getDiscount().getEndDateInput())) 
					{
						System.out.println("Discount start date and end date cannot be the same");
						errorCount +=1;
						String startEqualsEnd = "Discount start date and end date cannot be the same";
						model.addObject("StartEqualsEnd1", startEqualsEnd);
					}
					else if(toUpdateForm.getDiscount().getStartDateInput().isAfter(toUpdateForm.getDiscount().getEndDateInput())) 
					{
						System.out.println("Discount start date cannot be after to end date");
						errorCount +=1;
						String startAfterEnd = "Discount start date and end date cannot be the same";
						model.addObject("StartAfterEnd1", startAfterEnd);
					}
				}
		
		if(errorCount >0) 
		{
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime limit = now.plusMonths(2);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");		
			
			String formatedNowTime = now.format(dtf);
			String formatedLimitTime = limit.format(dtf);
			
			if(compareProduct.getColorVariant() != null) 
			{
					//Integer setColorID = 0;
					//Integer colorListColorID = 0;
				for(Iterator<ProductColorVariant> t = compareProduct.getColorVariant().iterator(); t.hasNext();) 
				{ 
					ProductColorVariant el = t.next();
					el.setToShowImage(Base64.getEncoder().encodeToString(el.getImage()) );
				}
				toUpdateForm.setColorVariant(compareProduct.getColorVariant());
					
					/*for(ColorVariantUpdateDTO updateEL: toUpdateForm.getColorVarUpdateList()) 
					{	
						for(Color colour: backUpColorList) 
						{
							if(colour.getColorID() == updateEL.getForColorID()) 
							{
								updateEL.setForColorName(colour.getColorName());
								break;
							}
						}
					}*/
			}
				
			if(countAdditionColors >0)
			{
				if(toUpdateForm.getColorVariant() != null && countAdditionColors >0) 
				{
					for(Iterator<Color> t = colorList.iterator(); t.hasNext();) 
					{
						Color ele = t.next();
						for(ProductColorVariant colorVariant : toUpdateForm.getColorVariant()) 
						{
							if(ele.getColorID() == colorVariant.getColorID()) 
							{
								t.remove();
								break;
							}
						}
					}
				}
				model.addObject("ColorList", colorList);
			}
			
			if(compareProduct.getSpecifications() != null) 
			{
				List<SpecSection> specShow = convertToSpecSection(compareProduct.getSpecifications().getProductSpecifications());	
				toUpdateForm.setSpecList(specShow);
			}
			
			if(compareProduct.getCameraShots() != null) {
				for(Iterator<ProductCameraShot> t = compareProduct.getCameraShots().iterator(); t.hasNext();) 
				{ 
					ProductCameraShot el = t.next();
					el.setToShowImage(Base64.getEncoder().encodeToString(el.getImage()) );
				}
				toUpdateForm.setCameraShots(compareProduct.getCameraShots());
			}
			
			if(compareProduct.getFeatures() != null)
			{
				for(Iterator<ProductFeature> t = compareProduct.getFeatures().iterator(); t.hasNext();) 
				{ 
					ProductFeature el = t.next();
					el.setToShowImage(Base64.getEncoder().encodeToString(el.getImage()) );
				}
				toUpdateForm.setFeatures(compareProduct.getFeatures());
			}
			
			
			if(compareProduct.getUnboxing() != null) 
			{
				for(Iterator<ProductUnboxingReview> t = compareProduct.getUnboxing().iterator(); t.hasNext();) 
				{ 
					ProductUnboxingReview el = t.next();
					el.setToShowImage(Base64.getEncoder().encodeToString(el.getImage()) );
				}
				toUpdateForm.setUnboxing(compareProduct.getUnboxing());
			}
			//System.out.println("Update product after error "+ toUpdateForm);
			MultiFieldsFilePathDTO multi = new MultiFieldsFilePathDTO();
			model.addObject("AdditionalColor", String.valueOf(countAdditionColors));
			model.addObject("MinDateTime", formatedNowTime);
			model.addObject("MaxDateTime", formatedLimitTime);
			model.addObject("ProductUpdateForm", toUpdateForm);
			model.addObject("MultiField", multi);
			model.setViewName("ProductDetailsOrUpdate");
		}
		

		if(errorCount ==0) 
		{
			
		int count = 0;
		if(!filepath.getImageFile()[0].getOriginalFilename().isEmpty()) {
			System.out.println("MultipartFile has "+ filepath.getImageFile().length);
			for(MultipartFile filePart: filepath.getImageFile()) 
			{
					count +=1;
					String contentType = filePart.getContentType();
					System.out.println("Type of multipartFile file no. "+ count + " :"+ contentType);
					toUpdateForm.setImageType(contentType);
					String fileName = filePart.getOriginalFilename();
					System.out.println("Name of multipartFile file no. "+ count + " :"+ fileName);
					try {
						toUpdateForm.setImage(filePart.getBytes());
					} catch (IOException e) {
					// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		else 
		{
			toUpdateForm.setImage(compareProduct.getImage());
			toUpdateForm.setImageType(compareProduct.getImageType());
		}
		
		String pID = toUpdateForm.getProductID();
		
		if(compareProduct.getArticle() == null) {
			if(toUpdateForm.getArticle().getArticleUrl().isEmpty()) 
			{
				System.out.println("Article is null");
				toUpdateForm.setArticle(null);
			} 
			else toUpdateForm.getArticle().setProductID(pID);
		}
		else
		{
			String newArticleUrl = toUpdateForm.getArticle().getArticleUrl();
			toUpdateForm.setArticle(compareProduct.getArticle());
			if(toUpdateForm.getArticle().getArticleUrl().isEmpty()) System.out.println("Update article URL is null");
			else
			{	
				System.out.println("Update article URL is not null");
				if(newArticleUrl.equals(toUpdateForm.getArticle().getArticleUrl())) 
				toUpdateForm.getArticle().setArticleUrl(newArticleUrl);
			}
			
		}
		
		int count1= 0;
		if(filepath.getCameraShotsFile()[0].getOriginalFilename().isEmpty() && compareProduct.getCameraShots() == null) 
		{
			System.out.println("Camera shots is null");
			toUpdateForm.setCameraShots(null);
		} 
		
		if(!filepath.getCameraShotsFile()[0].getOriginalFilename().isBlank())
		{
			if(compareProduct.getCameraShots() == null) {
				Set<ProductCameraShot> cameraSet = new  HashSet<ProductCameraShot>();
				toUpdateForm.setCameraShots(cameraSet);
			}
			else toUpdateForm.setCameraShots(compareProduct.getCameraShots());
			
			System.out.println("MultipartFile for cameraShot has "+ filepath.getCameraShotsFile().length);
			for(MultipartFile cameraFile: filepath.getCameraShotsFile()) 
			{
					count1 +=1;
					String contentType = cameraFile.getContentType();
					System.out.println("Type of multipartFile file no. "+ count1 + " :"+ contentType);
					String fileName = cameraFile.getOriginalFilename();
					System.out.println("Name of multipartFile file no. "+ count1 + " :"+ fileName);
					ProductCameraShot camShot = new ProductCameraShot();
					try {
						camShot.setImage(cameraFile.getBytes());
					} catch (IOException e) {
						e.printStackTrace();
					}
					camShot.setImageType(contentType);
					camShot.setProductID(pID);
					toUpdateForm.getCameraShots().add(camShot);
			}
			
		}	
			
		int countEl = 0;
		int countColor = 0;
		if(compareProduct.getColorVariant() == null) {
			Set<ProductColorVariant> colorSet = new  HashSet<ProductColorVariant>();
			toUpdateForm.setColorVariant(colorSet);
		}
		else 
		{
			int updateCount = 0;
			toUpdateForm.setColorVariant(compareProduct.getColorVariant());
			for(ColorVariantUpdateDTO update: toUpdateForm.getColorVarUpdateList()) 
			{
				if(!update.getUpdateFileDatas()[0].getOriginalFilename().isBlank())
				{
					System.out.println("Update MultipartFile of color ID. "+ update.getForColorID()
					+" has "+ update.getUpdateFileDatas().length);
					for(MultipartFile updateFile: update.getUpdateFileDatas()) 
					{
							updateCount +=1;
							String contentType = updateFile.getContentType();
							System.out.println("Type of multipartFile file no. "+ countColor + " :"+ contentType);
							String fileName = updateFile.getOriginalFilename();
							System.out.println("Name of multipartFile file no. "+ countColor + " :"+ fileName);
							ProductColorVariant toSaveEl = new ProductColorVariant();
							try {
								toSaveEl.setImage(updateFile.getBytes());
							} catch (IOException e) {
								e.printStackTrace();
							}
							toSaveEl.setImageType(contentType);
							toSaveEl.setProductID(pID);
							toSaveEl.setColorID(update.getForColorID());
							toUpdateForm.getColorVariant().add(toSaveEl);
					}
					updateCount =0;
				}
			}
		}
		if(toUpdateForm.getColorVariantInputList() != null) {
			for(Iterator<ProductColorVariant> t = toUpdateForm.getColorVariantInputList().iterator(); t.hasNext();) 
			{
				ProductColorVariant el = t.next();
				countEl +=1;
				if(el.getFileDatas()[0].getOriginalFilename().isEmpty()) 
				{
					t.remove();
				}
				else 
				{
					System.out.println("New MultipartFile of color no. "+ countEl+" has "+ el.getFileDatas().length);
					for(MultipartFile file: el.getFileDatas()) 
					{

							countColor +=1;
							String contentType = file.getContentType();
							System.out.println("Type of multipartFile file no. "+ countColor + " :"+ contentType);
							String fileName = file.getOriginalFilename();
							System.out.println("Name of multipartFile file no. "+ countColor + " :"+ fileName);
							ProductColorVariant toSaveEl = new ProductColorVariant();
							try {
								toSaveEl.setImage(file.getBytes());
							} catch (IOException e) {
								e.printStackTrace();
							}
							toSaveEl.setImageType(contentType);
							toSaveEl.setProductID(pID);
							toSaveEl.setColorID(el.getColorID());
							toSaveEl.setProductID(pID);
							toUpdateForm.getColorVariant().add(toSaveEl);
					}
				}
			}
			if(toUpdateForm.getColorVariant().size() ==0) toUpdateForm.setColorVariant(null);
		}
		
		if(toUpdateForm.getDiscount().getDiscountedPrice() == null || toUpdateForm.getDiscount().getDiscountPercent() == null
				|| toUpdateForm.getDiscount().getStartDateInput() == null || toUpdateForm.getDiscount().getEndDateInput() == null 
				 || discountSetter.isEmpty() || discountSetter == null) 
		{
			if(compareProduct.getDiscount() == null) toUpdateForm.setDiscount(null);
			
			else toUpdateForm.setDiscount(compareProduct.getDiscount());
		}
		if(toUpdateForm.getDiscount().getDiscountedPrice() != null && toUpdateForm.getDiscount().getDiscountPercent() != null
				 && toUpdateForm.getDiscount().getStartDateInput() == null && toUpdateForm.getDiscount().getEndDateInput() != null 
				 && discountSetter.isEmpty() || discountSetter != null) 
		{
			if(compareProduct.getDiscount() == null) {
				toUpdateForm.getDiscount().setProductID(pID);
			}
			else 
			{
				Integer newDiscountPrice = toUpdateForm.getDiscount().getDiscountedPrice();
				Integer newDiscountPercent = toUpdateForm.getDiscount().getDiscountedPrice();
				toUpdateForm.setDiscount(compareProduct.getDiscount());
				toUpdateForm.getDiscount().setDiscountedPrice(newDiscountPrice);
				toUpdateForm.getDiscount().setDiscountPercent(newDiscountPercent);
			}
			LocalDateTime startConvert = converttoLocalDateTime(toUpdateForm.getDiscount().getStartDateInput());
			toUpdateForm.getDiscount().setStartDate(startConvert);
			LocalDateTime endConvert = converttoLocalDateTime(toUpdateForm.getDiscount().getEndDateInput());
			toUpdateForm.getDiscount().setEndDate(endConvert);
			
			if(discountSetter.contains("Enable")) toUpdateForm.getDiscount().setEnabled(true);
			if(discountSetter.contains("Disable"))  toUpdateForm.getDiscount().setEnabled(false);
			
		}
		
		if(filepath.getFeatureFile()[0].getOriginalFilename().isEmpty() && compareProduct.getFeatures() == null) {
			System.out.println("Feature is null");
			toUpdateForm.setFeatures(null);
		}
		
		if(!filepath.getFeatureFile()[0].getOriginalFilename().isBlank())
		{
			if(compareProduct.getFeatures() == null) {
				Set<ProductFeature> featureSet = new  HashSet<ProductFeature>();
				toUpdateForm.setFeatures(featureSet);
			}
			else toUpdateForm.setFeatures(compareProduct.getFeatures());
			int count2 = 0;

			System.out.println("MultipartFile for feature has "+ filepath.getFeatureFile().length);
			for(MultipartFile featureFile: filepath.getFeatureFile()) 
			{
					count2 +=1;
					String contentType = featureFile.getContentType();
					System.out.println("Type of multipartFile file no. "+ count2 + " :"+ contentType);
					String fileName = featureFile.getOriginalFilename();
					System.out.println("Name of multipartFile file no. "+ count2 + " :"+ fileName);
					ProductFeature featureEl = new ProductFeature();
					try {
						featureEl.setImage(featureFile.getBytes());
					} catch (IOException e) {
						e.printStackTrace();
					}
					featureEl.setProductID(pID);
					featureEl.setImageType(contentType);
					toUpdateForm.getFeatures().add(featureEl);	
			}
		}
		
		int count3 = 0;
		if(filepath.getUnboxingFile()[0].getOriginalFilename().isEmpty() && compareProduct.getUnboxing() == null) 
		{
			System.out.println("Unboxing is null");
			toUpdateForm.setUnboxing(null);
		}
		
		if(!filepath.getUnboxingFile()[0].getOriginalFilename().isBlank())
		{
			if(compareProduct.getUnboxing() == null) {
				Set<ProductUnboxingReview> unboxSet = new  HashSet<ProductUnboxingReview>();
				toUpdateForm.setUnboxing(unboxSet);
			}
			else toUpdateForm.setUnboxing(compareProduct.getUnboxing());
			
			System.out.println("MultipartFile for unboxing has "+ filepath.getUnboxingFile().length);
			for(MultipartFile unboxFile: filepath.getUnboxingFile()) 
			{
					count3 +=1;
					String contentType = unboxFile.getContentType();
					System.out.println("Type of multipartFile file no. "+ count3 + " :"+ contentType);
					String fileName = unboxFile.getOriginalFilename();
					System.out.println("Name of multipartFile file no. "+ count3 + " :"+ fileName);
					ProductUnboxingReview unboxReview = new ProductUnboxingReview();
					try {
						unboxReview.setImage(unboxFile.getBytes());
					} catch (IOException e) {
						e.printStackTrace();
					}
					unboxReview.setProductID(pID);
					unboxReview.setImageType(contentType);
					toUpdateForm.getUnboxing().add(unboxReview);
			}
			
		}
		
		if(toUpdateForm.getVariant().getProductOriginalIdentifier().isEmpty()
		  || toUpdateForm.getVariant().getProductVariantName().isEmpty()) 
		{
			System.out.println("Variant is null");
			if(compareProduct.getVariant() == null) toUpdateForm.setVariant(null);
			
			else toUpdateForm.setVariant(compareProduct.getVariant());
			
		}
		else if(!toUpdateForm.getVariant().getProductOriginalIdentifier().isEmpty()
		&& !toUpdateForm.getVariant().getProductVariantName().isEmpty())
		{
			if(compareProduct.getVariant() == null) 
			{
				toUpdateForm.getVariant().setProductVariantID(pID);
			}
			
			else 
			{
				String newVariantName = toUpdateForm.getVariant().getProductVariantName();
				toUpdateForm.setVariant(compareProduct.getVariant());
				toUpdateForm.getVariant().setProductVariantName(newVariantName);
			}
			
		}
		toUpdateForm.setSpecifications(compareProduct.getSpecifications());
		
		System.out.println("product after update is:"+toUpdateForm);
		
		//toUpdateform.setPromoteCodeID(promoteID);
		//productRepo.save(toUpdateForm);
		model.addObject("StarAfterEnd1", null);
		model.addObject("StartEqualsEnd1", null);
		model.addObject("dupColor1", null);
		model.setViewName("redirect:/admin/products-management/view-products");
		}
		//model.setViewName("Result");
		//model.addObject("ProductList", productList);
		return model;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value="/promotions-management/view-promotions")
	public List<PromoteCode> viewPromotions(ModelAndView model) {
	
		List<PromoteCode> promoteList = promotionServ.getAllPromotes();
		return promoteList;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/promotions-management/get-promotion/{promoteName}")
	public PromoteCode getPromotion(@RequestBody(required = false) String promoteName, @PathVariable("promoteName") String promote) {
		//String promoteName = proName;

		PromoteCode promotecode = new PromoteCode();
		if(promote == null) promotecode = promotionServ.getPromoteByName(promoteName);
		else if(promote != null) promotecode = promotionServ.getPromoteByName(promote);
		return promotecode;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/promotions-management/create-promotion")
	public Object processAddNewPromotion(@RequestBody PromoteCode promoteInputForm) 
	{		
		int errorCount = 0;
		
		//ResponseEntity<PromoteCode> response1 = resttemp.getForEntity(checkPromoteExistUrl, PromoteCode.class);
		Map<String,String> errorMap = new HashMap<String, String>();
		PromoteCode checkPromote = getPromotion(promoteInputForm.getPromoteCodeName(),null);
		if(checkPromote != null) 
		{
			System.out.println("Promotion name already existed");
			errorCount +=1;
			String promoteNameDupWarning = "Promotion name already existed";
			errorMap.put("PromoteNameDup", promoteNameDupWarning);
		}
		
		if(promoteInputForm.getStartDateInput().isEqual(promoteInputForm.getEndDateInput())) 
		{
			System.out.println("Promotion start date and end date cannot be the same");
			errorCount +=1;
			String startSameAsEnd = "Promotion start date and end date cannot be the same";
			errorMap.put("StartSameAsEnd", startSameAsEnd);
		}
		else if(promoteInputForm.getStartDateInput().isAfter(promoteInputForm.getEndDateInput())) 
		{
			System.out.println("Promotion start date cannot be after end date");
			errorCount +=1;
			String starIsAfterEnd = "Promotion start date can't be after end date";
			errorMap.put("StartIsAfterEnd", starIsAfterEnd);
		}
		
		if(errorCount >0) 
		{
			System.out.println("Calling error BE");
			return errorMap;
		}
		
		if(errorCount == 0) 
		{
			LocalDateTime convertStartTime = converttoLocalDateTime(promoteInputForm.getStartDateInput());  

			LocalDateTime convertEndTime = converttoLocalDateTime(promoteInputForm.getEndDateInput()); 
					
			promoteInputForm.setStartDate(convertStartTime);
			promoteInputForm.setEndDate(convertEndTime);
			System.out.println("Promotion successfully created: "+promoteInputForm);
			//promotionServ.savePromote(form);
		}
		
		return null;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/promotions-management/update-promotion")
	public Object processUpdatePromotion(@RequestBody PromoteCode updateform) 
	{
		int errorCount = 0;
		Map<String,String> errorMap = new HashMap<String, String>();
		if(updateform.getStartDateInput().isEqual(updateform.getEndDateInput())) 
		{
			System.out.println("Promotion start date and end date cannot be the same");
			errorCount +=1;
			String startSameAsEnd = "Promotion start date and end date cannot be the same";
			errorMap.put("StartSameAsEnd", startSameAsEnd);
		}
		else if(updateform.getStartDateInput().isAfter(updateform.getEndDateInput())) 
		{
			System.out.println("Promotion start date cannot be after end date");
			errorCount +=1;
			String starIsAfterEnd = "Promotion start date can't be after end date";
			errorMap.put("StartIsAfterEnd", starIsAfterEnd);
		}
		
		if(errorCount >0) 
		{
			return errorMap;
		}
		
		if(errorCount == 0)
		{
			LocalDateTime convertedCurrentTime = converttoLocalDateTime(updateform.getStartDateInput());

			LocalDateTime convertedEndTime = converttoLocalDateTime(updateform.getEndDateInput());
	
			updateform.setStartDate(convertedCurrentTime);
			updateform.setEndDate(convertedEndTime);

			System.out.println("Promotion has successfully been updated");
			System.out.println("Promotion details:" + updateform.toString());
		}
			
		return null;
	}
}