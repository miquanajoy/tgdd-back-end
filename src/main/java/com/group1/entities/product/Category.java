package com.group1.entities.product;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//fixed
@Entity
@Table(name = "category")
public class Category implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryID")
	private Integer categoryID;
	
	@Column(name = "CategoryName")
	private String categoryName;
	
	@Column(name = "ParentID")
	private Integer parentID;
	
	@OneToMany(mappedBy = "categoryID")
	private Set<Product> ProductList;
	
	@OneToMany(mappedBy = "categoryID")
	private Set<Manufacturer> brandList;
	
	public Category() {
	}

	public Category(Integer categoryID, String categoryName, Integer parentID, Set<Product> productList,
			Set<Manufacturer> brandList) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.parentID = parentID;
		ProductList = productList;
		this.brandList = brandList;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
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

	@Override
	public String toString() {
		return "categoryID=" + categoryID + "\n       categoryName=" + categoryName + "\n       parentID=" + parentID
				+ "\n       ProductList=" + ProductList + "\n       brandList=" + brandList;
	}

	
}
