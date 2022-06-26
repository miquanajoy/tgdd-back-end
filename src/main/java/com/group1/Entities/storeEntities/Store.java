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
@Table(name = "store")
public class Store implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "StoreID")
	private Integer storeId;
	@Column(name = "StoreName")
	private String storeName;
	@Column(name = "Address")
	private String address;
	@Column(name = "OpeningHours")
	private String openingHours;
	@Column(name = "ImageGalleryPath")
	private String imageGalleryPath;
	@Column(name = "CityID")
	private City cityId;
	@Column(name = "DistrictID")
	private District districtId;
	@Column(name = "WardID")
	private Ward wardId;
	@Column(name = "Enabled")
	private Boolean enabled;

	public Store() {
	}

	public Store(Integer storeId, String storeName, String address, String openingHours, String imageGalleryPath,
			City cityId, District districtId, Ward wardId, Boolean enabled) {
		this.storeId = storeId;
		this.storeName = storeName;
		this.address = address;
		this.openingHours = openingHours;
		this.imageGalleryPath = imageGalleryPath;
		this.cityId = cityId;
		this.districtId = districtId;
		this.wardId = wardId;
		this.enabled = enabled;
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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
