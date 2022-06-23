package com.group1.entities;

import javax.persistence.Entity;

@Entity
public class District {
	private Integer districtId;
	private String districtName;

	public District() {
	}

	public District(Integer districtId, String districtName) {
		this.districtId = districtId;
		this.districtName = districtName;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

}
