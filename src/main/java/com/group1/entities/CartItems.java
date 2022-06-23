package com.group1.entities;

import javax.persistence.Entity;

@Entity
public class CartItems {
	private ShoppingCart cartUUId;
	private String productId;
	private Integer quantity;

	public CartItems() {
	}

	public CartItems(ShoppingCart cartUUId, String productId, Integer quantity) {
		this.cartUUId = cartUUId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public ShoppingCart getCartUUId() {
		return cartUUId;
	}

	public void setCartUUId(ShoppingCart cartUUId) {
		this.cartUUId = cartUUId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
