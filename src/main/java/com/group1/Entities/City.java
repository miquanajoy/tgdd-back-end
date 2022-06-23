package com.group1.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class City implements Serializable{
	@Id @GeneratedValue
	private String CityID;
	private String CityName;

	public City() {
	}

	public City(String cityID, String cityName) {
		super();
		CityID = cityID;
		CityName = cityName;
	}

	public String getCityID() {
		return CityID;
	}

	public void setCityID(String cityID) {
		CityID = cityID;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	

}
