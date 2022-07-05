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
@Table(name = "product_unboxing_review")
public class ProductUnboxingReview implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
	private Product productUnboxingReviewIdentifier;
	
	@Column(name = "ProductID")
	private String productID;
	
	@Column(name = "ImageGalleryPath")
	private String imageGalleryPath;

	public ProductUnboxingReview() {
	}

	public ProductUnboxingReview(Integer id, Product productUnboxingReviewIdentifier, String productID,
			String imageGalleryPath) {
		super();
		this.id = id;
		this.productUnboxingReviewIdentifier = productUnboxingReviewIdentifier;
		this.productID = productID;
		this.imageGalleryPath = imageGalleryPath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProductUnboxingReviewIdentifier() {
		return productUnboxingReviewIdentifier;
	}

	public void setProductUnboxingReviewIdentifier(Product productUnboxingReviewIdentifier) {
		this.productUnboxingReviewIdentifier = productUnboxingReviewIdentifier;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getImageGalleryPath() {
		return imageGalleryPath;
	}

	public void setImageGalleryPath(String imageGalleryPath) {
		this.imageGalleryPath = imageGalleryPath;
	}

	@Override
	public String toString() {
		return "ProductUnboxingReview:\n\tid=" + id + " \n\tproductID=" + productID + " \n\timageGalleryPath="
				+ imageGalleryPath;
	}

	
}
