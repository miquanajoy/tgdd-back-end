package com.group1.entities;

import javax.persistence.Entity;

@Entity
public class ProductFeature {
	private Integer id;
	private Product productId;
	private String featuresVideoLink;
	private String featuresGalleryPath;

	public ProductFeature() {
	}

	public ProductFeature(Integer id, Product productId, String featuresVideoLink, String featuresGalleryPath) {
		this.id = id;
		this.productId = productId;
		this.featuresVideoLink = featuresVideoLink;
		this.featuresGalleryPath = featuresGalleryPath;
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
