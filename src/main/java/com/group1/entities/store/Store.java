package com.group1.entities.store;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	
	@Column(name = "Image")
	private byte[] image;
	
	@ManyToOne
	@JoinColumn(name = "CityID", referencedColumnName = "CityID", insertable = false, updatable = false)
	private City cityIdentifier;
	
	@Column(name = "CityID")
	private Integer cityId;
	
	@ManyToOne
	@JoinColumn(name = "DistrictID", referencedColumnName = "DistrictID", insertable = false, updatable = false)
	private District districtIdentifier;
	
	@Column(name = "DistrictID")
	private Integer districtId;
	
	@ManyToOne
	@JoinColumn(name = "WardID", referencedColumnName = "WardID", insertable = false, updatable = false)
	private Ward wardIdentifier;
	
	@Column(name = "WardID")
	private Integer wardId;
	
	@OneToMany(mappedBy = "storeIdentity", cascade = CascadeType.ALL)
	private Set<StoreProductInStock> productsInStore;
	
	@Column(name = "Enabled")
	private Boolean enabled;

	@Transient
	private String toShowImage;
	
	public Store() {
	}

	public Store(Integer storeId, String storeName, String address, String openingHours, byte[] image,
			City cityIdentifier, Integer cityId, District districtIdentifier, Integer districtId, Ward wardIdentifier,
			Integer wardId, Set<StoreProductInStock> productsInStore, Boolean enabled, String toShowImage) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.address = address;
		this.openingHours = openingHours;
		this.image = image;
		this.cityIdentifier = cityIdentifier;
		this.cityId = cityId;
		this.districtIdentifier = districtIdentifier;
		this.districtId = districtId;
		this.wardIdentifier = wardIdentifier;
		this.wardId = wardId;
		this.productsInStore = productsInStore;
		this.enabled = enabled;
		this.toShowImage = toShowImage;
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public City getCityIdentifier() {
		return cityIdentifier;
	}

	public void setCityIdentifier(City cityIdentifier) {
		this.cityIdentifier = cityIdentifier;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public District getDistrictIdentifier() {
		return districtIdentifier;
	}

	public void setDistrictIdentifier(District districtIdentifier) {
		this.districtIdentifier = districtIdentifier;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public Ward getWardIdentifier() {
		return wardIdentifier;
	}

	public void setWardIdentifier(Ward wardIdentifier) {
		this.wardIdentifier = wardIdentifier;
	}

	public Integer getWardId() {
		return wardId;
	}

	public void setWardId(Integer wardId) {
		this.wardId = wardId;
	}

	public Set<StoreProductInStock> getProductsInStore() {
		return productsInStore;
	}

	public void setProductsInStore(Set<StoreProductInStock> productsInStore) {
		this.productsInStore = productsInStore;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getToShowImage() {
		return toShowImage;
	}

	public void setToShowImage(String toShowImage) {
		this.toShowImage = toShowImage;
	}

	@Override
	public String toString() {
		return "storeId=" + storeId + "\n       storeName=" + storeName + "\n       address=" + address
				+ "\n       openingHours=" + openingHours + "\n       image=" + Arrays.toString(image)
				+ "\n       cityIdentifier=" + cityIdentifier + "\n       cityId=" + cityId
				+ "\n       districtIdentifier=" + districtIdentifier + "\n       districtId=" + districtId
				+ "\n       wardIdentifier=" + wardIdentifier + "\n       wardId=" + wardId
				+ "\n       productsInStore=" + productsInStore + "\n       enabled=" + enabled
				+ "\n       toShowImage=" + toShowImage;
	}

	
}