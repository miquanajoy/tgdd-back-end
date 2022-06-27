package com.group1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.group1.Entities.productEntities.Manufacturer;

public interface ManufacturerRepo extends JpaRepository<Manufacturer, Integer>{

	public Manufacturer findByManufacturerID(Integer id);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "Update manufacturer m set m.ManufacturerID = :#{#brand.ManufacturerID}, "
			+ "m.ManufacturerName = :#{#brand.ManufacturerName} "
			+ "Where m.ManufacturerID = ?1")
	public void updateBrand( Integer brandId, @Param("brand") Manufacturer brandModel); 
}