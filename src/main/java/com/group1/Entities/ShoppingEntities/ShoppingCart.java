package com.group1.Entities.ShoppingEntities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer cartUUId;// Universal unique ID
	private Boolean active;
	private PromoteCode promoteCodeID;
	private Boolean Enabled;

	public ShoppingCart() {
	}

	public ShoppingCart(Integer id, Integer cartUUId, Boolean active, PromoteCode promoteCodeID, Boolean enabled) {
		super();
		this.id = id;
		this.cartUUId = cartUUId;
		this.active = active;
		this.promoteCodeID = promoteCodeID;
		Enabled = enabled;
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

	public PromoteCode getPromoteCodeID() {
		return promoteCodeID;
	}

	public void setPromoteCodeID(PromoteCode promoteCodeID) {
		this.promoteCodeID = promoteCodeID;
	}

	public Boolean getEnabled() {
		return Enabled;
	}

	public void setEnabled(Boolean enabled) {
		Enabled = enabled;
	}

	

}
