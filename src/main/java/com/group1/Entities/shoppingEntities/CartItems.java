package com.group1.Entities.shoppingEntities;

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
@Table(name = "cart_items")
public class CartItems implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CartUUID")
	private ShoppingCart cartUUId;
	@Column(name = "ProductID")
	private Product productId;
	@Column(name = "Quantity")
	private Integer quantity;

	public CartItems() {
	}

	public CartItems(ShoppingCart cartUUId, Product productId, Integer quantity) {
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

}
