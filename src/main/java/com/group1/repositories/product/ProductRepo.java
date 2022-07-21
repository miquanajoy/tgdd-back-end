package com.group1.repositories.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.group1.dto.GeneralProductViewDTO;
import com.group1.dto.ProductDiscountDTO;
import com.group1.entities.product.Product;


public interface ProductRepo extends JpaRepository<Product, String>{

	@Query("Select new com.group1.dto.GeneralProductViewDTO(p.productName, p.price, p.productWarranty, p.interestRate, p.exclusive"
			+ ", p.accessoriesIncluded, p.enabled) "
			+ "From Product p")
	public List<GeneralProductViewDTO> showAllProduct();
	
	@Query("Select new com.group1.dto.ProductDiscountDTO(p.productID, p.productName, p.price, m.manufacturerName, c.categoryName, "
			+ "d.discountedPrice, d.discountPercent, d.startDate, d.endDate) "
			+ "From Product p "
			+ "Join p.manufacturer m "
			+ "Join p.category c "
			+ "Join p.discount d "
			+ "Where m.manufacturerID=:brandID AND c.categoryID=:cateID And p.productID=:pID")
	public ProductDiscountDTO showProductDiscount(Integer brandID, Integer cateID, String pID);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value="Insert into product(ProductID, ProductName, Price, ManufacturerID, CategoryID, ProductWarranty, Image, InterestRate, "
			+ "Exclusive, AccessoriesIncluded, Enabled) "
			+ "Values(:#{#product.productID}, :#{#product.productName}, :#{#product.price}, :#{#product.manufacturerID}, "
			+ ":#{#product.categoryID}, :#{#product.productWarranty}, :#{#product.image}, :#{#product.interestRate}, :#{#product.exclusive}, "
			+ ":#{#product.accessoriesIncluded}, :#{#product.enabled})")
	public void saveNewProduct(@Param("product") Product saveProduct);
	
	public Product findByProductID(String productID);
	
	@Query("Select new com.group1.entities.product.Product(p.productID, p.productName, p.price, p.manufacturerID,"
			+ " p.categoryID, p.productWarranty, p.image, p.imageType,"
			+ " p.interestRate, p.exclusive, p.accessoriesIncluded, p.enabled) "
			+ "From Product p")
	public List<Product> findAllProducts();
		
	@Query("Select new com.group1.entities.product.Product(p.productID, p.productName, p.price, p.manufacturerID,"
			+ " p.categoryID, p.productWarranty, p.image, p.imageType,"
			+ " p.interestRate, p.exclusive, p.accessoriesIncluded, p.enabled) "
			+ "From Product p Where p.categoryID=:id")
	public List<Product> findProductByCategory(Integer id);
	
	@Query("Select new com.group1.entities.product.Product(p.productID, p.productName, p.price, p.manufacturerID,"
			+ " p.categoryID, p.productWarranty, p.image, p.imageType,"
			+ " p.interestRate, p.exclusive, p.accessoriesIncluded, p.enabled) "
			+ "From Product p Where p.manufacturerID=:id")
	public List<Product> findProductByManufacturer(Integer id);
}
