package com.group1.entities;

import javax.persistence.Entity;

@Entity
public class Ward {
	private Integer wardId;
	private String wardName;

	public Ward() {
	}

	public Ward(Integer wardId, String wardName) {
		this.wardId = wardId;
		this.wardName = wardName;
	}

	public Integer getWardId() {
		return wardId;
	}

	public void setWardId(Integer wardId) {
		this.wardId = wardId;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

}
