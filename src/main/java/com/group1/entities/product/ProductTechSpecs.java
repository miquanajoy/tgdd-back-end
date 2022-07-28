package com.group1.entities.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_tech_specs")
public class ProductTechSpecs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID", insertable = false, updatable = false)
	private Category categoryIdentifier;
	
	@Column(name = "CategoryID")
	private Integer categoryID;
	
	@Column(name = "SpecName")
	private String specName;
	
	@Column(name = "Section")
	private String section;

	public ProductTechSpecs() {
		
	}

	public ProductTechSpecs(Integer id, Category categoryIdentifier, Integer categoryID, String specName,
			String section) {
		super();
		this.id = id;
		this.categoryIdentifier = categoryIdentifier;
		this.categoryID = categoryID;
		this.specName = specName;
		this.section = section;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategoryIdentifier() {
		return categoryIdentifier;
	}

	public void setCategoryIdentifier(Category categoryIdentifier) {
		this.categoryIdentifier = categoryIdentifier;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return "id=" + id + "\n       categoryID=" + categoryID + "\n       specName=" + specName + "\n       section="
				+ section;
	}

}
