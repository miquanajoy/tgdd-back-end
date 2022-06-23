package com.group1.entities;

import javax.persistence.Entity;

@Entity
public class ShoppingCart {
	private Integer id;
	private Integer cartUUId;// Universal unique ID
	private Boolean active;
	private Integer promoteCodeId;
	private Boolean enable;

	public ShoppingCart() {
	}

	public ShoppingCart(Integer id, Integer cartUUId, Boolean active, 
			Integer promoteCodeId, Boolean enable) {
		this.id = id;
		this.cartUUId = cartUUId;
		this.active = active;
		this.promoteCodeId = promoteCodeId;
		this.enable = enable;
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

	public Integer getPromoteCodeId() {
		return promoteCodeId;
	}

	public void setPromoteCodeId(Integer promoteCodeId) {
		this.promoteCodeId = promoteCodeId;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

}
