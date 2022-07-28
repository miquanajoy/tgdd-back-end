package com.group1.repositories.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group1.entities.product.ProductTechSpecs;

public interface ProductTechSpecsRepo extends JpaRepository<ProductTechSpecs, Integer>{

	public List<ProductTechSpecs> findByCategoryID(Integer toFindID);

}
