package com.group1.Entities.productEntities;

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
public class ProductDiscount implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DiscountID")
	Integer discountID;

	@OneToOne
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
	Product productIdentifier;
	
	@Column(name = "ProductID")
	String productID;

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

	public ProductDiscount(Integer discountID, Product productIdentifier, String productID, Integer discountedPrice,
			Integer discountPercent, LocalDateTime startDate, LocalDateTime endDate) {
		super();
		this.discountID = discountID;
		this.productIdentifier = productIdentifier;
		this.productID = productID;
		this.discountedPrice = discountedPrice;
		this.discountPercent = discountPercent;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Integer getDiscountID() {
		return discountID;
	}

	public void setDiscountID(Integer discountID) {
		this.discountID = discountID;
	}

	public Product getProductIdentifier() {
		return productIdentifier;
	}

	public void setProductIdentifier(Product productIdentifier) {
		this.productIdentifier = productIdentifier;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
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

	@Override
	public String toString() {
		return "discountID=" + discountID + "\n       productID=" + productID + "\n       discountedPrice="
				+ discountedPrice + "\n       discountPercent=" + discountPercent + "\n       startDate=" + startDate
				+ "\n       endDate=" + endDate;
	}
	
}
