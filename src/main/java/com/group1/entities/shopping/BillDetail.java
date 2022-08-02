package com.group1.entities.shopping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.group1.entities.product.Product;
import com.group1.entities.store.StoreProductInStock;

//mqfixed
@Entity
@Table(name = "bill_detail")
public class BillDetail implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "BillID", referencedColumnName = "BillID", insertable = false, updatable = false)
	private ShoppingBill billIdentifier;
	
	@Column(name = "BillID")
	private Integer billId;
	
	@ManyToOne
	@JoinColumn(name = "StoreProductID", referencedColumnName = "ID", insertable = false, updatable = false)
	private StoreProductInStock storeProductIdentifier;
	
	@Column(name = "StoreProductID")
	private Integer storeProductId;
	
	@Column(name = "Quantity")
	private Integer quantity;

	public BillDetail() {
	}

	public BillDetail(Integer id, ShoppingBill billIdentifier, Integer billId, StoreProductInStock storeProductIdentifier,
			Integer storeProductId, Integer quantity) {
		super();
		this.id = id;
		this.billIdentifier = billIdentifier;
		this.billId = billId;
		this.storeProductIdentifier = storeProductIdentifier;
		this.storeProductId = storeProductId;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ShoppingBill getBillIdentifier() {
		return billIdentifier;
	}

	public void setBillIdentifier(ShoppingBill billIdentifier) {
		this.billIdentifier = billIdentifier;
	}

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	
	public StoreProductInStock getStoreProductIdentifier() {
		return storeProductIdentifier;
	}

	public void setStoreProductIdentifier(StoreProductInStock storeProductIdentifier) {
		this.storeProductIdentifier = storeProductIdentifier;
	}

	public Integer getStoreProductId() {
		return storeProductId;
	}

	public void setStoreProductId(Integer storeProductId) {
		this.storeProductId = storeProductId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "id=" + id + "\n       billId=" + billId + "\n       storeProductId=" + storeProductId
				+ "\n       quantity=" + quantity;
	}

}

