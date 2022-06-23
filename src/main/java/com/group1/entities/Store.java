package com.group1.entities;

import javax.persistence.Entity;

@Entity
public class Store {
	private Integer storeId;
	private String storeName;
	private String address;
	private String openingHours;
	private String imageGalleryPath;
	private City cityId;
	private District districtId;
	private Ward wardId;
	private Boolean enable;

	public Store() {
	}

	public Store(Integer storeId, String storeName, String address, String openingHours, String imageGalleryPath,
			City cityId, District districtId, Ward wardId, Boolean enable) {
		this.storeId = storeId;
		this.storeName = storeName;
		this.address = address;
		this.openingHours = openingHours;
		this.imageGalleryPath = imageGalleryPath;
		this.cityId = cityId;
		this.districtId = districtId;
		this.wardId = wardId;
		this.enable = enable;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public String getImageGalleryPath() {
		return imageGalleryPath;
	}

	public void setImageGalleryPath(String imageGalleryPath) {
		this.imageGalleryPath = imageGalleryPath;
	}

	public City getCityId() {
		return cityId;
	}

	public void setCityId(City cityId) {
		this.cityId = cityId;
	}

	public District getDistrictId() {
		return districtId;
	}

	public void setDistrictId(District districtId) {
		this.districtId = districtId;
	}

	public Ward getWardId() {
		return wardId;
	}

	public void setWardId(Ward wardId) {
		this.wardId = wardId;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

}
