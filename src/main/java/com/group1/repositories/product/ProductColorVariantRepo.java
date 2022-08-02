package com.group1.repositories.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.group1.dto.CustomerViewProductDetails.ColorVariantDetails;
import com.group1.entities.product.ProductColorVariant;

public interface ProductColorVariantRepo extends JpaRepository<ProductColorVariant, Integer>{

	@Query("Select new com.group1.dto.CustomerViewProductDetails.ColorVariantDetails(pc.colorID, pc.image) " 
			+"From ProductColorVariant pc Where pc.productID = :ID")
	public List<ColorVariantDetails> getProductColorVariants(@Param("ID") String prodID);
	
	@Query("Select Distinct c.colorName From ProductColorVariant pc Join Color c On pc.colorID = c.colorID Where c.colorID = :ID")
	public String getProductColorName(@Param("ID") Integer colorID);
}
