package com.group1.entities.store;

import java.io.Serializable;
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

import com.group1.entities.shopping.CustomerAddresses;

//mqfixed
@Entity
@Table
public class Ward implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WardID")
	private Integer wardId;
	
	@OneToMany(mappedBy = "wardIdentifier", cascade = CascadeType.ALL)
	private Set<Store> storeWithWardID;
	
	@OneToMany(mappedBy = "wardIdentifier", cascade = CascadeType.ALL)
	private Set<CustomerAddresses> customersWithWardID;
	
	@Column(name = "WardName")
	private String wardName;
	
	@ManyToOne
	@JoinColumn(name = "DistrictID", referencedColumnName = "DistrictID", insertable = false, updatable = false)
	private District districtIdentity;
	
	@Column(name = "DistrictID")
	private Integer districtID;

	public Ward() {
	}

	public Ward(Integer wardId, Set<Store> storeWithWardID, Set<CustomerAddresses> customersWithWardID, String wardName,
			District districtIdentity, Integer districtID) {
		super();
		this.wardId = wardId;
		this.storeWithWardID = storeWithWardID;
		this.customersWithWardID = customersWithWardID;
		this.wardName = wardName;
		this.districtIdentity = districtIdentity;
		this.districtID = districtID;
	}

	public Integer getWardId() {
		return wardId;
	}

	public void setWardId(Integer wardId) {
		this.wardId = wardId;
	}

	public Set<Store> getStoreWithWardID() {
		return storeWithWardID;
	}

	public void setStoreWithWardID(Set<Store> storeWithWardID) {
		this.storeWithWardID = storeWithWardID;
	}

	public Set<CustomerAddresses> getCustomersWithWardID() {
		return customersWithWardID;
	}

	public void setCustomersWithWardID(Set<CustomerAddresses> customersWithWardID) {
		this.customersWithWardID = customersWithWardID;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public District getDistrictIdentity() {
		return districtIdentity;
	}

	public void setDistrictIdentity(District districtIdentity) {
		this.districtIdentity = districtIdentity;
	}

	public Integer getDistrictID() {
		return districtID;
	}

	public void setDistrictID(Integer districtID) {
		this.districtID = districtID;
	}

	@Override
	public String toString() {
		return "wardId=" + wardId + "\n       storeWithWardID=" + storeWithWardID + "\n       customersWithWardID="
				+ customersWithWardID + "\n       wardName=" + wardName + "\n       districtIdentity="
				+ districtIdentity + "\n       districtID=" + districtID;
	}

	

}
