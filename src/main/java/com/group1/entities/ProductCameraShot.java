package com.group1.entities;

import javax.persistence.Entity;

@Entity
public class ProductCameraShot {
	private Integer id;
	private Product productId;
	private String imageGalleryPath;

	public ProductCameraShot() {
	}

	public ProductCameraShot(Integer id, Product productId, String imageGalleryPath) {
		this.id = id;
		this.productId = productId;
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

	public String getImageGalleryPath() {
		return imageGalleryPath;
	}

	public void setImageGalleryPath(String imageGalleryPath) {
		this.imageGalleryPath = imageGalleryPath;
	}

}
