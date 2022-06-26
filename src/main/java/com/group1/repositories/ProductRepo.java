package com.group1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group1.Entities.productEntities.Product;
import com.group1.dto.GeneralProductViewDTO;
import com.group1.dto.ProductDiscountDTO;


public interface ProductRepo extends JpaRepository<Product, String>{

	@Query("Select new com.group1.DTO.GeneralProductViewDTO(p.productName, p.price, p.productWarranty, p.interestRate, p.exclusive"
			+ ", p.accessoriesIncluded, p.enabled) "
			+ "From Product p")
	List<GeneralProductViewDTO> showAllProduct();
	
	@Query("Select new com.group1.DTO.ProductDiscountDTO(p.productID, p.productName, p.price, m.manufacturerName, c.categoryName, "
			+ "d.discountedPrice, d.discountPercent, d.startDate, d.endDate) "
			+ "From Product p "
			+ "Join p.manufacturerID m "
			+ "join p.categoryID c "
			+ "join p.discount d "
			+ "Where m.manufacturerID=?1 AND c.categoryID=?2 And p.productID=?3 ")
	List<ProductDiscountDTO> showProductDiscount(int brandID, int cateID, String pID);
}
