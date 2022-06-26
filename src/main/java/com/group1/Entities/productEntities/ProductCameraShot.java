package com.group1.Entities.productEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//mqfixed
@Entity
@Table(name = "product_camera_shots")
public class ProductCameraShot implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "ProductID")
	private Product productId;
	@Column(name = "ImageGalleryPath")
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
