package com.mayuktha.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mayuktha.products.entity.ProductSubCategory;
@Repository
public interface ProductSubCategoriesJpaRepository extends JpaRepository<ProductSubCategory, Integer>{

}
