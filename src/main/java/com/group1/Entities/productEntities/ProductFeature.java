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
@Table(name = "product_feature")
public class ProductFeature implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "ProductID")
	private Product productId;
	@Column(name = "FeaturesVideoLink")
	private String featuresVideoLink;
	@Column(name = "FeaturesGalleryPath")
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
