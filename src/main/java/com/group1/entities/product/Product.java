package com.group1.entities.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.group1.dto.ColorVariantUpdateDTO;
import com.group1.dto.SpecSection;
import com.group1.entities.shopping.BillDetail;
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
	
	@ManyToOne
	@JoinColumn(name="ManufacturerID", referencedColumnName = "ManufacturerID", insertable = false, updatable = false) 
	private Manufacturer manufacturer;
	
	@Column(name = "ManufacturerID")
	private Integer manufacturerID;
	
	@ManyToOne
	@JoinColumn(name="CategoryID", referencedColumnName = "CategoryID", insertable = false, updatable = false)
	private Category category;
	
	@Column(name = "CategoryID")
	private Integer categoryID;
	
	@OneToMany(mappedBy = "productidentifier", cascade = CascadeType.ALL)
	private Set<BillDetail> productInBills;
	
	@OneToOne(mappedBy = "productIdentifier", cascade = CascadeType.ALL)
	private ProductDiscount discount;
	
	@OneToOne(mappedBy = "productArticleIdentifier", cascade = CascadeType.ALL)
	private ProductArticle article;
	
	@OneToMany(mappedBy = "productCameraShotIdentifier", cascade = CascadeType.ALL)
	private Set<ProductCameraShot> cameraShots;
	
	@OneToMany(mappedBy = "productColorVariantIdentifier", cascade = CascadeType.ALL)
	private Set<ProductColorVariant> colorVariant;
	
	@OneToMany(mappedBy = "productFeatureIdentifier", cascade = CascadeType.ALL) 
	private Set<ProductFeature> features;
	  
	@OneToOne(mappedBy = "productSpecificationIdentifier", cascade = CascadeType.ALL) 
	private ProductSpecification specifications;
	  
	@OneToMany(mappedBy = "productUnboxingReviewIdentifier", cascade = CascadeType.ALL) 
	private Set<ProductUnboxingReview> unboxing;
	  
	@OneToOne(mappedBy = "productVariantIdentifier", cascade = CascadeType.ALL) 
	private ProductVariant variant;
	  
	@OneToMany(mappedBy = "productOriginalIdentifier", cascade = CascadeType.ALL) 
	private Set<ProductVariant> original;
	 
	@Column(name = "ProductWarranty")
	private Integer productWarranty;
	
	@Lob
	@Column(name = "Image", columnDefinition = "BLOB")
	private byte[] image;
	
	@Column(name = "ImageType")
	private String imageType;
	
	@Column(name = "InterestRate")
	private double interestRate;
	
	@Column(name = "Exclusive")
	private Boolean exclusive;
	
	@Column(name = "AccessoriesIncluded")
	private String accessoriesIncluded;
	
	@Column(name = "Enabled")
	private Boolean enabled;
	
	@Transient
	private List<ProductColorVariant> colorVariantInputList;
	
	@Transient
	private String imageToShow;
	
	@Transient 
	private List<ColorVariantUpdateDTO> colorVarUpdateList;

	@Transient
	public List<SpecSection> specList;
	
	public Product() {
		
	}

	public Product(String productID, String productName, Integer price, Manufacturer manufacturer,
			Integer manufacturerID, Category category, Integer categoryID, Set<BillDetail> productInBills , ProductDiscount discount,
			ProductArticle article, Set<ProductCameraShot> cameraShots, Set<ProductColorVariant> colorVariant,
			Set<ProductFeature> features, ProductSpecification specifications, Set<ProductUnboxingReview> unboxing,
			ProductVariant variant, Set<ProductVariant> original, Integer productWarranty, byte[] image, String imageType,
			double interestRate, Boolean exclusive, String accessoriesIncluded, Boolean enabled,
			List<ProductColorVariant> colorVariantInputList, String imageToShow, List<ColorVariantUpdateDTO> colorVarUpdateList
			, List<SpecSection> specList) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.manufacturer = manufacturer;
		this.manufacturerID = manufacturerID;
		this.category = category;
		this.categoryID = categoryID;
		this.productInBills =productInBills;
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
		this.imageType = imageType ;
		this.interestRate = interestRate;
		this.exclusive = exclusive;
		this.accessoriesIncluded = accessoriesIncluded;
		this.enabled = enabled;
		this.colorVariantInputList = colorVariantInputList;
		this.imageToShow = imageToShow;
		this.colorVarUpdateList = colorVarUpdateList;
		this.specList = specList;
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

	public Set<BillDetail> getProductInBills() {
		return productInBills;
	}

	public void setProductInBills(Set<BillDetail> productInBills) {
		this.productInBills = productInBills;
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

	public Set<ProductCameraShot> getCameraShots() {
		return cameraShots;
	}

	public void setCameraShots(Set<ProductCameraShot> cameraShots) {
		this.cameraShots = cameraShots;
	}

	public Set<ProductColorVariant> getColorVariant() {
		return colorVariant;
	}

	public void setColorVariant(Set<ProductColorVariant> colorVariant) {
		this.colorVariant = colorVariant;
	}

	public Set<ProductFeature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<ProductFeature> features) {
		this.features = features;
	}

	public ProductSpecification getSpecifications() {
		return specifications;
	}

	public void setSpecifications(ProductSpecification specifications) {
		this.specifications = specifications;
	}

	public Set<ProductUnboxingReview> getUnboxing() {
		return unboxing;
	}

	public void setUnboxing(Set<ProductUnboxingReview> unboxing) {
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

	public List<ProductColorVariant> getColorVariantInputList() {
		return colorVariantInputList;
	}

	public void setColorVariantInputList(List<ProductColorVariant> colorVariantInputList) {
		this.colorVariantInputList = colorVariantInputList;
	}

	public String getImageToShow() {
		return imageToShow;
	}

	public void setImageToShow(String imageToShow) {
		this.imageToShow = imageToShow;
	}
	
	public List<ColorVariantUpdateDTO> getColorVarUpdateList() {
		return colorVarUpdateList;
	}

	public void setColorVarUpdateList(List<ColorVariantUpdateDTO> colorVarUpdateList) {
		this.colorVarUpdateList = colorVarUpdateList;
	}

	public List<SpecSection> getSpecList() {
		return specList;
	}

	public void setSpecList(List<SpecSection> specList) {
		this.specList = specList;
	}
	
	public String toString1() {
		return "productID=" + productID + "\n       productName=" + productName + "\n       price=" + price
				+ "\n       manufacturerID=" + manufacturerID + "\n       categoryID=" + categoryID
				+ "\n       productWarranty=" + productWarranty + "\n       imageType=" + imageType
				+ "\n       interestRate=" + interestRate + "\n       exclusive=" + exclusive
				+ "\n       accessoriesIncluded=" + accessoriesIncluded + "\n       enabled=" + enabled
				+ "\n       specList=" + specList;
	}

	@Override
	public String toString() {
		return "productID=" + productID + "\n       productName=" + productName + "\n       price=" + price
				+ "\n       manufacturer=" + manufacturer + "\n       manufacturerID=" + manufacturerID
				+ "\n       category=" + category + "\n       categoryID=" + categoryID + "\n       productInBills="
				+ productInBills + "\n       discount=" + discount + "\n       article=" + article
				+ "\n       cameraShots=" + cameraShots + "\n       colorVariant=" + colorVariant + "\n       features="
				+ features + "\n       specifications=" + specifications + "\n       unboxing=" + unboxing
				+ "\n       variant=" + variant + "\n       original=" + original + "\n       productWarranty="
				+ productWarranty + "\n       image=" + Arrays.toString(image) + "\n       imageType=" + imageType
				+ "\n       interestRate=" + interestRate + "\n       exclusive=" + exclusive
				+ "\n       accessoriesIncluded=" + accessoriesIncluded + "\n       enabled=" + enabled
				+ "\n       colorVariantInputList=" + colorVariantInputList + "\n       imageToShow=" + imageToShow
				+ "\n       colorVarUpdateList=" + colorVarUpdateList + "\n       specList=" + specList;
	}
	
	
}
