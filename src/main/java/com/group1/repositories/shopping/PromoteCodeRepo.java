package com.group1.repositories.shopping;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group1.entities.shopping.PromoteCode;

public interface PromoteCodeRepo extends JpaRepository<PromoteCode, Integer>{

	public PromoteCode findByPromoteCodeName(String promoteName);

}
