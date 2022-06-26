package com.group1.Entities.storeEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.group1.Entities.productEntities.Product;

//mqfixed
@Entity
@Table(name = "store_products_in_stock")
public class StoreProductInStock implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "StoreID")
	private Store storeId;
	@Column(name = "ProductID")
	private Product productId;
	@Column(name = "Quantity")
	private Integer quantity;
	@Column(name = "LocalPrice")
	private Integer localPrice;

	public StoreProductInStock() {
	}

	public StoreProductInStock(Store storeId, Product productId, Integer quantity, Integer localPrice) {
		this.storeId = storeId;
		this.productId = productId;
		this.quantity = quantity;
		this.localPrice = localPrice;
	}

	public Store getStoreId() {
		return storeId;
	}

	public void setStoreId(Store storeId) {
		this.storeId = storeId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getLocalPrice() {
		return localPrice;
	}

	public void setLocalPrice(Integer localPrice) {
		this.localPrice = localPrice;
	}
	
	

	

}
