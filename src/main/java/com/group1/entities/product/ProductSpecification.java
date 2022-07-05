package com.group1.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//mqfixed
@Entity
@Table(name = "product_specification")
public class ProductSpecification implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
	private Product productSpecificationIdentifier;
	
	@Column(name = "ProductID")
	private String productID;
	
	@Column(name = "ProductSpecifications")
	private String productSpecifications;

	public ProductSpecification() {
	}

	public ProductSpecification(Integer id, Product productSpecificationIdentifier, String productID,
			String productSpecifications) {
		super();
		this.id = id;
		this.productSpecificationIdentifier = productSpecificationIdentifier;
		this.productID = productID;
		this.productSpecifications = productSpecifications;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProductSpecificationIdentifier() {
		return productSpecificationIdentifier;
	}

	public void setProductSpecificationIdentifier(Product productSpecificationIdentifier) {
		this.productSpecificationIdentifier = productSpecificationIdentifier;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductSpecifications() {
		return productSpecifications;
	}

	public void setProductSpecifications(String productSpecifications) {
		this.productSpecifications = productSpecifications;
	}

	@Override
	public String toString() {
		return "ProductSpecification:\n\tid=" + id + " \n\tproductID=" + productID + " \n\tproductSpecifications="
				+ productSpecifications;
	}

	
	
}
