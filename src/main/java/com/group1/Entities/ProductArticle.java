package com.group1.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_article")
public class ProductArticle implements Serializable{
	@Id @GeneratedValue
	private Integer ArticleID;
	private Product ProductID;
	private String ArticleUrl;

	public ProductArticle() {
	}

	public ProductArticle(Integer articleID, Product productID, String articleUrl) {
		super();
		ArticleID = articleID;
		ProductID = productID;
		ArticleUrl = articleUrl;
	}

	public Integer getArticleID() {
		return ArticleID;
	}

	public void setArticleID(Integer articleID) {
		ArticleID = articleID;
	}

	public Product getProductID() {
		return ProductID;
	}

	public void setProductID(Product productID) {
		ProductID = productID;
	}

	public String getArticleUrl() {
		return ArticleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		ArticleUrl = articleUrl;
	}

	
}
