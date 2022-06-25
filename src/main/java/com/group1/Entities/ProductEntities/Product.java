package com.group1.Entities.ProductEntities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//fixed
@Entity
@Table(name= "product")
public class Product implements Serializable{
	@Id 
	@Column(name = "ProductID")
	private String productID;
	
	@Column(name = "ProductName")
	private String productName;
	
	@Column(name = "Price")
	private Integer price;
	
	@ManyToOne
	@JoinColumn(name = "ManufacturerID", referencedColumnName = "ManufacturerID") 
	private Manufacturer manufacturerID;
	
	@ManyToOne
	@JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
	private Category categoryID;
	
	@OneToOne(mappedBy = "productIdentifier")
	private ProductDiscount discount;
	
	@OneToOne(mappedBy = "productArticleIdentifier")
	private ProductArticle article;
	
	@Column(name = "ProductWarranty")
	private Integer productWarranty;
	
	@Column(name = "Image")
	private String image;
	
	@Column(name = "InterestRate")
	private double interestRate;
	
	@Column(name = "Exclusive")
	private Boolean exclusive;
	
	@Column(name = "AccessoriesIncluded")
	private String accessoriesIncluded;
	
	@Column(name = "Enabled")
	private Boolean enabled;

	public Product() {
	}

	public Product(String productID, String productName, Integer price, Manufacturer manufacturerID,
			Category categoryID, ProductDiscount discount, ProductArticle article, Integer productWarranty,
			String image, double interestRate, Boolean exclusive, String accessoriesIncluded, Boolean enabled) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.manufacturerID = manufacturerID;
		this.categoryID = categoryID;
		this.discount = discount;
		this.article = article;
		this.productWarranty = productWarranty;
		this.image = image;
		this.interestRate = interestRate;
		this.exclusive = exclusive;
		this.accessoriesIncluded = accessoriesIncluded;
		this.enabled = enabled;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Manufacturer getManufacturerID() {
		return manufacturerID;
	}

	public void setManufacturerID(Manufacturer manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	public Category getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Category categoryID) {
		this.categoryID = categoryID;
	}

	public ProductDiscount getDiscount() {
		return discount;
	}

	public void setDiscount(ProductDiscount discount) {
		this.discount = discount;
	}

	public ProductArticle getArticle() {
		return article;
	}

	public void setArticle(ProductArticle article) {
		this.article = article;
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

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	
}
