package com.group1.entities;

import javax.persistence.Entity;

@Entity
public class ProductColorVariant {
	private Integer id;
	private Product productId;
	private Color colorId;
	private String imageGalleryPath;

	public ProductColorVariant() {
	}

	public ProductColorVariant(Integer id, Product productId, Color colorId, String imageGalleryPath) {
		this.id = id;
		this.productId = productId;
		this.colorId = colorId;
		this.imageGalleryPath = imageGalleryPath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public Color getColorId() {
		return colorId;
	}

	public void setColorId(Color colorId) {
		this.colorId = colorId;
	}

	public String getImageGalleryPath() {
		return imageGalleryPath;
	}

	public void setImageGalleryPath(String imageGalleryPath) {
		this.imageGalleryPath = imageGalleryPath;
	}

}
