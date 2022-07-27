package com.group1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group1.entities.product.Category;
import com.group1.entities.product.Manufacturer;
import com.group1.entities.product.Product;
import com.group1.dto.SpecSection;
import com.group1.dto.CustomerViewProductDetails.ArticleDetails;
import com.group1.dto.CustomerViewProductDetails.CameraShotsDetails;
import com.group1.dto.CustomerViewProductDetails.ColorVariantDetails;
import com.group1.dto.CustomerViewProductDetails.FeatureDetails;
import com.group1.dto.CustomerViewProductDetails.GeneralProductDetails;
import com.group1.dto.CustomerViewProductDetails.ProductVariantDetails;
import com.group1.dto.CustomerViewProductDetails.UnboxingDetails;
import com.group1.repositories.product.CategoryRepo;
import com.group1.repositories.product.ColorRepo;
import com.group1.repositories.product.ManufacturerRepo;
import com.group1.repositories.user.UserRepo;
import com.group1.service.product.ProductArticleService;
import com.group1.service.product.ProductCameraShotService;
import com.group1.service.product.ProductColorVariantService;
import com.group1.service.product.ProductDiscountService;
import com.group1.service.product.ProductFeatureService;
import com.group1.service.product.ProductService;
import com.group1.service.product.ProductSpecificationService;
import com.group1.service.product.ProductUnboxingService;
import com.group1.service.product.ProductVariantService;
import com.group1.service.product.CategoryService;
import com.group1.service.product.ManufacturerService;
import com.group1.service.product.ProductService;
import com.group1.service.product.ProductTechSpecsService;
import com.group1.service.shopping.PromoteCodeService;



@RestController
public class CustomerController {

  @Autowired
	UserRepo userRepo;

	@Autowired
	ColorRepo colorRepo;
	
	@Autowired
	ProductTechSpecsService specServ;
  
	@Autowired
	ProductService productServ;
	
	@Autowired
	ProductArticleService articleServ;
	
	@Autowired
	ProductCameraShotService cameraServ;
	
	@Autowired
	ProductColorVariantService colorVarServ;
	
	@Autowired
	ProductDiscountService discountServ;
	
	@Autowired
	ProductFeatureService featureServ;
	
	@Autowired
	ProductSpecificationService productSpecServ;
	
	@Autowired
	ProductUnboxingService unboxServ;
	
	@Autowired
	ProductVariantService productVarServ;
  
  @Autowired
	ManufacturerService manuServ;
	
	@Autowired
	CategoryRepo cateRepo;
	
	@Autowired
	CategoryService cateServ;

	@Autowired
	ManufacturerRepo manuRepo;
	
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
  
  @CrossOrigin(origins = "*")
	@GetMapping(value = "/view-products")
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
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/view-category")
	public List<Category> viewByCategory(ModelAndView model) {

		List<Category> categoryList = cateServ.getAllCategorys();
		return categoryList;

	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/view-manufacturer")
	public List<Manufacturer> viewByManufacturerByCategory(ModelAndView model,
			@RequestParam(required = true) Integer categoryId) {

		List<Manufacturer> manufacturerList = manuServ.getAllCateBrands(categoryId);
		return manufacturerList;
	
	@GetMapping("/view-details-product/{pID}")
	public GeneralProductDetails getViewProductDetails(@PathVariable("pID") String productID) 
	{
		GeneralProductDetails prod = productServ.getProductDetailsForCustomerView(productID);
		prod.imageToShow = Base64.getEncoder().encodeToString(prod.getImage());
		ArticleDetails article = articleServ.findViewArticle(productID);
		prod.article = article; 
		
		List<CameraShotsDetails> camShots = cameraServ.getCammerShotViews(productID);
		if(camShots.size() >0)
		{
			for(CameraShotsDetails item: camShots) 
			{
				System.out.println(item.toString());
				item.toShowImage = Base64.getEncoder().encodeToString(item.getImage());
			}
			prod.cameraShots = camShots;
		}
		else 
		{
			prod.cameraShots = null;
		}
			
		List<ColorVariantDetails> colorVarList = colorVarServ.getProductColorVariants(productID);
		if(colorVarList.size() >0)
		{
			for(ColorVariantDetails item: colorVarList) 
			{
				item.toShowImage = Base64.getEncoder().encodeToString(item.getImage());
			}
			prod.colorVariant = colorVarList;
		}
		else 
		{
			prod.colorVariant = null;
		}
		
		List<FeatureDetails> featureImgList = featureServ.getViewProductFeatures(productID);
		if(featureImgList.size() >0)
		{
			for(FeatureDetails item: featureImgList) 
			{
				item.toShowImage = Base64.getEncoder().encodeToString(item.getImage());
			}
			prod.features = featureImgList;
		}
		else 
		{
			prod.features = null;
		}
		
		List<UnboxingDetails> unboxImgList = unboxServ.getViewProductUnboxings(productID);
		if(unboxImgList.size() >0)
		{
			for(UnboxingDetails item: unboxImgList) 
			{
				item.toShowImage = Base64.getEncoder().encodeToString(item.getImage());
			}
			prod.unboxing = unboxImgList;
		}
		else 
		{ 
			prod.unboxing = null;
		}
		
		List<ProductVariantDetails> prodVariantList = new ArrayList<ProductVariantDetails>();
		ProductVariantDetails prodVariant = productVarServ.getVariantsOfProduct(productID);
		if(prodVariant != null) 
		{
			prodVariantList = productVarServ.getVariantsOfProductByOriginalID(prodVariant.getProductOriginalIdentifier());
			if(prodVariantList.size() >0) prod.original = prodVariantList;
			else prod.original = null;
		}
		else 
		{
			prodVariantList = productVarServ.getVariantsOfProductByOriginalID(productID);
			if(prodVariantList.size() >0) prod.original = prodVariantList;
			else prod.original = null;
		}
		
		String specString = productSpecServ.getProductSpecs(productID);
		List<SpecSection> specList = convertToSpecSection(specString);
		prod.specList = specList;
		
		return prod;

	}
}
