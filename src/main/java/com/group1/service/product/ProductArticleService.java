package com.group1.service.product;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group1.dto.CustomerViewProductDetails.ArticleDetails;
import com.group1.repositories.product.ProductArticleRepo;

@Service
public class ProductArticleService {

	@Resource
	ProductArticleRepo articleRepo;

	public ArticleDetails findViewArticle(String ID) 
	{
		ArticleDetails viewArticle = articleRepo.getArticleByProductID(ID);
		return viewArticle;
	}
}
