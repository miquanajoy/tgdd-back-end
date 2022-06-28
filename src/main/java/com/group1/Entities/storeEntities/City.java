package com.group1.Entities.storeEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//mqfixed
@Entity
@Table(name = "city")
public class City implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CityID")
	private Integer cityID;
	@Column(name = "CityName")
	private String cityName;

	public City() {
	}

	public City(Integer cityID, String cityName) {
		this.cityID = cityID;
		this.cityName = cityName;
	}

	public Integer getCityID() {
		return cityID;
	}

	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	

	
	

}
