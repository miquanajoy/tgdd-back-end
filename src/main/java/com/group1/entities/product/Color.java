package com.group1.entities.product;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
//mqfixed
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.group1.entities.store.StoreProductInStock;

@Entity
@Table(name = "color")
public class Color implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ColorID")
	private Integer colorID;
	
	@OneToMany(mappedBy = "colorIdentity", cascade = CascadeType.ALL)
	private Set<StoreProductInStock> stockProductsWithColorID;
	
	@Column(name = "ColorName")
	private String colorName;

	public Color() {
	}

	public Color(Integer colorID, Set<StoreProductInStock> stockProductsWithColorID, String colorName) {
		super();
		this.colorID = colorID;
		this.stockProductsWithColorID = stockProductsWithColorID;
		this.colorName = colorName;
	}

	public Integer getColorID() {
		return colorID;
	}

	public void setColorID(Integer colorID) {
		this.colorID = colorID;
	}

	public Set<StoreProductInStock> getStockProductsWithColorID() {
		return stockProductsWithColorID;
	}

	public void setStockProductsWithColorID(Set<StoreProductInStock> stockProductsWithColorID) {
		this.stockProductsWithColorID = stockProductsWithColorID;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	@Override
	public String toString() {
		return "colorID=" + colorID + "\n       stockProductsWithColorID=" + stockProductsWithColorID
				+ "\n       colorName=" + colorName;
	}

}