package com.group1.dto.CustomerViewProductDetails;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.group1.entities.product.Product;

public class ProductVariantDetails {

	private String productVariantID;
	
	private String productOriginalIdentifier;
	
	private String productVariantName;
	
	public ProductVariantDetails() {

	}

	public ProductVariantDetails(String productVariantID, String productOriginalIdentifier, String productVariantName) {
		super();
		this.productVariantID = productVariantID;
		this.productOriginalIdentifier = productOriginalIdentifier;
		this.productVariantName = productVariantName;
	}

	public String getProductVariantID() {
		return productVariantID;
	}

	public String getProductOriginalIdentifier() {
		return productOriginalIdentifier;
	}

	public String getProductVariantName() {
		return productVariantName;
	}

	@Override
	public String toString() {
		return "productVariantID=" + productVariantID + "\n       productOriginalIdentifier="
				+ productOriginalIdentifier + "\n       productVariantName=" + productVariantName;
	}

	
}
