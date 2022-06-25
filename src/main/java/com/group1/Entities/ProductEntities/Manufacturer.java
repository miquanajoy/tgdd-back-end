package com.group1.Entities.ProductEntities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//fixed
@Entity
@Table(name = "manufacturer")
public class Manufacturer implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ManufacturerID")
	private Integer manufacturerID;
	
	@Column(name = "ManufacturerName")
	private String manufacturerName;
	
	@OneToMany(mappedBy = "manufacturerID")
	private Set<Product> ProductList;

	public Manufacturer() {
	}

	public Manufacturer(Integer manufacturerID, String manufacturerName, Set<Product> productList) {
		super();
		this.manufacturerID = manufacturerID;
		this.manufacturerName = manufacturerName;
		ProductList = productList;
	}

	public Integer getManufacturerID() {
		return manufacturerID;
	}

	public void setManufacturerID(Integer manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public Set<Product> getProductList() {
		return ProductList;
	}

	public void setProductList(Set<Product> productList) {
		ProductList = productList;
	}

	
}
