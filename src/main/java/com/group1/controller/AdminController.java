package com.group1.controller;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group1.dto.Attributes;
import com.group1.dto.GeneralProductViewDTO;
import com.group1.dto.MultiFieldsFilePathDTO;
import com.group1.dto.ProductDiscountDTO;
import com.group1.dto.SpecSection;
import com.group1.dto.ColorVariantUpdateDTO;
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
import com.group1.entities.user.User;
import com.group1.repositories.product.CategoryRepo;
import com.group1.repositories.product.ColorRepo;
import com.group1.repositories.product.ManufacturerRepo;
import com.group1.repositories.product.ProductRepo;
import com.group1.repositories.shopping.PromoteCodeRepo;
import com.group1.repositories.user.UserRepo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.group1.service.product.CategoryService;
import com.group1.service.product.ManufacturerService;
import com.group1.service.product.ProductService;
import com.group1.service.product.ProductTechSpecsService;
import com.group1.service.shopping.PromoteCodeService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ProductService productServ;
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	UserRepo userRepo;
	
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
	
	//List<CategoryBasedSpecification> specFormList =new ArrayList<CategoryBasedSpecification>();
	
	public List<SpecSection> loadCateBasedSpecificationForm(List<ProductTechSpecs> specList) 
	{
		List<String> txtFile = new ArrayList<String>();
		
		List<SpecSection> sectionList =new ArrayList<SpecSection>();
		List<Attributes> attrList =new ArrayList<Attributes>();
		//CategoryBasedSpecification specForm = new CategoryBasedSpecification();
		SpecSection section =new SpecSection();

		for(ProductTechSpecs spec: specList) 
		{
			if(sectionList.size() == 0) 
			{
				section.setSectionHeader(spec.getSection());
				section.setAttributes(attrList);
				Attributes attr = new Attributes();
				attr.setKey(spec.getSpecName());
				attr.setValue("Split multiple values with ;");
				section.getAttributes().add(attr);
				sectionList.add(section);
				continue;
				
			}

			if(sectionList.get(sectionList.size()-1).getSectionHeader().equals(spec.getSection()) ) 
			{
				Attributes attr = new Attributes();
				attr.setKey(spec.getSpecName());
				attr.setValue("Split multiple values with ;");
				sectionList.get(sectionList.size()-1).getAttributes().add(attr);
			} 
			else
			{
				section = new SpecSection();
				section.setSectionHeader(spec.getSection());
				attrList = new ArrayList<Attributes>();
				
				Attributes attr = new Attributes();
				attr.setKey(spec.getSpecName());
				attr.setValue("Split multiple values with ;");
				attrList.add(attr);
				section.setAttributes(attrList);
				sectionList.add(section);
			}
			
			
		}
		
		return sectionList;
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
	  public ModelAndView checkLogin(@ModelAttribute("LoginPage") User user, HttpSession session) {
	  
		  ModelAndView model =new ModelAndView();
		  User userdata = UserRepo.findByUserNameAndPassWord(user.getUserName(),user.getPassword()); 
			  if (userdata != null) 
			  {   
				  Long createdTime= session.getCreationTime();
				  System.out.println("Session created at:" + createdTime);
				  session.setMaxInactiveInterval(60*30);
				  int sessionage= session.getMaxInactiveInterval();
				  System.out.println("Session will self-destroy in:" + sessionage);
				  
				  if (userdata.getRoleId().equals("US")) 
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
	
	@GetMapping("/products-management/create-product/choose-category")
	public ModelAndView chooseProductCategory(ModelAndView model) 
	{
		String chosenCategory = "";

		List<Category> categoryList = cateRepo.findAll();
		//Collections.sort(categoryList);
		model.setViewName("ProductCreate");
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
	public ModelAndView AddProductStep1(ModelAndView model, @ModelAttribute("Categorychosen") String catechosen
			, @ModelAttribute("ColorVariantNumber") int colorVarNum) 
	{
		//if(!catechosen.isEmpty()) System.out.println("Category is:"+catechosen);
		//else System.out.println("Category is empty");
		Product productInputForm = new Product();
		String Exclusive = "";
		String Enabled = "";
		int categoryID = 0;
		List<Category> categoryList = cateRepo.findAll();
		List<Manufacturer> manuList = manuRepo.findAll();
		List<Color> colorList = colorRepo.findAll();
		//List<ProductTechSpecs> specList = new ArrayList<ProductTechSpecs>();
		MultiFieldsFilePathDTO multi = new MultiFieldsFilePathDTO();
		List<ProductColorVariant> colorInputFormList = new ArrayList<ProductColorVariant>();
		for(Category cate: categoryList) 
		{
			if(cate.getCategoryName().equals(catechosen) ) 
			{
				categoryID = cate.getCategoryID();
			}
		}
		productInputForm.setCategoryID(categoryID);
		/*specList = specServ.findAllSpecsByCateID(categoryID);
		List<SpecSection> newSpecList = loadCateBasedSpecificationForm(specList);
		for(SpecSection spec : newSpecList) 
		{
			System.out.println(spec.toString());
		}
		ProductSpecification specification = new ProductSpecification();
		productInputForm.setSpecifications(specification);
		productInputForm.setSpecList(newSpecList);*/
		ProductArticle article = new ProductArticle();
		productInputForm.setArticle(article);
		
		if(colorVarNum >0) {
		productInputForm.setColorVariantInputList(colorInputFormList);
		
			for(int i = 0; i < colorVarNum;i++) {
				ProductColorVariant colorvar = new ProductColorVariant();
				productInputForm.getColorVariantInputList().add(colorvar);
			}
		
		}
		
		ProductVariant variant = new ProductVariant();
		productInputForm.setVariant(variant);
		
		model.addObject("ProductInputForm", productInputForm);
		model.setViewName("ProductCreate");
		model.addObject("CateChosen", catechosen);
		model.addObject("CheckExclusive", Exclusive);
		model.addObject("CheckEnabled", Enabled);
		//model.addObject("SpecInputForm", specInputForm);
		model.addObject("ManuList", manuList);
		model.addObject("ColorList", colorList);
		model.addObject("MultipartField", multi);
		return model;
	}
	
	@PostMapping("/products-management/create-product")
	public ModelAndView AddProductProcess(ModelAndView model, @ModelAttribute("ProductInputForm") Product productForm,
			@ModelAttribute("CheckExclusive") String exclusive, @ModelAttribute("CheckEnabled") String enabled, 
			@ModelAttribute("DiscountEnabled") String discountSetter, 
			@ModelAttribute("MutlipartField") MultiFieldsFilePathDTO filepath) 
	{

		if(exclusive.contains("Exclusive")) productForm.setExclusive(true);
		if(exclusive.contains("NotExclusive")) productForm.setExclusive(false);
		
		if(enabled.contains("Enable")) productForm.setEnabled(true);
		if(enabled.contains("Disable")) productForm.setEnabled(false);

		if(discountSetter.contains("Enable")) productForm.getDiscount().setEnabled(true);
		if(discountSetter.contains("Disable"))  productForm.getDiscount().setEnabled(false);
		
		System.out.println("Processing create product "+productForm.toString());
		
		int count = 0;
			System.out.println("MultipartFile has "+ filepath.getImageFile().length);
			for(MultipartFile filePart: filepath.getImageFile()) 
			{
					count +=1;
					String contentType = filePart.getContentType();
					System.out.println("Type of multipartFile file no. "+ count + " :"+ contentType);
					productForm.setImageType(contentType);
					String fileName = filePart.getOriginalFilename();
					System.out.println("Name of multipartFile file no. "+ count + " :"+ fileName);
					try {
						productForm.setImage(filePart.getBytes());
					} catch (IOException e) {
					e.printStackTrace();
					}
			}
		
		String pID = productForm.getProductID();
		//productForm.setCategoryID(cateID);
		
		if(productForm.getArticle().getArticleUrl().isEmpty()) 
		{
			System.out.println("Article is null");
			productForm.setArticle(null);
		} 
		else productForm.getArticle().setProductID(pID);
				
		int count1= 0;
		if(filepath.getCameraShotsFile()[0].getOriginalFilename().isEmpty()) 
		{
			System.out.println("Camera shots is null");
			productForm.setCameraShots(null);
		} 
		
		if(filepath.getCameraShotsFile().length >0 && !filepath.getCameraShotsFile()[0].getOriginalFilename().isEmpty())
		{
			Set<ProductCameraShot> camSet = new HashSet<ProductCameraShot>();
			productForm.setCameraShots(camSet);
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				camShot.setImageType(contentType);
				camShot.setProductID(pID);
				productForm.getCameraShots().add(camShot);
			}
			
		}
		
		int countEl = 0;
		int countColor = 0;
		Set<ProductColorVariant> colorSet = new  HashSet<ProductColorVariant>();
		productForm.setColorVariant(colorSet);
		for(Iterator<ProductColorVariant> t = productForm.getColorVariantInputList().iterator(); t.hasNext();) 
		{
			ProductColorVariant el = t.next();
			countEl +=1;
			if(el.getFileDatas()[0].getOriginalFilename().isEmpty()) 
			{
				t.remove();
			}
			else 
			{
				System.out.println("MultipartFile of color no. "+ countEl+" has "+ el.getFileDatas().length);
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					toSaveEl.setImageType(contentType);
					toSaveEl.setProductID(pID);
					toSaveEl.setColorID(el.getColorID());
					toSaveEl.setProductID(pID);
					productForm.getColorVariant().add(toSaveEl);
				}
			}
		}
		if(productForm.getColorVariant().size() ==0) productForm.setColorVariant(null);
	
		if(productForm.getDiscount().getDiscountedPrice() == null || productForm.getDiscount().getDiscountPercent() == null
				 || productForm.getDiscount().getEndDateInput() == null) productForm.setDiscount(null);
		else 
		{
			LocalDateTime currTime = LocalDateTime.now();
			
			productForm.getDiscount().setProductID(pID);
			LocalDateTime startConvert = converttoLocalDateTime(currTime);
			LocalDateTime endConvert = converttoLocalDateTime(productForm.getDiscount().getEndDateInput());
			productForm.getDiscount().setEndDate(endConvert);
			productForm.getDiscount().setStartDate(startConvert);
		}
		
		int count2 = 0;
		if(filepath.getFeatureFile()[0].getOriginalFilename().isEmpty() ) {
			System.out.println("Feature is null");
			productForm.setFeatures(null);
		}
		else 
		{
			Set<ProductFeature> featureSet = new HashSet<ProductFeature>();
			productForm.setFeatures(featureSet);
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				featureEl.setProductID(pID);
				featureEl.setImageType(contentType);
				productForm.getFeatures().add(featureEl);
				
			}
		}
			/*int emptyCount = 0;
			boolean breakLoop= false;
			for(SpecSection spec : productForm.getSpecList()) 
			{
				for(Iterator<Attributes> attr = spec.getAttributes().iterator(); attr.hasNext();) 
				{
					Attributes att = attr.next();
					if(att.getValue().toString().contains("Split multiple values with ;")) 
					{
						if(emptyCount == 5) 
						{
							breakLoop = true;
							break;
						}
						attr.remove();
						emptyCount+=1;
						continue;
					}
					if(att.getValue().toString().contains(";")) 
					{
						String[] splitArr = att.getValue().toString().split(";");
						att.setValue(splitArr);
					}
					if(breakLoop) break;
				}
			}
			
			if(emptyCount >=5) productForm.setSpecifications(null);
			else
			{
			String json = "";
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			try {
				json = mapper.writeValueAsString(productForm.getSpecList());
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			productForm.getSpecifications().setProductSpecifications(json);
			}*/
		
		
		int count3 = 0;
		if(filepath.getUnboxingFile()[0].getOriginalFilename().isEmpty()) 
		{
			System.out.println("Unboxing is null");
			productForm.setUnboxing(null);
		}
		else 
		{
			Set<ProductUnboxingReview> unboxing = new HashSet<ProductUnboxingReview>();
			productForm.setUnboxing(unboxing);
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				unboxReview.setProductID(pID);
				unboxReview.setImageType(contentType);
				productForm.getUnboxing().add(unboxReview);
			}
			
		}
		
		if(productForm.getVariant().getProductOriginalIdentifier().isEmpty()) 
		{
			System.out.println("Variant is null");
			productForm.setVariant(null);
		}
		else productForm.getVariant().setProductVariantID(pID);
		
		System.out.println("At final create product step"+productForm.toString());
		//productRepo.save(productForm);
		//model.addObject("ProductInputForm1", productForm);
		model.setViewName("redirect:/admin/products-management/view-products");
		//model.setViewName("Result");
		//model.addObject("SpecInputForm1", specform);
		//model.addObject("ColorList", colorList);
		//model.addObject("CategoryList", categoryList);
		return model;
	}
	
	@GetMapping("/products-management/view-products")
	public ModelAndView viewProducts(ModelAndView model) {
		
		String path ="/image/product/điện thoại/SSGN1234/Image/4x6.jpg";
		List<Product> productList = productServ.showAllProducts();
		for(Product pro: productList) 
		{
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
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
	
	@GetMapping("/products-management/view-or-update-product/step-1/{proID}")
	public ModelAndView viewOrUpdateProductsStep1(ModelAndView model, @PathVariable("proID") String productIdentifier) {
	
		model.addObject("pID", productIdentifier);
		model.setViewName("ProductDetailsOrUpdate");
		return model;
	}
	
	@GetMapping("/products-management/view-or-update-product/step-2/{proID}")
	public ModelAndView viewOrUpdateProducts(ModelAndView model, @PathVariable("proID") String productIdentity, 
			@ModelAttribute("AdditionalColorVarNum") int additionalColor) {
		
		Product p = productRepo.findByProductID(productIdentity);
		MultiFieldsFilePathDTO multi = new MultiFieldsFilePathDTO();
		List<ProductColorVariant> colorInputFormList = new ArrayList<ProductColorVariant>();
		List<Manufacturer> manuList = manuRepo.findAll();
		List<Color> colorList = colorRepo.findAll();
		List<ColorVariantUpdateDTO> colorVarUpdateList = new ArrayList<ColorVariantUpdateDTO>();
		System.out.println("Before update:"+p.toString());
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
			for(Iterator<ProductColorVariant> t = p.getColorVariant().iterator(); t.hasNext();) 
			{ 
				ProductColorVariant el = t.next();
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
			}
			p.setColorVarUpdateList(colorVarUpdateList);
		}
		
		if(p.getDiscount() == null) 
		{
			ProductDiscount discountObj = new ProductDiscount();
			p.setDiscount(discountObj);
		}
		else 
		{
			p.getDiscount().setEndDateInput(p.getDiscount().getEndDate());
		}
		
		if(additionalColor >0) {
			p.setColorVariantInputList(colorInputFormList);
			
				for(int i = 0; i < additionalColor;i++) {
					ProductColorVariant colorvar = new ProductColorVariant();
					p.getColorVariantInputList().add(colorvar);
				}
			
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
		
		if(p.getSpecifications() == null) 
		{
			List<ProductTechSpecs> specList = specServ.findAllSpecsByCateID(p.getCategoryID());
			List<SpecSection> formattedSpecList = loadCateBasedSpecificationForm(specList);
			ProductSpecification specObj = new ProductSpecification();
			p.setSpecifications(specObj);
			p.setSpecList(formattedSpecList);
			p.setSpecifications(specObj);
		}
		model.addObject("ProductUpdateForm", p);
		model.addObject("MultiField", multi);
		model.addObject("ManuList", manuList);
		model.addObject("ColorList", colorList);
		model.setViewName("ProductDetailsOrUpdate");
		return model;
	}
	
	@PostMapping("/products-management/update-product")
	public ModelAndView UpdateProduct(ModelAndView model, @ModelAttribute("ProductUpdateForm") Product toUpdateForm,
			@ModelAttribute("CheckExclusive") String exclusiveSetter, @ModelAttribute("CheckEnable") String enableSetter, 
			@ModelAttribute("MultiField") MultiFieldsFilePathDTO filepath, 
			@ModelAttribute("CheckDiscountEnable") String discountSetter) {
		
		//System.out.println(p.toString());
		if(exclusiveSetter.contains("Exclusive")) toUpdateForm.setExclusive(true);
		if(exclusiveSetter.contains("NotExclusive")) toUpdateForm.setExclusive(false);
		
		if(enableSetter.contains("Enable")) toUpdateForm.setEnabled(true);
		if(enableSetter.contains("Disable")) toUpdateForm.setEnabled(false);
		
		Product compareProduct = productRepo.findByProductID(toUpdateForm.getProductID());
		
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
		
		if(toUpdateForm.getArticle().getArticleUrl().isEmpty()) 
		{
			System.out.println("Article is null");
			toUpdateForm.setArticle(null);
		} 
		else toUpdateForm.getArticle().setProductID(pID);
		
		int count1= 0;
		if(filepath.getCameraShotsFile()[0].getOriginalFilename().isEmpty() && compareProduct.getCameraShots() == null) 
		{
			System.out.println("Camera shots is null");
			toUpdateForm.setCameraShots(null);
		} 
		
		if(filepath.getCameraShotsFile() !=null)
		{
			if(compareProduct.getCameraShots() == null) {
				Set<ProductCameraShot> cameraSet = new  HashSet<ProductCameraShot>();
				toUpdateForm.setCameraShots(cameraSet);
			}
			else toUpdateForm.setCameraShots(compareProduct.getCameraShots());
			
			System.out.println("MultipartFile for cameraShot has "+ filepath.getCameraShotsFile().length);
			for(MultipartFile cameraFile: filepath.getCameraShotsFile()) 
			{
				if(!cameraFile.getOriginalFilename().isEmpty()) {
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
				
				System.out.println("Update MultipartFile of color ID. "+ update.getForColorID()
				+" has "+ update.getUpdateFileDatas().length);
				if(update.getUpdateFileDatas() != null) 
				{
					for(MultipartFile updateFile: update.getUpdateFileDatas()) 
					{
						if(!updateFile.getOriginalFilename().isEmpty()) {
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
						if(!file.getOriginalFilename().isEmpty())
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
			}
			if(toUpdateForm.getColorVariant().size() ==0) toUpdateForm.setColorVariant(null);
		}
		
		if(toUpdateForm.getDiscount().getDiscountedPrice() == null || toUpdateForm.getDiscount().getDiscountPercent() == null
				 || toUpdateForm.getDiscount().getEndDateInput() == null 
				 || discountSetter.isEmpty() || discountSetter == null) toUpdateForm.setDiscount(null);
		else 
		{
			if(compareProduct.getDiscount() == null) {
				LocalDateTime currTime = LocalDateTime.now();
				toUpdateForm.getDiscount().setProductID(pID);
				LocalDateTime startConvert = converttoLocalDateTime(currTime);
				toUpdateForm.getDiscount().setStartDate(startConvert);
			}
			LocalDateTime endConvert = converttoLocalDateTime(toUpdateForm.getDiscount().getEndDateInput());
			toUpdateForm.getDiscount().setEndDate(endConvert);
			
			if(discountSetter.contains("Enable")) toUpdateForm.getDiscount().setEnabled(true);
			if(discountSetter.contains("Disable"))  toUpdateForm.getDiscount().setEnabled(false);
			
		}
		
		if(filepath.getFeatureFile()[0].getOriginalFilename().isEmpty() && compareProduct.getFeatures() == null) {
			System.out.println("Feature is null");
			toUpdateForm.setFeatures(null);
		}
		
		if(filepath.getFeatureFile( ) != null)
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
				if(!featureFile.getOriginalFilename().isEmpty()) 
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
		}
		
		int count3 = 0;
		if(filepath.getUnboxingFile()[0].getOriginalFilename().isEmpty() && compareProduct.getUnboxing() == null) 
		{
			System.out.println("Unboxing is null");
			toUpdateForm.setUnboxing(null);
		}
		
		if(filepath.getUnboxingFile() != null )
		{
			if(compareProduct.getUnboxing() == null) {
				Set<ProductUnboxingReview> unboxSet = new  HashSet<ProductUnboxingReview>();
				toUpdateForm.setUnboxing(unboxSet);
			}
			else toUpdateForm.setUnboxing(compareProduct.getUnboxing());
			
			System.out.println("MultipartFile for unboxing has "+ filepath.getUnboxingFile().length);
			for(MultipartFile unboxFile: filepath.getUnboxingFile()) 
			{
				if(!unboxFile.getOriginalFilename().isEmpty())
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
			
		}
		
		if(toUpdateForm.getVariant().getProductOriginalIdentifier().isEmpty()
		  || toUpdateForm.getVariant().getProductVariantName().isEmpty()) 
		{
			System.out.println("Variant is null");
			toUpdateForm.setVariant(null);
		}
		else toUpdateForm.getVariant().setProductVariantID(pID);
		
		//form.setPromoteCodeID(1);
		
		/*
	
		//productForm.setCategoryID(cateID);
				
		*/
		
		System.out.println("product after update is:"+toUpdateForm);
		
		//productList.set(foundForm, toUpdateForm);
		//toUpdateform.setPromoteCodeID(promoteID);
		productRepo.save(toUpdateForm);
		//model.addObject("PromoteForm", form);
		model.setViewName("redirect:/admin/products-management/view-products");
		//model.setViewName("Result");
		//model.addObject("ProductList", productList);
		return model;
	}
	
	@GetMapping("/promotions-management/create-promotion")
	public ModelAndView addNewPromotion(ModelAndView model) {
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
