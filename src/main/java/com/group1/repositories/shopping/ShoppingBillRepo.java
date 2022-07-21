package com.group1.repositories.shopping;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group1.entities.shopping.ShoppingBill;

public interface ShoppingBillRepo extends JpaRepository<ShoppingBill, Integer>{

}
