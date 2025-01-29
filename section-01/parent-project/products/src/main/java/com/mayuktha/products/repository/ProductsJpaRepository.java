package com.mayuktha.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mayuktha.products.entity.Products;
@Repository
public interface ProductsJpaRepository extends JpaRepository<Products, Integer>{

}
