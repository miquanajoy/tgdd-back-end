package com.group1.Entities.ProductEntities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_unboxing_review")
public class ProductUnboxingReview implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	private Product ProductID;
	private String ImageGalleryPath;

	public ProductUnboxingReview() {
	}

	public ProductUnboxingReview(Integer iD, Product productID, String imageGalleryPath) {
		super();
		ID = iD;
		ProductID = productID;
		ImageGalleryPath = imageGalleryPath;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Product getProductID() {
		return ProductID;
	}

	public void setProductID(Product productID) {
		ProductID = productID;
	}

	public String getImageGalleryPath() {
		return ImageGalleryPath;
	}

	public void setImageGalleryPath(String imageGalleryPath) {
		ImageGalleryPath = imageGalleryPath;
	}

	
}
