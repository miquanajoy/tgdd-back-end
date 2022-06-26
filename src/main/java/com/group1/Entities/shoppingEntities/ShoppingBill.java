package com.group1.Entities.shoppingEntities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//mqfixed
@Entity
@Table(name = "shopping_bill")
public class ShoppingBill implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BillID")
	private Integer billId;
	@Column(name = "CartUUID")
	private ShoppingCart cartUUId;
	@Column(name = "TimeCreated")
	private LocalDateTime timeCreated;
	@Column(name= "PromoteCodeID")
	private PromoteCode promoteCodeID;

	public ShoppingBill() {
	}

	public ShoppingBill(Integer billId, ShoppingCart cartUUId, LocalDateTime timeCreated, PromoteCode promoteCodeID) {
		this.billId = billId;
		this.cartUUId = cartUUId;
		this.timeCreated = timeCreated;
		this.promoteCodeID = promoteCodeID;
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

	public PromoteCode getPromoteCode() {
		return promoteCodeID;
	}

	public void setPromoteCode(PromoteCode promoteCode) {
		this.promoteCodeID = promoteCode;
	}

}
