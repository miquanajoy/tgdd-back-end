package com.group1.entities;

import javax.persistence.Entity;

@Entity
public class ProductSpecification {
	private Integer id;
	private Product productId;
	private String productSpecification;

	public ProductSpecification() {
	}

	public ProductSpecification(Integer id, Product productId, String productSpecification) {
		this.id = id;
		this.productId = productId;
		this.productSpecification = productSpecification;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public String getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(String productSpecification) {
		this.productSpecification = productSpecification;
	}

}
