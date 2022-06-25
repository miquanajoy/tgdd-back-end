package com.group1.Entities.ProductEntities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_variant")
public class ProductVariant implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	private Product ProductVariantID;
	private Product OriginalProductID;
	private String ProductVariantName;

	public ProductVariant() {
	}

	public ProductVariant(Integer iD, Product productVariantID, Product originalProductID, String productVariantName) {
		super();
		ID = iD;
		ProductVariantID = productVariantID;
		OriginalProductID = originalProductID;
		ProductVariantName = productVariantName;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Product getProductVariantID() {
		return ProductVariantID;
	}

	public void setProductVariantID(Product productVariantID) {
		ProductVariantID = productVariantID;
	}

	public Product getOriginalProductID() {
		return OriginalProductID;
	}

	public void setOriginalProductID(Product originalProductID) {
		OriginalProductID = originalProductID;
	}

	public String getProductVariantName() {
		return ProductVariantName;
	}

	public void setProductVariantName(String productVariantName) {
		ProductVariantName = productVariantName;
	}

	
}
