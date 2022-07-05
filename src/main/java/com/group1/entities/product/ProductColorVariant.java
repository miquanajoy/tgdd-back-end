package com.group1.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//mqfixed
@Entity
@Table(name = "product_color_variant")
public class ProductColorVariant implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false) 
	private Product productColorVariantIdentifier;
	
	@Column(name = "ProductID")
	private String productID;
	
	@ManyToOne
	@JoinColumn(name="ColorID", referencedColumnName = "ColorID", insertable = false, updatable = false) 
	private Color color;
	
	@Column(name = "ColorID")
	private Integer colorID;
	
	@Column(name = "ImageGalleryPath")
	private String imageGalleryPath;

	public ProductColorVariant() {
	}

	public ProductColorVariant(Integer id, Product productColorVariantIdentifier, String productID, Integer colorId, String imageGalleryPath) {
		super();
		this.id = id;
		this.productColorVariantIdentifier = productColorVariantIdentifier;
		this.productID = productID;
		this.colorID = colorId;
		this.imageGalleryPath = imageGalleryPath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProductColorVariantIdentifier() {
		return productColorVariantIdentifier;
	}

	public void setProductColorVariantIdentifier(Product productColorVariantIdentifier) {
		this.productColorVariantIdentifier = productColorVariantIdentifier;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public Integer getColorID() {
		return colorID;
	}

	public void setColorID(Integer colorID) {
		this.colorID = colorID;
	}

	public String getImageGalleryPath() {
		return imageGalleryPath;
	}

	public void setImageGalleryPath(String imageGalleryPath) {
		this.imageGalleryPath = imageGalleryPath;
	}

	@Override
	public String toString() {
		return "ProductColorVariant:\n\tid=" + id + " \n\tproductID=" + productID + " \n\tcolorId=" + colorID
				+ " \n\timageGalleryPath=" + imageGalleryPath;
	}

	

}
