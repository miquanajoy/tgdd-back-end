package com.group1.Entities.ProductEntities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//fixed
@Entity
@Table(name = "product_discount")
public class ProductDiscount implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "discountID")
	int DiscountID;
	
	@OneToOne
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
	Product productIdentifier;
	
	@Column(name = "DiscountedPrice")
	Integer discountedPrice;
	
	@Column(name = "DiscountPercent")
	Integer discountPercent;
	
	@Column(name = "StartDate")
	LocalDateTime startDate;
	
	@Column(name = "EndDate")
	LocalDateTime endDate;
	
	public ProductDiscount() {
		
	}

	public ProductDiscount(int discountID, Product productIdentifier, Integer discountedPrice, Integer discountPercent,
			LocalDateTime startDate, LocalDateTime endDate) {
		super();
		DiscountID = discountID;
		this.productIdentifier = productIdentifier;
		this.discountedPrice = discountedPrice;
		this.discountPercent = discountPercent;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getDiscountID() {
		return DiscountID;
	}

	public void setDiscountID(int discountID) {
		DiscountID = discountID;
	}

	public Product getProductIdentifier() {
		return productIdentifier;
	}

	public void setProductIdentifier(Product productIdentifier) {
		this.productIdentifier = productIdentifier;
	}

	public Integer getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Integer discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public Integer getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	
}
