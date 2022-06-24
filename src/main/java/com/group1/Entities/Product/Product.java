package com.group1.Entities.Product;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Product implements Serializable{
	@Id 
	private String ProductID;
	private String ProductName;
	private int Price;
	@ManyToOne
	@JoinColumn(name = "ManufacturerID")
	private Manufacturer ManufacturerID;
	@ManyToOne
	@JoinColumn(name = "CategoryID")
	private Category CategoryID;
	@OneToOne(mappedBy = "ProductIdentifier")
	private ProductDiscount discount;
	private int ProductWarranty;
	private String Image;
	private double InterestRate;
	private Boolean Exclusive;
	private String AccessoriesIncluded;
	private Boolean Enabled;

	public Product() {
	}

	public Product(String productID, String productName, int price, Manufacturer manufacturerID, Category categoryID,
			int productWarranty, String image, double interestRate, Boolean exclusive, String accessoriesIncluded,
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

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
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

	public int getProductWarranty() {
		return ProductWarranty;
	}

	public void setProductWarranty(int productWarranty) {
		ProductWarranty = productWarranty;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public double getInterestRate() {
		return InterestRate;
	}

	public void setInterestRate(double interestRate) {
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

	

}
