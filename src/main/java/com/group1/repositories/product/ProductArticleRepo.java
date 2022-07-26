package com.group1.repositories.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.group1.dto.CustomerViewProductDetails.ArticleDetails;
import com.group1.entities.product.ProductArticle;

public interface ProductArticleRepo extends JpaRepository<ProductArticle, Integer>{

	@Query("Select new com.group1.dto.CustomerViewProductDetails.ArticleDetails(pa.articleUrl) "
			+ "From ProductArticle pa Where pa.productID = :ID")
	public ArticleDetails getArticleByProductID(@Param("ID") String prodID); 
}
