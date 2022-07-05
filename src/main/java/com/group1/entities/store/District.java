package com.group1.entities.store;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "district")
public class District implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DistrictID")
	private Integer districtID;
	@Column(name = "DistrictName")
	private String districtName;

	public District() {
	}

	public District(Integer districtID, String districtName) {
		this.districtID = districtID;
		this.districtName = districtName;
	}

	public Integer getDistrictID() {
		return districtID;
	}

	public void setDistrictID(Integer districtID) {
		this.districtID = districtID;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

}
