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
@Table(name = "bill_detail")
public class BillDetail implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BillID")
	private ShoppingBill billId;
	@Column(name = "ProductID")
	private Product productId;
	@Column(name = "Quantity")
	private Integer quantity;

	public BillDetail() {
	}

	public BillDetail(ShoppingBill billId, Product productId, Integer quantity) {
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
