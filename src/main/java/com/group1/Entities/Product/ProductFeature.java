package com.group1.Entities.Product;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_feature")
public class ProductFeature implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	private Product ProductID;
	private String featuresVideoLink;
	private String featuresGalleryPath;

	public ProductFeature() {
	}

	public ProductFeature(Integer iD, Product productID, String featuresVideoLink, String featuresGalleryPath) {
		super();
		ID = iD;
		ProductID = productID;
		this.featuresVideoLink = featuresVideoLink;
		this.featuresGalleryPath = featuresGalleryPath;
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

	public String getFeaturesVideoLink() {
		return featuresVideoLink;
	}

	public void setFeaturesVideoLink(String featuresVideoLink) {
		this.featuresVideoLink = featuresVideoLink;
	}

	public String getFeaturesGalleryPath() {
		return featuresGalleryPath;
	}

	public void setFeaturesGalleryPath(String featuresGalleryPath) {
		this.featuresGalleryPath = featuresGalleryPath;
	}

	

}
