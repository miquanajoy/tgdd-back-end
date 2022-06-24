package com.group1.Entities.Store;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.group1.Entities.Product.Product;

@Entity
@Table(name = "store_products_in_stock")
public class StoreProductInStock implements Serializable{
	@Id
	private Product ProductID;
	private Store StoreID;
	private Integer Quantity;
	private int LocalPrice;

	public StoreProductInStock() {
	}

	public StoreProductInStock(Product productID, Store storeID, Integer quantity, int localPrice) {
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

	public int getLocalPrice() {
		return LocalPrice;
	}

	public void setLocalPrice(int localPrice) {
		LocalPrice = localPrice;
	}

	
}
