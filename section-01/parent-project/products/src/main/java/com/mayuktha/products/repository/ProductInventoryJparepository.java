package com.mayuktha.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mayuktha.products.entity.ProductInventory;
@Repository
public interface ProductInventoryJparepository extends JpaRepository<ProductInventory, Integer>{

}
