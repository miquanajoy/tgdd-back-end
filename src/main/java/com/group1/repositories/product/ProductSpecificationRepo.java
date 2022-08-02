package com.group1.repositories.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.group1.entities.product.ProductSpecification;

public interface ProductSpecificationRepo extends JpaRepository<ProductSpecification, Integer>{

	@Query("Select ps.productSpecifications From ProductSpecification ps Where ps.productID = :ID")
	public String getProductSpecification(@Param("ID") String prodID);
}
