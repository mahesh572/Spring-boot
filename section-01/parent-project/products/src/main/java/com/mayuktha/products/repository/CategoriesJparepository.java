package com.mayuktha.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mayuktha.products.entity.Categories;

@Repository
public interface CategoriesJparepository extends JpaRepository<Categories, Integer>{

}
