package com.group1.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class ShoppingBill {
	private Integer billId;
	private ShoppingCart cartUUId;
	private LocalDateTime timeCreated;
	private String promoteCode;

	public ShoppingBill() {
	}

	public ShoppingBill(Integer billId, ShoppingCart cartUUId, LocalDateTime timeCreated, String promoteCode) {
		this.billId = billId;
		this.cartUUId = cartUUId;
		this.timeCreated = timeCreated;
		this.promoteCode = promoteCode;
	}

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public ShoppingCart getCartUUId() {
		return cartUUId;
	}

	public void setCartUUId(ShoppingCart cartUUId) {
		this.cartUUId = cartUUId;
	}

	public LocalDateTime getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(LocalDateTime timeCreated) {
		this.timeCreated = timeCreated;
	}

	public String getPromoteCode() {
		return promoteCode;
	}

	public void setPromoteCode(String promoteCode) {
		this.promoteCode = promoteCode;
	}

}
