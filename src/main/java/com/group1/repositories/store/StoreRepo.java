package com.group1.repositories.store;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group1.entities.store.Store;

public interface StoreRepo extends JpaRepository<Store, Integer>{

}
