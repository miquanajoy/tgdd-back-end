package com.group1.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_color_variant")
public class ProductColorVariant implements Serializable{
	@Id @GeneratedValue
	private Integer ID;
	private Product ProductID;
	private Color ColorID;
	private String ImageGalleryPath;

	public ProductColorVariant() {
	}

	public ProductColorVariant(Integer iD, Product productID, Color colorID, String imageGalleryPath) {
		super();
		ID = iD;
		ProductID = productID;
		ColorID = colorID;
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

	public Color getColorID() {
		return ColorID;
	}

	public void setColorID(Color colorID) {
		ColorID = colorID;
	}

	public String getImageGalleryPath() {
		return ImageGalleryPath;
	}

	public void setImageGalleryPath(String imageGalleryPath) {
		ImageGalleryPath = imageGalleryPath;
	}

	

}
