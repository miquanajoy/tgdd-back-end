package com.group1.Entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product implements Serializable{
	@Id 
	private String ProductID;
	private String ProductName;
	private BigDecimal Price;
	@ManyToOne
	@JoinColumn(name = "ManufacturerID")
	private Manufacturer ManufacturerID;
	@ManyToOne
	@JoinColumn(name = "CategoryID")
	private Category CategoryID;
	private Integer ProductWarranty;
	private String Image;
	private BigDecimal InterestRate;
	private Boolean Exclusive;
	private String AccessoriesIncluded;
	private Boolean Enabled;

	public Product() {
	}

	public Product(String productID, String productName, BigDecimal price, Manufacturer manufacturerID, Category categoryID,
			Integer productWarranty, String image, BigDecimal interestRate, Boolean exclusive, String accessoriesIncluded,
			Boolean enabled) {
		super();
		ProductID = productID;
		ProductName = productName;
		Price = price;
		ManufacturerID = manufacturerID;
		CategoryID = categoryID;
		ProductWarranty = productWarranty;
		Image = image;
		InterestRate = interestRate;
		Exclusive = exclusive;
		AccessoriesIncluded = accessoriesIncluded;
		Enabled = enabled;
	}

	public String getProductID() {
		return ProductID;
	}

	public void setProductID(String productID) {
		ProductID = productID;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public BigDecimal getPrice() {
		return Price;
	}

	public void setPrice(BigDecimal price) {
		Price = price;
	}

	public Manufacturer getManufacturerID() {
		return ManufacturerID;
	}

	public void setManufacturerID(Manufacturer manufacturerID) {
		ManufacturerID = manufacturerID;
	}

	public Category getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(Category categoryID) {
		CategoryID = categoryID;
	}

	public Integer getProductWarranty() {
		return ProductWarranty;
	}

	public void setProductWarranty(Integer productWarranty) {
		ProductWarranty = productWarranty;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public BigDecimal getInterestRate() {
		return InterestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		InterestRate = interestRate;
	}

	public Boolean getExclusive() {
		return Exclusive;
	}

	public void setExclusive(Boolean exclusive) {
		Exclusive = exclusive;
	}

	public String getAccessoriesIncluded() {
		return AccessoriesIncluded;
	}

	public void setAccessoriesIncluded(String accessoriesIncluded) {
		AccessoriesIncluded = accessoriesIncluded;
	}

	public Boolean getEnabled() {
		return Enabled;
	}

	public void setEnabled(Boolean enabled) {
		Enabled = enabled;
	}

	@Override
	public String toString() {
		return "Product:\n\tProductID=" + ProductID + " \n\tProductName=" + ProductName + " \n\tPrice=" + Price
				+ " \n\tManufacturerID=" + ManufacturerID + " \n\tCategoryID=" + CategoryID + " \n\tProductWarranty="
				+ ProductWarranty + " \n\tImage=" + Image + " \n\tInterestRate=" + InterestRate + " \n\tExclusive="
				+ Exclusive + " \n\tAccessoriesIncluded=" + AccessoriesIncluded + " \n\tEnabled=" + Enabled;
	}

	

}
