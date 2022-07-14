package com.group1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group1.entities.product.Category;
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
	
	
	@GetMapping("/view-products/view-brand/choosen-category")
	public ModelAndView choosenCategory(ModelAndView model) {
		
		String chosenCategory = "";

		List<Category> categoryList = cateRepo.findAll();
		//Collections.sort(categoryList);
		model.setViewName("ProductView");
		model.addObject("CategoryList", categoryList);
		return model;
	}
	
	
	@GetMapping("/view-brand")
	public ModelAndView viewProducts(ModelAndView model) {
		
		model.setViewName("ProductViewByBrand");
		return model;
}
	
	@GetMapping("/view-brand/phone/iphone")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/điện thoại/SSGN1234/Image/4x6.jpg";
		List<Product> productList = productServ.showProductByPhone();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByPhoneBrand");
		return model;
	}
	
	@GetMapping("/view-brand/phone/samsung")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/điện thoại/SSGN1234/Image/4x6.jpg";
		List<Product> productList = productServ.showProductByPhone();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByPhoneBrand");
		return model;
	}
	
	@GetMapping("/view-brand/phone/oppo")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/điện thoại/SSGN1234/Image/4x6.jpg";
		List<Product> productList = productServ.showProductByPhone();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByPhoneBrand");
		return model;
	}
	
	@GetMapping("/view-brand/phone/xiaomi")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/điện thoại/SSGN1234/Image/4x6.jpg";
		List<Product> productList = productServ.showProductByPhone();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByPhoneBrand");
		return model;
	}
	
	@GetMapping("/view-brand/phone/vivo")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/điện thoại/SSGN1234/Image/4x6.jpg";
		List<Product> productList = productServ.showProductByPhone();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByPhoneBrand");
		return model;
	}
	
	@GetMapping("/view-brand/phone/realme")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/điện thoại/SSGN1234/Image/4x6.jpg";
		List<Product> productList = productServ.showProductByPhone();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByPhoneBrand");
		return model;
	}
	
	@GetMapping("/view-brand/phone/nokia")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/điện thoại/SSGN1234/Image/4x6.jpg";
		List<Product> productList = productServ.showProductByPhone();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByPhoneBrand");
		return model;
	}
	
	@GetMapping("/view-brand/laptop/macbook")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/laptop/...";
		List<Product> productList = productServ.showProductByLaptop();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByLaptopBrand");
		return model;
	}
	
	@GetMapping("/view-brand/laptop/asus")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/laptop/...";
		List<Product> productList = productServ.showProductByLaptop();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByLaptopBrand");
		return model;
	}
	
	@GetMapping("/view-brand/laptop/hp")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/laptop/...";
		List<Product> productList = productServ.showProductByLaptop();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByLaptopBrand");
		return model;
	}
	
	@GetMapping("/view-brand/laptop/lenovo")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/laptop/...";
		List<Product> productList = productServ.showProductByLaptop();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByLaptopBrand");
		return model;
	}
	
	@GetMapping("/view-brand/laptop/acer")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/laptop/...";
		List<Product> productList = productServ.showProductByLaptop();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByLaptopBrand");
		return model;
	}
	
	@GetMapping("/view-brand/laptop/dell")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/laptop/...";
		List<Product> productList = productServ.showProductByLaptop();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByLaptopBrand");
		return model;
	}
	
	@GetMapping("/view-brand/laptop/msi")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/laptop/...";
		List<Product> productList = productServ.showProductByLaptop();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByLaptopBrand");
		return model;
	}
	
	@GetMapping("/view-brand/tablet/ipad")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/tablet/...";
		List<Product> productList = productServ.showProductByTablet();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByTabletBrand");
		return model;
	}
	
	@GetMapping("/view-brand/tablet/samsung")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/tablet/...";
		List<Product> productList = productServ.showProductByTablet();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByTabletBrand");
		return model;
	}
	
	@GetMapping("/view-brand/tablet/xiaomi")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/tablet/...";
		List<Product> productList = productServ.showProductByTablet();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByTabletBrand");
		return model;
	}
	
	@GetMapping("/view-brand/tablet/lenovo")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/tablet/...";
		List<Product> productList = productServ.showProductByTablet();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByTabletBrand");
		return model;
	}
	
	@GetMapping("/view-brand/tablet/huawei")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/tablet/...";
		List<Product> productList = productServ.showProductByTablet();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByTabletBrand");
		return model;
	}
	
	@GetMapping("/view-brand/tablet/nokia")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/tablet/...";
		List<Product> productList = productServ.showProductByTablet();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewByTabletBrand");
		return model;
	}
	
	@GetMapping("/view-brand/smartwatch/apple")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/smartwatch/...";
		List<Product> productList = productServ.showProductBySmartWatch();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewBySmartWatchBrand");
		return model;
	}
	
	@GetMapping("/view-brand/smartwatch/samsung")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/smartwatch/...";
		List<Product> productList = productServ.showProductBySmartWatch();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewBySmartWatchBrand");
		return model;
	}
	
	@GetMapping("/view-brand/smartwatch/garmin")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/smartwatch/...";
		List<Product> productList = productServ.showProductBySmartWatch();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewBySmartWatchBrand");
		return model;
	}
	
	@GetMapping("/view-brand/smartwatch/xiaomi")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/smartwatch/...";
		List<Product> productList = productServ.showProductBySmartWatch();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewBySmartWatchBrand");
		return model;
	}
	
	@GetMapping("/view-brand/smartwatch/oppo")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/smartwatch/...";
		List<Product> productList = productServ.showProductBySmartWatch();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewBySmartWatchBrand");
		return model;
	}
	
	@GetMapping("/view-brand/smartwatch/amazfit")
	public ModelAndView viewProductsCatePhone(ModelAndView model) {
		String path ="/image/product/smartwatch/...";
		List<Product> productList = productServ.showProductBySmartWatch();
		
		for(Product pro: productList) 
		{	
			String encoder64 = Base64.getEncoder().encodeToString(pro.getImage());
			pro.setImageToShow(encoder64);
		}
		
		model.addObject("ProductList", productList);
		model.addObject("ImgPath", path);
		
		model.setViewName("ProductViewBySmartWatchBrand");
		return model;
	}
	
}
