package com.group1.repositories.store;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group1.entities.store.Ward;

public interface WardRepo extends JpaRepository<Ward, Integer>{

}
