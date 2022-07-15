package com.group1.entities.store;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.group1.entities.shopping.CustomerAddresses;
//mqfixed
@Entity
@Table(name = "city")
public class City implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CityID")
	private Integer cityID;
	
	@OneToMany(mappedBy = "cityIdentifier", cascade = CascadeType.ALL)
	private Set<Store> storeWithCityID;
	
	@OneToMany(mappedBy = "cityIdentifier", cascade = CascadeType.ALL)
	private Set<CustomerAddresses> customerWithCityID;
	
	@OneToMany(mappedBy = "cityIdentity", cascade = CascadeType.ALL)
	private Set<District> districtsOfCityID;
	
	@Column(name = "CityName")
	private String cityName;

	public City() {
	}

	public City(Integer cityID, Set<Store> storeWithCityID, Set<CustomerAddresses> customerWithCityID,
			Set<District> districtsOfCityID, String cityName) {
		super();
		this.cityID = cityID;
		this.storeWithCityID = storeWithCityID;
		this.customerWithCityID = customerWithCityID;
		this.districtsOfCityID = districtsOfCityID;
		this.cityName = cityName;
	}

	public Integer getCityID() {
		return cityID;
	}

	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}

	public Set<Store> getStoreWithCityID() {
		return storeWithCityID;
	}

	public void setStoreWithCityID(Set<Store> storeWithCityID) {
		this.storeWithCityID = storeWithCityID;
	}

	public Set<CustomerAddresses> getCustomerWithCityID() {
		return customerWithCityID;
	}

	public void setCustomerWithCityID(Set<CustomerAddresses> customerWithCityID) {
		this.customerWithCityID = customerWithCityID;
	}

	public Set<District> getDistrictsOfCityID() {
		return districtsOfCityID;
	}

	public void setDistrictsOfCityID(Set<District> districtsOfCityID) {
		this.districtsOfCityID = districtsOfCityID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "cityID=" + cityID + "\n       storeWithCityID=" + storeWithCityID + "\n       customerWithCityID="
				+ customerWithCityID + "\n       districtsOfCityID=" + districtsOfCityID + "\n       cityName="
				+ cityName;
	}

	
}