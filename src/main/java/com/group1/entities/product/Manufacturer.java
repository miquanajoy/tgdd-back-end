package com.group1.entities.product;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//fixed
@Entity
@Table(name = "manufacturer")
public class Manufacturer implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ManufacturerID")
	private Integer manufacturerID;
	
	@Column(name = "ManufacturerName")
	private String manufacturerName;
	
	@Lob
	@Column(name = "Icon", columnDefinition = "BLOB")
	private byte[] icon;
	
	@OneToMany(mappedBy = "manufacturerID")
	private Set<Product> ProductList;
	
	@ManyToOne
	@JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID", insertable = false, updatable = false)
	private Category cateIDReferrence;
	
	@Column(name = "CategoryID")
	private Integer categoryID;

	@Column(name = "Enabled")
	private Boolean enabled;
	
	public Manufacturer() {
	}

	public Manufacturer(Integer manufacturerID, String manufacturerName, byte[] icon, Set<Product> productList,
			Category cateIDReferrence, Integer categoryID, Boolean enabled) {
		super();
		this.manufacturerID = manufacturerID;
		this.manufacturerName = manufacturerName;
		this.icon = icon;
		ProductList = productList;
		this.cateIDReferrence = cateIDReferrence;
		this.categoryID = categoryID;
		this.enabled = enabled;
	}

	public Integer getManufacturerID() {
		return manufacturerID;
	}

	public void setManufacturerID(Integer manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public byte[] getIcon() {
		return icon;
	}

	public void setIcon(byte[] icon) {
		this.icon = icon;
	}

	public Set<Product> getProductList() {
		return ProductList;
	}

	public void setProductList(Set<Product> productList) {
		ProductList = productList;
	}

	public Category getCateIDReferrence() {
		return cateIDReferrence;
	}

	public void setCateIDReferrence(Category cateIDReferrence) {
		this.cateIDReferrence = cateIDReferrence;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "manufacturerID=" + manufacturerID + "\n       manufacturerName=" + manufacturerName + "\n       icon="
				+ Arrays.toString(icon) + "\n       categoryID=" + categoryID + "\n       enabled=" + enabled;
	}

}
