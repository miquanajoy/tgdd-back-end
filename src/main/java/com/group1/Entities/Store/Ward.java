package com.group1.Entities.Store;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ward implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer WardID;
	private String WardName;

	public Ward() {
	}

	public Ward(Integer wardID, String wardName) {
		super();
		WardID = wardID;
		WardName = wardName;
	}

	public Integer getWardID() {
		return WardID;
	}

	public void setWardID(Integer wardID) {
		WardID = wardID;
	}

	public String getWardName() {
		return WardName;
	}

	public void setWardName(String wardName) {
		WardName = wardName;
	}

	
}
