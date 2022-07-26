package com.group1.repositories.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.group1.dto.CustomerViewProductDetails.ProductVariantDetails;
import com.group1.entities.product.ProductVariant;

public interface ProductVariantRepo extends JpaRepository<ProductVariant, Integer>{

	//public Boolean existsByProductOriginalIdentifier(String ID);
	
	@Query("Select new com.group1.dto.CustomerViewProductDetails.ProductVariantDetails(pv.productVariantID, "
			+ "pv.productOriginalIdentifier, pv.productVariantName) "
			+ "From ProductVariant pv Where pv.productVariantID = :ID Or pv.productOriginalIdentifier =:ID")
	public List<ProductVariantDetails> getProductVariantDetails(@Param("ID") String pID);
}
