package com.group1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group1.Entities.productEntities.Category;
import com.group1.Entities.productEntities.Manufacturer;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	public Category findByCategoryID(Integer id);
}
