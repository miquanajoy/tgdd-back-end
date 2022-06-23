package com.group1.entities;

import javax.persistence.Entity;

@Entity
public class Manufacturer {
	private Integer manufacturerId;
	private String manufacturerName;

	public Manufacturer() {
	}

	public Manufacturer(Integer manufacturerId, String manufacturerName) {
		this.manufacturerId = manufacturerId;
		this.manufacturerName = manufacturerName;
	}

	public Integer getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Integer manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

}
