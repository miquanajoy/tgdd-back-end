package com.group1.entities.product;

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
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@Column(name = "Enabled")
	boolean enabled;
	
	@Transient
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime endDateInput;
	
	@Transient
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime startDateInput;

	public ProductDiscount() {

	}

	public ProductDiscount(Integer discountID, Product productIdentifier, String productID, Integer discountedPrice,
			Integer discountPercent, LocalDateTime startDate, LocalDateTime endDate, boolean enabled, LocalDateTime endDateInput, 
			LocalDateTime startDateInput) {
		super();
		this.discountID = discountID;
		this.productIdentifier = productIdentifier;
		this.productID = productID;
		this.discountedPrice = discountedPrice;
		this.discountPercent = discountPercent;
		this.startDate = startDate;
		this.endDate = endDate;
		this.enabled = enabled;
		this.endDateInput = endDateInput;
		this.startDateInput = startDateInput;
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
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getEndDateInput() {
		return endDateInput;
	}

	public void setEndDateInput(LocalDateTime endDateInput) {
		this.endDateInput = endDateInput;
	}
	
	public LocalDateTime getStartDateInput() {
		return startDateInput;
	}

	public void setStartDateInput(LocalDateTime startDateInput) {
		this.startDateInput = startDateInput;
	}

	@Override
	public String toString() {
		return "discountID=" + discountID + "\n       productID=" + productID + "\n       discountedPrice="
				+ discountedPrice + "\n       discountPercent=" + discountPercent + "\n       startDate=" + startDate
				+ "\n       endDate=" + endDate + "\n       enabled=" + enabled + "\n       endDateInput="
				+ endDateInput + "\n       startDateInput=" + startDateInput;
	}
	
}
