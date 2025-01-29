package com.mayuktha.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mayuktha.products.entity.ProductCategory;

@Repository
public interface ProductCategoryJpaRepository extends JpaRepository<ProductCategory, Integer>{

}
