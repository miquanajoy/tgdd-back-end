package com.group1.repositories.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.group1.dto.CustomerViewProductDetails.FeatureDetails;
import com.group1.entities.product.ProductFeature;

public interface ProductFeatureRepo extends JpaRepository<ProductFeature, Integer>{

	@Query("Select new com.group1.dto.CustomerViewProductDetails.FeatureDetails(pf.image) "
			+ "From ProductFeature pf Where pf.productID = :ID")
	public List<FeatureDetails> getFeatureByProductID(@Param("ID") String prodID);
}
