package com.group1.entities;

import javax.persistence.Entity;

@Entity
public class ProductVariant {
	private Integer id;
	private Product productVariantId;
	private Product originalProductId;
	private String productVariantName;

	public ProductVariant() {
	}

	public ProductVariant(Integer id, Product productVariantId, Product originalProductId, String productVariantName) {
		this.id = id;
		this.productVariantId = productVariantId;
		this.originalProductId = originalProductId;
		this.productVariantName = productVariantName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProductVariantId() {
		return productVariantId;
	}

	public void setProductVariantId(Product productVariantId) {
		this.productVariantId = productVariantId;
	}

	public Product getOriginalProductId() {
		return originalProductId;
	}

	public void setOriginalProductId(Product originalProductId) {
		this.originalProductId = originalProductId;
	}

	public String getProductVariantName() {
		return productVariantName;
	}

	public void setProductVariantName(String productVariantName) {
		this.productVariantName = productVariantName;
	}

	
}
