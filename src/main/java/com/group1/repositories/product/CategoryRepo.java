package com.group1.repositories.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group1.entities.product.Category;
import com.group1.entities.product.Manufacturer;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	public Category findByCategoryID(Integer id);
}
