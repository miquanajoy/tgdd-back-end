package com.group1.repositories.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.group1.entities.product.ProductTechSpecs;

public interface ProductTechSpecsRepo extends JpaRepository<ProductTechSpecs, Integer>{

	@Query("Select new com.group1.entities.product.ProductTechSpecs(sp.id, sp.categoryID, sp.specName, sp.section) "
			+ "From ProductTechSpecs sp Where sp.categoryID = :ID")
	public List<ProductTechSpecs> specListByCategoryID(@Param("ID") Integer toFindID);

}
