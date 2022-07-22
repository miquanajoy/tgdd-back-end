package com.group1.entities.product;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
//fixed
@Entity
@Table(name = "category")
public class Category implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryID")
	private Integer categoryID;
	
	@Column(name = "IsParent")
	private Boolean isParent;
	
	@Column(name = "Level")
	private Integer level;
	
	@Lob
	@Column(name = "Icon", columnDefinition = "BLOB")
	private byte[] icon;
	
	@Column(name = "CategoryName")
	private String categoryName;
	
	@Column(name = "ParentID")
	private Integer parentID;
	
	@Column(name = "Enabled")
	private Boolean enabled;
	
	@OneToMany(mappedBy = "categoryID", cascade = CascadeType.ALL)
	private Set<Product> ProductList;
	
	@OneToMany(mappedBy = "cateIDReferrence", cascade = CascadeType.ALL)
	private Set<Manufacturer> brandList;
	
	@OneToMany(mappedBy = "categoryIdentifier", cascade = CascadeType.ALL)
	private Set<ProductTechSpecs> specList;
	
	public Category() {
	}
	
	public Category(Integer categoryID, Boolean isParent, Integer level, byte[] icon, String categoryName,
			Integer parentID, Boolean enabled) {
		super();
		this.categoryID = categoryID;
		this.isParent = isParent;
		this.level = level;
		this.icon = icon;
		this.categoryName = categoryName;
		this.parentID = parentID;
		this.enabled = enabled;
	}

	public Category(Integer categoryID, Boolean isParent, Integer level, byte[] icon, String categoryName,
			Integer parentID, Boolean enabled, Set<Product> productList, Set<Manufacturer> brandList,
			Set<ProductTechSpecs> specList) {
		super();
		this.categoryID = categoryID;
		this.isParent = isParent;
		this.level = level;
		this.icon = icon;
		this.categoryName = categoryName;
		this.parentID = parentID;
		this.enabled = enabled;
		ProductList = productList;
		this.brandList = brandList;
		this.specList = specList;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public byte[] getIcon() {
		return icon;
	}

	public void setIcon(byte[] icon) {
		this.icon = icon;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Product> getProductList() {
		return ProductList;
	}

	public void setProductList(Set<Product> productList) {
		ProductList = productList;
	}

	public Set<Manufacturer> getBrandList() {
		return brandList;
	}

	public void setBrandList(Set<Manufacturer> brandList) {
		this.brandList = brandList;
	}

	public Set<ProductTechSpecs> getSpecList() {
		return specList;
	}

	public void setSpecList(Set<ProductTechSpecs> specList) {
		this.specList = specList;
	}

	@Override
	public String toString() {
		return "categoryID=" + categoryID + "\n       isParent=" + isParent + "\n       level=" + level
				+ "\n       categoryName=" + categoryName + "\n       parentID=" + parentID + "\n       enabled="
				+ enabled;
	}

	
}
