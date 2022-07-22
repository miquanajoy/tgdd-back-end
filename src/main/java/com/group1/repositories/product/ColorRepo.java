package com.group1.repositories.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group1.entities.product.Color;

public interface ColorRepo extends JpaRepository<Color, Integer>{

	@Query("Select new com.group1.entities.product.Color(co.colorID, co.colorName) "
			+ "From Color co")
	public List<Color> getColorList();

}
