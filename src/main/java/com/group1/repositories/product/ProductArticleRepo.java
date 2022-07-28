package com.group1.repositories.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group1.entities.product.ProductArticle;

public interface ProductArticleRepo extends JpaRepository<ProductArticle, Integer>{

}
