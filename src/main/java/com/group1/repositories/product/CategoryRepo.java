package com.group1.repositories.product;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group1.entities.product.Category;
import com.group1.entities.product.Manufacturer;
import com.group1.entities.product.Product;
import com.group1.entities.product.ProductTechSpecs;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	public Category findByCategoryID(Integer id);
	
//	@Query(value= "SELECT new com.group1.entities.product.Category(c.categoryID, c.isParent, c.level, c.icon, c.categoryName,"
//			+ "c.parentID, c.enabled) "
//			+ "FROM Category c")
	@Query(value="SELECT * From Category", nativeQuery = true)
	public List<Category> findAllCategory();
	
	
}
