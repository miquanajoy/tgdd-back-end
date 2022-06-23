package com.group1.entities;

import javax.persistence.Entity;

@Entity
public class ProductArticle {
	private Integer articleId;
	private Product productId;
	private String articleUrl;

	public ProductArticle() {
	}

	public ProductArticle(Integer articleId, Product productId, String articleUrl) {
		this.articleId = articleId;
		this.productId = productId;
		this.articleUrl = articleUrl;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

}
