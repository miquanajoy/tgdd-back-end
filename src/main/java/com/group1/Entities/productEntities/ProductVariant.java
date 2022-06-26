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
@Table(name = "product_variant")
public class ProductVariant implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "ProductVariantID")
	private Product productVariantId;
	@Column(name = "OriginalProductID")
	private Product originalProductId;
	@Column(name = "ProductVariantName")
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
