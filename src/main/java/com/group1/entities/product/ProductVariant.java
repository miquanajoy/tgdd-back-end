package com.group1.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//mqfixed
@Entity
@Table(name = "product_variant")
public class ProductVariant implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "ProductVariantID", referencedColumnName = "ProductID", insertable = false, updatable = false)
	private Product productVariantIdentifier;
	
	@Column(name = "ProductVariantID")
	private String productVariantID;
	
	@ManyToOne
	@JoinColumn(name="OriginalProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
	private Product productOrigin;
	
	@Column(name = "OriginalProductID")
	private String productOriginalIdentifier;
	
	@Column(name = "ProductVariantName")
	private String productVariantName;

	public ProductVariant() {
	}

	public ProductVariant(Integer id, Product productVariantIdentifier, String productVariantID, Product productOrigin,
			String productOriginalIdentifier, String productVariantName) {
		super();
		this.id = id;
		this.productVariantIdentifier = productVariantIdentifier;
		this.productVariantID = productVariantID;
		this.productOrigin = productOrigin;
		this.productOriginalIdentifier = productOriginalIdentifier;
		this.productVariantName = productVariantName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProductVariantIdentifier() {
		return productVariantIdentifier;
	}

	public void setProductVariantIdentifier(Product productVariantIdentifier) {
		this.productVariantIdentifier = productVariantIdentifier;
	}

	public String getProductVariantID() {
		return productVariantID;
	}

	public void setProductVariantID(String productVariantID) {
		this.productVariantID = productVariantID;
	}

	public Product getProductOrigin() {
		return productOrigin;
	}

	public void setProductOrigin(Product productOrigin) {
		this.productOrigin = productOrigin;
	}

	public String getProductOriginalIdentifier() {
		return productOriginalIdentifier;
	}

	public void setProductOriginalIdentifier(String productOriginalIdentifier) {
		this.productOriginalIdentifier = productOriginalIdentifier;
	}

	public String getProductVariantName() {
		return productVariantName;
	}

	public void setProductVariantName(String productVariantName) {
		this.productVariantName = productVariantName;
	}

	@Override
	public String toString() {
		return "ProductVariant:\n\tid=" + id + " \n\tproductVariantID=" + productVariantID
				+ " \n\tproductOriginalIdentifier=" + productOriginalIdentifier + " \n\tproductVariantName="
				+ productVariantName;
	}

	
}
