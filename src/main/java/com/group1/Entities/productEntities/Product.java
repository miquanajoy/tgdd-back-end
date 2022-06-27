package com.group1.Entities.productEntities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
//fixed
@Entity
@Table(name= "product")
@DynamicInsert
@DynamicUpdate
public class Product implements Serializable{
	@Id 
	@Column(name = "ProductID")
	private String productID;
	
	@Column(name = "ProductName")
	private String productName;
	
	@Column(name = "Price")
	private Integer price;
	
	//@Transient
	@ManyToOne
	@JoinColumn(name="ManufacturerID", referencedColumnName = "ManufacturerID", insertable = false, updatable = false) 
	private Manufacturer manufacturer;
	
	@Column(name = "ManufacturerID")
	private Integer manufacturerID;
	
	//@Transient
	@ManyToOne
	@JoinColumn(name="CategoryID", referencedColumnName = "CategoryID", insertable = false, updatable = false)
	private Category category;
	
	@Column(name = "CategoryID")
	private Integer categoryID;
	
	//@Transient
	@OneToOne(mappedBy = "productIdentifier", cascade = CascadeType.ALL)
	private ProductDiscount discount;
	
	@OneToOne(mappedBy = "productArticleIdentifier", cascade = CascadeType.ALL)
	private ProductArticle article;
	
	@OneToOne(mappedBy = "productCameraShotIdentifier", cascade = CascadeType.ALL)
	private ProductCameraShot cameraShots;
	
	@OneToMany(mappedBy = "productColorVariantIdentifier", cascade = CascadeType.ALL)
	private Set<ProductColorVariant> colorVariant;
	
	@OneToOne(mappedBy = "productFeatureIdentifier", cascade = CascadeType.ALL) 
	private ProductFeature features;
	  
	@OneToOne(mappedBy = "productSpecificationIdentifier", cascade = CascadeType.ALL) 
	private ProductSpecification specifications;
	  
	@OneToOne(mappedBy = "productUnboxingReviewIdentifier", cascade = CascadeType.ALL) 
	private ProductUnboxingReview unboxing;
	  
	@OneToOne(mappedBy = "productVariantIdentifier", cascade = CascadeType.ALL) 
	private ProductVariant variant;
	  
	@OneToMany(mappedBy = "productOriginalIdentifier", cascade = CascadeType.ALL) 
	private Set<ProductVariant> original;
	 
	@Column(name = "ProductWarranty")
	private Integer productWarranty;
	
	@Column(name = "Image")
	private String image;
	
	@Column(name = "InterestRate")
	private double interestRate;
	
	@Column(name = "Exclusive")
	private Boolean exclusive;
	
	@Column(name = "AccessoriesIncluded")
	private String accessoriesIncluded;
	
	@Column(name = "Enabled")
	private Boolean enabled;

	public Product() {
		
	}

	public Product(String productID, String productName, Integer price, Manufacturer manufacturer,
			Integer manufacturerID, Category category, Integer categoryID, ProductDiscount discount,
			ProductArticle article, ProductCameraShot cameraShots, Set<ProductColorVariant> colorVariant,
			ProductFeature features, ProductSpecification specifications, ProductUnboxingReview unboxing,
			ProductVariant variant, Set<ProductVariant> original, Integer productWarranty, String image,
			double interestRate, Boolean exclusive, String accessoriesIncluded, Boolean enabled) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.manufacturer = manufacturer;
		this.manufacturerID = manufacturerID;
		this.category = category;
		this.categoryID = categoryID;
		this.discount = discount;
		this.article = article;
		this.cameraShots = cameraShots;
		this.colorVariant = colorVariant;
		this.features = features;
		this.specifications = specifications;
		this.unboxing = unboxing;
		this.variant = variant;
		this.original = original;
		this.productWarranty = productWarranty;
		this.image = image;
		this.interestRate = interestRate;
		this.exclusive = exclusive;
		this.accessoriesIncluded = accessoriesIncluded;
		this.enabled = enabled;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getManufacturerID() {
		return manufacturerID;
	}

	public void setManufacturerID(Integer manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public ProductDiscount getDiscount() {
		return discount;
	}

	public void setDiscount(ProductDiscount discount) {
		this.discount = discount;
	}

	public ProductArticle getArticle() {
		return article;
	}

	public void setArticle(ProductArticle article) {
		this.article = article;
	}

	public ProductCameraShot getCameraShots() {
		return cameraShots;
	}

	public void setCameraShots(ProductCameraShot cameraShots) {
		this.cameraShots = cameraShots;
	}

	public Set<ProductColorVariant> getColorVariant() {
		return colorVariant;
	}

	public void setColorVariant(Set<ProductColorVariant> colorVariant) {
		this.colorVariant = colorVariant;
	}

	public ProductFeature getFeatures() {
		return features;
	}

	public void setFeatures(ProductFeature features) {
		this.features = features;
	}

	public ProductSpecification getSpecifications() {
		return specifications;
	}

	public void setSpecifications(ProductSpecification specifications) {
		this.specifications = specifications;
	}

	public ProductUnboxingReview getUnboxing() {
		return unboxing;
	}

	public void setUnboxing(ProductUnboxingReview unboxing) {
		this.unboxing = unboxing;
	}

	public ProductVariant getVariant() {
		return variant;
	}

	public void setVariant(ProductVariant variant) {
		this.variant = variant;
	}

	public Set<ProductVariant> getOriginal() {
		return original;
	}

	public void setOriginal(Set<ProductVariant> original) {
		this.original = original;
	}

	public Integer getProductWarranty() {
		return productWarranty;
	}

	public void setProductWarranty(Integer productWarranty) {
		this.productWarranty = productWarranty;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public Boolean getExclusive() {
		return exclusive;
	}

	public void setExclusive(Boolean exclusive) {
		this.exclusive = exclusive;
	}

	public String getAccessoriesIncluded() {
		return accessoriesIncluded;
	}

	public void setAccessoriesIncluded(String accessoriesIncluded) {
		this.accessoriesIncluded = accessoriesIncluded;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Product:\n\tproductID=" + productID + " \n\tproductName=" + productName + " \n\tprice=" + price
				+ " \n\tmanufacturer=" + manufacturer + " \n\tmanufacturerID=" + manufacturerID + " \n\tcategory="
				+ category + " \n\tcategoryID=" + categoryID + " \n\tdiscount=" + discount + " \n\tarticle=" + article
				+ " \n\tcameraShots=" + cameraShots + " \n\tcolorVariant=" + colorVariant + " \n\tfeatures=" + features
				+ " \n\tspecifications=" + specifications + " \n\tunboxing=" + unboxing + " \n\tvariant=" + variant
				+ " \n\toriginal=" + original + " \n\tproductWarranty=" + productWarranty + " \n\timage=" + image
				+ " \n\tinterestRate=" + interestRate + " \n\texclusive=" + exclusive + " \n\taccessoriesIncluded="
				+ accessoriesIncluded + " \n\tenabled=" + enabled;
	}

	
}
