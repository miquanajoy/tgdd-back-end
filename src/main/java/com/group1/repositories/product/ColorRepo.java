package com.group1.repositories.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.group1.entities.product.Color;

public interface ColorRepo extends JpaRepository<Color, Integer>{

	@Query("Select new com.group1.entities.product.Color(co.colorID, co.colorName) "
			+ "From Color co")
	public List<Color> getColorList();

	@Query("Select c.colorName From Color c Where c.colorID = :ID")
	public String getColorName(@Param("ID") Integer colorID);
}
