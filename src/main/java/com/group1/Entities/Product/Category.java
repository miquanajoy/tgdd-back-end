package com.group1.Entities.Product;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CategoryID;
	private String CategoryName;
	private Integer ParentID;
	@OneToMany(mappedBy = "CategoryID")
	private Set<Product> ProductList;
	
	public Category() {
	}

	public Category(int categoryID, String categoryName, Integer parentID, Set<Product> productList) {
		super();
		CategoryID = categoryID;
		CategoryName = categoryName;
		ParentID = parentID;
		ProductList = productList;
	}

	public int getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public Integer getParentID() {
		return ParentID;
	}

	public void setParentID(Integer parentID) {
		ParentID = parentID;
	}

	public Set<Product> getProductList() {
		return ProductList;
	}

	public void setProductList(Set<Product> productList) {
		ProductList = productList;
	}

	
	
}
