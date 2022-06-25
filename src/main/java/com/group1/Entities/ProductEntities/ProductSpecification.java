package com.group1.Entities.ProductEntities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_specification")
public class ProductSpecification implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	private Product ProductID;
	private String ProductSpecifications;

	public ProductSpecification() {
	}

	public ProductSpecification(Integer iD, Product productID, String productSpecifications) {
		super();
		ID = iD;
		ProductID = productID;
		ProductSpecifications = productSpecifications;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Product getProductID() {
		return ProductID;
	}

	public void setProductID(Product productID) {
		ProductID = productID;
	}

	public String getProductSpecifications() {
		return ProductSpecifications;
	}

	public void setProductSpecifications(String productSpecifications) {
		ProductSpecifications = productSpecifications;
	}

	

	
}
