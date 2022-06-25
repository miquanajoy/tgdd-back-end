package com.group1.Entities.ShoppingEntities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.group1.Entities.ProductEntities.Product;

@Entity
@Table(name = "cart_items")
public class CartItems implements Serializable{
	@Id
	private ShoppingCart CartUUID;
	private Product ProductID;
	private Integer Quantity;

	public CartItems() {
	}

	public CartItems(ShoppingCart cartUUID, Product productID, Integer quantity) {
		super();
		CartUUID = cartUUID;
		ProductID = productID;
		Quantity = quantity;
	}

	public ShoppingCart getCartUUID() {
		return CartUUID;
	}

	public void setCartUUID(ShoppingCart cartUUID) {
		CartUUID = cartUUID;
	}

	public Product getProductID() {
		return ProductID;
	}

	public void setProductID(Product productID) {
		ProductID = productID;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	

}
