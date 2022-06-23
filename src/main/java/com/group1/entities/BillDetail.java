package com.group1.entities;

import javax.persistence.Entity;

@Entity
public class BillDetail {
	private ShoppingBill billId;
	private String productId;
	private Integer quantity;

	public BillDetail() {
	}

	public BillDetail(ShoppingBill billId, String productId, Integer quantity) {
		this.billId = billId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public ShoppingBill getBillId() {
		return billId;
	}

	public void setBillId(ShoppingBill billId) {
		this.billId = billId;
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
