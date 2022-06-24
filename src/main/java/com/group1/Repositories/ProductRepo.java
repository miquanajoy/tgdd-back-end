package com.group1.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group1.DTO.GeneralProductViewDTO;
import com.group1.DTO.ProductDiscountDTO;
import com.group1.Entities.Product.Product;


public interface ProductRepo extends JpaRepository<Product, String>{

	@Query("Select new com.group1.DTO.GeneralProductViewDTO(p.ProductName, p.Price, p.ProductWarranty, p.InterestRate, p.Exclusive"
			+ ", p.AccessoriesIncluded, p.Enabled) "
			+ "From Product p")
	List<GeneralProductViewDTO> showAllProduct();
	
	@Query("Select new com.group1.DTO.ProductDiscountDTO(p.ProductID, p.ProductName, p.Price, m.ManufacturerName, c.CategoryName, "
			+ "d.DiscountedPrice, d.DiscountPercent, d.StartDate, d.EndDate) "
			+ "From Product p "
			+ "Join p.ManufacturerID m "
			+ "join p.CategoryID c "
			+ "join p.discount d "
			+ "Where m.ManufacturerID=?1 AND c.CategoryID=?2 And p.ProductID=?3 ")
	List<ProductDiscountDTO> showProductDiscount(int brandID, int cateID, String pID);
}
