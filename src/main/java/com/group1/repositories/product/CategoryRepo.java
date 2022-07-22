package com.group1.repositories.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group1.entities.product.Category;
import com.group1.entities.product.Manufacturer;
import com.group1.entities.product.Product;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	public Category findByCategoryID(Integer id);
	
	
}
