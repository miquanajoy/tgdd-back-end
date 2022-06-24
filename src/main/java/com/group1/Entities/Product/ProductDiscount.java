package com.group1.Entities.Product;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_discount")
public class ProductDiscount implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int DiscountID;
	@OneToOne
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
	Product ProductIdentifier;
	int DiscountedPrice;
	int DiscountPercent;
	LocalDateTime StartDate;
	LocalDateTime EndDate;
	
	public ProductDiscount() {
		
	}

	public ProductDiscount(int discountID, Product productIdentifier, int discountPrice, int discountedPercent,
			LocalDateTime startDate, LocalDateTime endDate) {
		super();
		DiscountID = discountID;
		ProductIdentifier = productIdentifier;
		DiscountedPrice = discountPrice;
		DiscountPercent = discountedPercent;
		StartDate = startDate;
		EndDate = endDate;
	}

	public int getDiscountID() {
		return DiscountID;
	}

	public void setDiscountID(int discountID) {
		DiscountID = discountID;
	}

	public Product getProductIdentifier() {
		return ProductIdentifier;
	}

	public void setProductIdentifier(Product productIdentifier) {
		ProductIdentifier = productIdentifier;
	}

	public int getDiscountedPrice() {
		return DiscountedPrice;
	}

	public void setDiscountedPrice(int discountedPrice) {
		DiscountedPrice = discountedPrice;
	}

	public int getDiscountPercent() {
		return DiscountPercent;
	}

	public void setDiscountedPercent(int discountPercent) {
		DiscountPercent = discountPercent;
	}

	public LocalDateTime getStartDate() {
		return StartDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		StartDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return EndDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		EndDate = endDate;
	}

	@Override
	public String toString() {
		return "ProductDiscount:\n\tDiscountID=" + DiscountID + " \n\tProductIdentifier=" + ProductIdentifier
				+ " \n\tDiscountedPrice=" + DiscountedPrice + " \n\tDiscountPercent=" + DiscountPercent
				+ " \n\tStartDate=" + StartDate + " \n\tEndDate=" + EndDate;
	}

	
}
