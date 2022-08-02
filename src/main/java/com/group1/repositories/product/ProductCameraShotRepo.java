package com.group1.repositories.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.group1.dto.CustomerViewProductDetails.CameraShotsDetails;
import com.group1.entities.product.ProductCameraShot;

public interface ProductCameraShotRepo extends JpaRepository<ProductCameraShot, Integer>{

	@Query("Select new com.group1.dto.CustomerViewProductDetails.CameraShotsDetails(ps.image) "
			+ "From ProductCameraShot ps Where ps.productID = :ID")
	public List<CameraShotsDetails> getCamShotsByProductID(@Param("ID") String ID);
}
