package com.group1.Entities.productEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//mqfixed
@Entity
@Table(name = "product_specification")
public class ProductSpecification implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "ProductID")
	private Product productId;
	@Column(name = "ProductSpecifications")
	private String productSpecifications;

	public ProductSpecification() {
	}

	public ProductSpecification(Integer id, Product productId, String productSpecifications) {
		this.id = id;
		this.productId = productId;
		this.productSpecifications = productSpecifications;
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

	public String getProductSpecifications() {
		return productSpecifications;
	}

	public void setProductSpecifications(String productSpecifications) {
		this.productSpecifications = productSpecifications;
	}
	
}
