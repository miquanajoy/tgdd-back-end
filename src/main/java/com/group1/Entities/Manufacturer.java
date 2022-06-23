package com.group1.Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Manufacturer implements Serializable{
	@Id 
	@GeneratedValue
	private int ManufacturerID;
	private String ManufacturerName;
	@OneToMany(mappedBy = "ManufacturerID")
	private Set<Product> ProductList;

	public Manufacturer() {
	}

	public Manufacturer(int manufacturerID, String manufacturerName, Set<Product> productList) {
		super();
		ManufacturerID = manufacturerID;
		ManufacturerName = manufacturerName;
		ProductList = productList;
	}

	public int getManufacturerID() {
		return ManufacturerID;
	}

	public void setManufacturerID(int manufacturerID) {
		ManufacturerID = manufacturerID;
	}

	public String getManufacturerName() {
		return ManufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		ManufacturerName = manufacturerName;
	}

	public Set<Product> getProductList() {
		return ProductList;
	}

	public void setProductList(Set<Product> productList) {
		ProductList = productList;
	}

	
	
}
