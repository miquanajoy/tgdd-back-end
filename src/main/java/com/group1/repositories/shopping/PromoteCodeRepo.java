package com.group1.repositories.shopping;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.group1.entities.shopping.PromoteCode;

public interface PromoteCodeRepo extends JpaRepository<PromoteCode, Integer>{
	
	@Query("Select new com.group1.entities.shopping.PromoteCode(pr.promoteCodeID, pr.promoteCodeName, pr.promoteCodeDescription, "
			+ "pr.discountPercent, pr.discountMaxAmount, pr.startDate, pr.endDate, pr.enabled) "
			+ "From PromoteCode pr Where pr.promoteCodeName LIKE %:name%")
	public PromoteCode getPromotionByName(@Param("name") String promoteName);
	
	@Query("Select new com.group1.entities.shopping.PromoteCode(pr.promoteCodeID, pr.promoteCodeName, pr.promoteCodeDescription, "
			+ "pr.discountPercent, pr.discountMaxAmount, pr.startDate, pr.endDate, pr.enabled) From PromoteCode pr")
	public List<PromoteCode> getAllPromotions();

}
