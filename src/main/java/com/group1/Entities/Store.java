package com.group1.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Store implements Serializable{
	@Id @GeneratedValue
	private Integer StoreID;
	private String StoreName;
	private String Address;
	private String OpeningHours;
	private String ImageGalleryPath;
	private City CityID;
	private District DistrictID;
	private Ward WardID;
	private Boolean Enable;

	public Store() {
	}

	public Store(Integer storeID, String storeName, String address, String openingHours, String imageGalleryPath,
			City cityID, District districtID, Ward wardID, Boolean enable) {
		super();
		StoreID = storeID;
		StoreName = storeName;
		Address = address;
		OpeningHours = openingHours;
		ImageGalleryPath = imageGalleryPath;
		CityID = cityID;
		DistrictID = districtID;
		WardID = wardID;
		Enable = enable;
	}

	public Integer getStoreID() {
		return StoreID;
	}

	public void setStoreID(Integer storeID) {
		StoreID = storeID;
	}

	public String getStoreName() {
		return StoreName;
	}

	public void setStoreName(String storeName) {
		StoreName = storeName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getOpeningHours() {
		return OpeningHours;
	}

	public void setOpeningHours(String openingHours) {
		OpeningHours = openingHours;
	}

	public String getImageGalleryPath() {
		return ImageGalleryPath;
	}

	public void setImageGalleryPath(String imageGalleryPath) {
		ImageGalleryPath = imageGalleryPath;
	}

	public City getCityID() {
		return CityID;
	}

	public void setCityID(City cityID) {
		CityID = cityID;
	}

	public District getDistrictID() {
		return DistrictID;
	}

	public void setDistrictID(District districtID) {
		DistrictID = districtID;
	}

	public Ward getWardID() {
		return WardID;
	}

	public void setWardID(Ward wardID) {
		WardID = wardID;
	}

	public Boolean getEnable() {
		return Enable;
	}

	public void setEnable(Boolean enable) {
		Enable = enable;
	}

	
}
