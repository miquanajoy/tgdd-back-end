package com.group1.entities.product;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
//mqfixed
@Entity
@Table(name = "product_camera_shots")
public class ProductCameraShot implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
	private Product productCameraShotIdentifier;
	
	@Column(name = "ProductID")
	private String productID;
	
	@Lob
	@Column(name = "Image", columnDefinition = "BLOB")
	private byte[] image;

	@Column(name = "ImageType")
	private String imageType;
	
	@Transient
	private String toShowImage;
	
	public ProductCameraShot() {
	}

	public ProductCameraShot(Integer id, Product productCameraShotIdentifier, String productID,
			byte[] image, String imageType, String toShowImage) {
		super();
		this.id = id;
		this.productCameraShotIdentifier = productCameraShotIdentifier;
		this.productID = productID;
		this.image = image;
		this.imageType = imageType;
		this.toShowImage = toShowImage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProductCameraShotIdentifier() {
		return productCameraShotIdentifier;
	}

	public void setProductCameraShotIdentifier(Product productCameraShotIdentifier) {
		this.productCameraShotIdentifier = productCameraShotIdentifier;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getToShowImage() {
		return toShowImage;
	}

	public void setToShowImage(String toShowImage) {
		this.toShowImage = toShowImage;
	}

	@Override
	public String toString() {
		return "id=" + id
				+ "\n       productID=" + productID + "\n       imageType="
				+ imageType;
	}
	
}
