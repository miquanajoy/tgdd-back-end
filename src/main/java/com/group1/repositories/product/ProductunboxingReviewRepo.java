package com.group1.repositories.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.group1.dto.CustomerViewProductDetails.UnboxingDetails;
import com.group1.entities.product.ProductUnboxingReview;

public interface ProductunboxingReviewRepo extends JpaRepository<ProductUnboxingReview, Integer>{
	
	@Query("Select new com.group1.dto.CustomerViewProductDetails.UnboxingDetails(pu.image) "
			+ "From ProductUnboxingReview pu Where pu.productID = :ID")
	public List<UnboxingDetails> findByProductID(@Param("ID") String prodID);
}
