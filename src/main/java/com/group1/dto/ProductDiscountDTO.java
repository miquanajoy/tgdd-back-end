package com.group1.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProductDiscountDTO {

	String productID;
	String productName;
	int productPrice;
	String brandName;
	String categoryName;
	int discountedPrice;
	int discountPercent;
	LocalDateTime discountStart;
	LocalDateTime discountEnd;
	
	public ProductDiscountDTO() {
		
	}

	public ProductDiscountDTO(String productID, String productName, int productPrice, String brandName,
			String categoryName, int discountedPrice, int discountPercent, LocalDateTime discountStart,
			LocalDateTime discountEnd) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.brandName = brandName;
		this.categoryName = categoryName;
		this.discountedPrice = discountedPrice;
		this.discountPercent = discountPercent;
		this.discountStart = discountStart;
		this.discountEnd = discountEnd;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(int discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public LocalDateTime getDiscountStart() {
		
		return discountStart;
	}

	public void setDiscountStart(LocalDateTime discountStart) {
		this.discountStart =  discountStart;
	}

	public LocalDateTime getDiscountEnd() {
		
		
		return discountEnd;
	}

	public void setDiscountEnd(LocalDateTime discountEnd) {
		
		this.discountEnd = discountEnd;
	}

	@Override
	public String toString() {
		DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		
		String newDateTime = discountStart.format(datetimeformatter);
		discountStart = LocalDateTime.parse(newDateTime, datetimeformatter);
		 
		
		String newDateTime1 = discountEnd.format(datetimeformatter);
		discountEnd = LocalDateTime.parse(newDateTime1, datetimeformatter);
		
		return "ProductDiscountDTO:\n\tproductID=" + productID + " \n\tproductName=" + productName
				+ " \n\tproductPrice=" + productPrice + " \n\tbrandName=" + brandName + " \n\tcategoryName="
				+ categoryName + " \n\tdiscountedPrice=" + discountedPrice + " \n\tdiscountPercent=" + discountPercent
				+ " \n\tdiscountStart=" + discountStart.format(datetimeformatter) + " \n\tdiscountEnd=" + discountEnd.format(datetimeformatter);
	}

	
}
