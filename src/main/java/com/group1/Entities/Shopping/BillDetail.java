package com.group1.Entities.Shopping;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.group1.Entities.Product.Product;

@Entity
@Table(name = "bill_detail")
public class BillDetail implements Serializable{
	@Id
	private ShoppingBill BillID;
	private Product ProductID;
	private Integer Quantity;

	public BillDetail() {
	}

	public BillDetail(ShoppingBill billID, Product productID, Integer quantity) {
		super();
		BillID = billID;
		ProductID = productID;
		Quantity = quantity;
	}

	public ShoppingBill getBillID() {
		return BillID;
	}

	public void setBillID(ShoppingBill billID) {
		BillID = billID;
	}

	public Product getProductID() {
		return ProductID;
	}

	public void setProductID(Product productID) {
		ProductID = productID;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	
}
