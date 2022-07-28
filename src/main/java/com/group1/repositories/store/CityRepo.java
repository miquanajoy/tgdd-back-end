package com.group1.repositories.store;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group1.entities.store.City;

public interface CityRepo extends JpaRepository<City, Integer>{

}
