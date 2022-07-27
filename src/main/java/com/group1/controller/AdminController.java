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
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
import com.group1.service.product.ProductArticleService;
import com.group1.service.product.ProductCameraShotService;
import com.group1.service.product.ProductColorVariantService;
import com.group1.service.product.ProductDiscountService;
import com.group1.service.product.ProductFeatureService;
import com.group1.service.product.ProductService;
import com.group1.service.product.ProductSpecificationService;
import com.group1.service.product.ProductTechSpecsService;
import com.group1.service.product.ProductUnboxingService;
import com.group1.service.product.ProductVariantService;
import com.group1.service.shopping.PromoteCodeService;
import com.group1.service.user.UserService;

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
	
	@Autowired
	UserService userServ;
	
	boolean loadCateBasedSpecForm = false;
	
	@GetMapping("/check-user/{name}")
	public User getUser(@PathVariable("name") String userName) 
	{
		User user = userServ.getUserByName(userName);
		return user;
	}
	
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
	
	@PostMapping("/convert-specs-to-list")
	public List<SpecSection> convertToSpecSection(@RequestBody String jsonString)
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
	

	@GetMapping("/get-categories")
	public List<Category> getAllCategories() 
	{

		List<Category> categoryList = cateServ.getAllCategories();

		return categoryList;
	}
	

	@PostMapping("/get-specific-category")
	public Category findCertainCategory(@RequestBody int ID) 
	{
		Integer cateID = Integer.valueOf(ID);
		//System.out.println("Cate name BE:"+cateName);
		Category category = cateServ.getSpecificCategory(cateID);
		return category;
	}
	

	@GetMapping("/get-colors")
	public List<Color> getAllColors() 
	{
		List<Color> colorList = colorServ.retrieveAllColors();
		return colorList;
	}
	

	@PostMapping("/get-category-brands")
	public List<Manufacturer> getBrandsOfACate(@RequestBody Integer id) 
	{
		List<Manufacturer> brandList = manuServ.getAllCateBrands(id);
		return brandList;
	}

	@PostMapping("/get-category-specs")
	public List<ProductTechSpecs> getSpecsOfACate(@RequestBody Integer id) 
	{
		List<ProductTechSpecs> cateSpecList = specServ.findAllSpecsByCateID(id);
		return cateSpecList;
	}
	

	@PostMapping("/get-specific-product")
	public Product getAnExistingProduct(@RequestBody String proID) 
	{
		Product product = productServ.getProductByID(proID);
		
		if(product.getManufacturer() != null) 
		{
			if(product.getManufacturer().getCateIDReferrence() != null) product.getManufacturer().setCateIDReferrence(null);
			if(product.getManufacturer().getProductList() != null) product.getManufacturer().setProductList(null);
		}
		
		if(product.getCategory() != null) {
			
		 	if(product.getCategory().getBrandList() != null) product.getCategory().setBrandList(null);
		 	if(product.getCategory().getProductList() != null) product.getCategory().setProductList(null);
		 	if(product.getCategory().getSpecList() != null) product.getCategory().setSpecList(null);
		}
		
		if(product.getOriginal() != null) 
		{
			for(ProductVariant it: product.getOriginal()) 
			{
				if(it.getProductOrigin() != null) it.setProductOrigin(null);
				if(it.getProductVariantIdentifier() != null) it.setProductVariantIdentifier(null);
			}
		}
		if(product.getArticle().getProductArticleIdentifier() != null) product.getArticle().setProductArticleIdentifier(null);
		
		if(product.getCameraShots() != null) {
			for(ProductCameraShot item: product.getCameraShots()) 
			{
				if(item.getProductCameraShotIdentifier() != null) item.setProductCameraShotIdentifier(null);
			}
		}
		
		if(product.getColorVariant() != null) 
		{
			for(ProductColorVariant item :product.getColorVariant()) 
			{ 
				if(item.getProductColorVariantIdentifier() != null) item.setProductColorVariantIdentifier(null);
			}
		}
		
		if(product.getFeatures() != null)
		{
			for(ProductFeature el: product.getFeatures()) 
			{ 
				if(el.getProductFeatureIdentifier() != null) el.setProductFeatureIdentifier(null);
			}
		}
		
		if(product.getDiscount() != null) 
		{
			if(product.getDiscount().getProductIdentifier() != null) product.getDiscount().setProductIdentifier(null);
		}
		
		if(product.getUnboxing() != null) 
		{
			for(ProductUnboxingReview el: product.getUnboxing()) 
			{ 
				if(el.getProductUnboxingReviewIdentifier() != null) el.setProductUnboxingReviewIdentifier(null);
			}
		}
		
		if(product.getVariant() != null) 
		{
			if(product.getVariant().getProductOrigin() != null) product.getVariant().setProductOrigin(null);
			if(product.getVariant().getProductVariantIdentifier() != null) product.getVariant().setProductVariantIdentifier(null);
		}

		if(product.getSpecifications() != null) 
		{
			if(product.getSpecifications().getProductSpecificationIdentifier() != null)
			product.getSpecifications().setProductSpecificationIdentifier(null);
		}
		return product;
	}
	
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

	@PostMapping("/products-management/create-product")
	public Product AddProductProcess(@RequestBody Product productForm) 
	{
		System.out.println("At final create product step"+productForm.toString());
		//productServ.saveNewProduct(productForm);
		return productForm;
	}
	
	@GetMapping(value = "/products-management/view-products")
	public List<Product> viewProducts(ModelAndView model, 
			@RequestParam(name = "category", required = false) Integer category,
			@RequestParam(name = "manufacturer", required = false) Integer manufacturer,
			@RequestParam(name = "name", required = false) String name) {

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
		
		if (name != null) {
			productList = productList.stream().filter(p->p.getProductName()
									 .toLowerCase().contains(name))
									 .collect(Collectors.toList());					
		} 
		
		for (Product pro : productList) {
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		return productList;
	}

	@GetMapping(value = "/products-management/view-category")
	public List<Category> viewByCategory(ModelAndView model) {

		List<Category> categoryList = cateServ.getAllCategories();
		return categoryList;

	}

	@GetMapping(value = "/products-management/view-manufacturer")
	public List<Manufacturer> viewByManufacturerByCategory(ModelAndView model,
			@RequestParam(required = true) Integer categoryId) {

		List<Manufacturer> manufacturerList = manuServ.getAllCateBrands(categoryId);
		return manufacturerList;

	}

	@GetMapping("/products-management/view-or-update-product/step-1/{proID}")
	public ModelAndView viewOrUpdateProductsStep1(ModelAndView model, @PathVariable("proID") String productIdentifier) {
	
		model.addObject("pID", productIdentifier);
		//model.setViewName("ProductDetailsOrUpdate");
		return model;

	}

	@PostMapping("/products-management/view-or-update-product/step-2")
	public Product viewOrUpdateProducts( @RequestBody String productIdentity, 
			@RequestParam("AddColor") String additionColor) {
		
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
			

				for(ProductCameraShot item: p.getCameraShots()) 
				{
					item.setToShowImage(Base64.getEncoder().encodeToString(item.getImage()) );
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
			for(ProductFeature el: p.getFeatures()) 
			{ 
				el.setToShowImage(Base64.getEncoder().encodeToString(el.getImage()) );
			}
		}
		
		if(p.getUnboxing() != null) 
		{
			for(ProductUnboxingReview el: p.getUnboxing()) 
			{ 
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
	public Product UpdateProduct( @RequestBody Product toUpdateForm) {
		
		System.out.println("product after update is:"+toUpdateForm);
		//productServ.saveNewProduct(toUpdateForm);
		return toUpdateForm;
	}
	
	@GetMapping(value="/promotions-management/view-promotions")
	public List<PromoteCode> viewPromotions(ModelAndView model) {
	
		List<PromoteCode> promoteList = promotionServ.getAllPromotes();
		return promoteList;
	}

	@GetMapping("/promotions-management/get-promotion/{promoteName}")
	public PromoteCode getPromotion(@RequestBody(required = false) String promoteName, @PathVariable("promoteName") String promote) {
		//String promoteName = proName;

		PromoteCode promotecode = new PromoteCode();
		if(promote == null) promotecode = promotionServ.getPromoteByName(promoteName);
		else if(promote != null) promotecode = promotionServ.getPromoteByName(promote);
		return promotecode;
	}

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

			promotionServ.savePromote(updateform);
			System.out.println("Promotion has successfully been updated");
			System.out.println("Promotion details:" + updateform.toString());
		}
			
		return null;
	}
}