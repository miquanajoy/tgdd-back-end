package com.group1.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//mqfixed
@Entity
@Table(name = "product_feature")
public class ProductFeature implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
	private Product productFeatureIdentifier;
	
	@Column(name = "ProductID")
	private String productID;
	
	@Column(name = "FeaturesVideoLink")
	private String featuresVideoLink;
	
	@Column(name = "FeaturesGalleryPath")
	private String featuresGalleryPath;

	public ProductFeature() {
	}

	public ProductFeature(Integer id, Product productFeatureIdentifier, String productID, String featuresVideoLink,
			String featuresGalleryPath) {
		super();
		this.id = id;
		this.productFeatureIdentifier = productFeatureIdentifier;
		this.productID = productID;
		this.featuresVideoLink = featuresVideoLink;
		this.featuresGalleryPath = featuresGalleryPath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProductFeatureIdentifier() {
		return productFeatureIdentifier;
	}

	public void setProductFeatureIdentifier(Product productFeatureIdentifier) {
		this.productFeatureIdentifier = productFeatureIdentifier;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
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

	@Override
	public String toString() {
		return "ProductFeature:\n\tid=" + id + " \n\tproductID=" + productID + " \n\tfeaturesVideoLink="
				+ featuresVideoLink + " \n\tfeaturesGalleryPath=" + featuresGalleryPath;
	}

	
}
