package com.group1.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "store_products_in_stock")
public class StoreProductInStock implements Serializable{
	@Id
	private Product ProductID;
	private Store StoreID;
	private Integer Quantity;
	private Double LocalPrice;

	public StoreProductInStock() {
	}

	public StoreProductInStock(Product productID, Store storeID, Integer quantity, Double localPrice) {
		super();
		ProductID = productID;
		StoreID = storeID;
		Quantity = quantity;
		LocalPrice = localPrice;
	}

	public Product getProductID() {
		return ProductID;
	}

	public void setProductID(Product productID) {
		ProductID = productID;
	}

	public Store getStoreID() {
		return StoreID;
	}

	public void setStoreID(Store storeID) {
		StoreID = storeID;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public Double getLocalPrice() {
		return LocalPrice;
	}

	public void setLocalPrice(Double localPrice) {
		LocalPrice = localPrice;
	}

	
}
