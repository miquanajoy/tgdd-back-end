package com.group1.entities;

import javax.persistence.Entity;

@Entity
public class Product {
	private String productId;
	private String productName;
	private Double price;
	private Manufacturer manufacturerId;
	private Category categoryId;
	private Integer productWarranty;
	private String image;
	private Double interestRate;
	private Boolean exclusive;
	private String accessoriesIncluded;
	private Boolean enable;

	public Product() {
	}

	public Product(String productId, String productName, Double price, Manufacturer manufacturerId, Category categoryId,
			Integer productWarranty, String image, Double interestRate, Boolean exclusive, String accessoriesIncluded,
			Boolean enable) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.manufacturerId = manufacturerId;
		this.categoryId = categoryId;
		this.productWarranty = productWarranty;
		this.image = image;
		this.interestRate = interestRate;
		this.exclusive = exclusive;
		this.accessoriesIncluded = accessoriesIncluded;
		this.enable = enable;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Manufacturer getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Manufacturer manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getProductWarranty() {
		return productWarranty;
	}

	public void setProductWarranty(Integer productWarranty) {
		this.productWarranty = productWarranty;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Boolean getExclusive() {
		return exclusive;
	}

	public void setExclusive(Boolean exclusive) {
		this.exclusive = exclusive;
	}

	public String getAccessoriesIncluded() {
		return accessoriesIncluded;
	}

	public void setAccessoriesIncluded(String accessoriesIncluded) {
		this.accessoriesIncluded = accessoriesIncluded;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

}
