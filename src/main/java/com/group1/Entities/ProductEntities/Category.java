package com.group1.Entities.ProductEntities;

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
	
	public Category() {
	}

	public Category(Integer categoryID, String categoryName, Integer parentID, Set<Product> productList) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.parentID = parentID;
		ProductList = productList;
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

	
}
