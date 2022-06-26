package com.group1.Entities.shoppingEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//mqfixed
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "CartUUID")
	private Integer cartUUId;// Universal unique ID
	@Column(name = "Active")
	private Boolean active;
	@Column(name = "PromoteCodeID")
	private PromoteCode promoteCodeId;
	@Column(name = "Enabled")
	private Boolean enabled;

	public ShoppingCart() {
	}

	public ShoppingCart(Integer id, Integer cartUUId, Boolean active, PromoteCode promoteCodeId, Boolean enabled) {
		this.id = id;
		this.cartUUId = cartUUId;
		this.active = active;
		this.promoteCodeId = promoteCodeId;
		this.enabled = enabled;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCartUUId() {
		return cartUUId;
	}

	public void setCartUUId(Integer cartUUId) {
		this.cartUUId = cartUUId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public PromoteCode getPromoteCodeId() {
		return promoteCodeId;
	}

	public void setPromoteCodeId(PromoteCode promoteCodeId) {
		this.promoteCodeId = promoteCodeId;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
