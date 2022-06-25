package com.group1.Entities.StoreEntities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class District implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer DistrictID;
	private String DistrictName;

	public District() {
	}

	public District(Integer districtID, String districtName) {
		super();
		DistrictID = districtID;
		DistrictName = districtName;
	}

	public Integer getDistrictID() {
		return DistrictID;
	}

	public void setDistrictID(Integer districtID) {
		DistrictID = districtID;
	}

	public String getDistrictName() {
		return DistrictName;
	}

	public void setDistrictName(String districtName) {
		DistrictName = districtName;
	}

	

}
