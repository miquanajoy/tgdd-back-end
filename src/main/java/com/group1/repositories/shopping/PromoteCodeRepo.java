package com.group1.repositories.shopping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.group1.entities.shopping.PromoteCode;

public interface PromoteCodeRepo extends JpaRepository<PromoteCode, Integer>{
	
	@Query("Select pr From PromoteCode pr Where pr.promoteCodeName LIKE %:name%")
	public PromoteCode getPromoteCodeByName(@Param("name") String promoteName);

}
