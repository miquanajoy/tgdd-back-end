package com.group1.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group1.Entities.Product;


public interface ProductRepo extends JpaRepository<Product, String>{

	@Query("Select new com.group1.DTO.GeneralProductViewDTO(p.ProductName, p.Price, p.ProductWarranty, p.InterestRate, p.Exclusive"
			+ ", p.AccessoriesIncluded, p.Enabled) "
			+ "From Product p")
	List<Product> showAllProduct();
}
