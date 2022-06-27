package com.group1.Entities.productEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
//fixed
@Entity
@Table(name = "product_article")
@DynamicInsert
@DynamicUpdate
public class ProductArticle implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ArticleID")
	private Integer articleID;
	
	@OneToOne
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
	private Product productArticleIdentifier;
	
	@Column(name ="ProductID")
	private String productID;
		
	@Column(name = "ArticleUrl")
	private String articleUrl;

	public ProductArticle() {
	}

	public ProductArticle(Integer articleID, Product productArticleIdentifier, String productID, String articleUrl) {
		super();
		this.articleID = articleID;
		this.productArticleIdentifier = productArticleIdentifier;
		this.productID = productID;
		this.articleUrl = articleUrl;
	}

	public Integer getArticleID() {
		return articleID;
	}

	public void setArticleID(Integer articleID) {
		this.articleID = articleID;
	}

	public Product getProductArticleIdentifier() {
		return productArticleIdentifier;
	}

	public void setProductArticleIdentifier(Product productArticleIdentifier) {
		this.productArticleIdentifier = productArticleIdentifier;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

	@Override
	public String toString() {
		return "ProductArticle:\n\tarticleID=" + articleID + " \n\tproductID=" + productID + " \n\tarticleUrl="
				+ articleUrl;
	}

	
}
