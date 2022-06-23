package com.group1.entities;

import javax.persistence.Entity;

@Entity
public class StoreProductInStock {
	private String productId;
	private Integer storeId;
	private Integer quantity;
	private Double localPrice;

	public StoreProductInStock() {
	}

	public StoreProductInStock(String productId, Integer storeId, Integer quantity, Double localPrice) {
		this.productId = productId;
		this.storeId = storeId;
		this.quantity = quantity;
		this.localPrice = localPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getLocalPrice() {
		return localPrice;
	}

	public void setLocalPrice(Double localPrice) {
		this.localPrice = localPrice;
	}

}
