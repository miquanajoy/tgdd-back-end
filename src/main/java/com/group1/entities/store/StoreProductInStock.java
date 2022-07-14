package com.group1.entities.store;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.group1.entities.product.Color;
import com.group1.entities.product.Product;

//mqfixed
@Entity
@Table(name = "store_products_in_stock")
public class StoreProductInStock implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "StoreID", referencedColumnName = "StoreID", insertable = false, updatable = false)
	private Store storeIdentity;
	
	@Column(name = "StoreID")
	private Integer storeId;
	
	@ManyToOne
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
	private Product productIdentity;
	
	@Column(name = "ProductID")
	private Integer productId;
	
	@Column(name = "Quantity")
	private Integer quantity;
	
	@Column(name = "LocalPrice")
	private Integer localPrice;
	
	@ManyToOne
	@JoinColumn(name = "ColorID", referencedColumnName = "ColorID", insertable = false, updatable = false)
	private Color colorIdentity;
	
	@Column(name = "ColorID")
	private Integer colorId;

	public StoreProductInStock() {
	}

	public StoreProductInStock(Integer id, Store storeIdentity, Integer storeId, Product productIdentity,
			Integer productId, Integer quantity, Integer localPrice, Color colorIdentity, Integer colorId) {
		super();
		this.id = id;
		this.storeIdentity = storeIdentity;
		this.storeId = storeId;
		this.productIdentity = productIdentity;
		this.productId = productId;
		this.quantity = quantity;
		this.localPrice = localPrice;
		this.colorIdentity = colorIdentity;
		this.colorId = colorId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Store getStoreIdentity() {
		return storeIdentity;
	}

	public void setStoreIdentity(Store storeIdentity) {
		this.storeIdentity = storeIdentity;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Product getProductIdentity() {
		return productIdentity;
	}

	public void setProductIdentity(Product productIdentity) {
		this.productIdentity = productIdentity;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getLocalPrice() {
		return localPrice;
	}

	public void setLocalPrice(Integer localPrice) {
		this.localPrice = localPrice;
	}

	public Color getColorIdentity() {
		return colorIdentity;
	}

	public void setColorIdentity(Color colorIdentity) {
		this.colorIdentity = colorIdentity;
	}

	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	@Override
	public String toString() {
		return "id=" + id + "\n       storeIdentity=" + storeIdentity + "\n       storeId=" + storeId
				+ "\n       productIdentity=" + productIdentity + "\n       productId=" + productId
				+ "\n       quantity=" + quantity + "\n       localPrice=" + localPrice + "\n       colorIdentity="
				+ colorIdentity + "\n       colorId=" + colorId;
	}

}
