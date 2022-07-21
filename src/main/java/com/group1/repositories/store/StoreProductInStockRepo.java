package com.group1.repositories.store;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group1.entities.store.StoreProductInStock;

public interface StoreProductInStockRepo extends JpaRepository<StoreProductInStock, Integer>{

}
