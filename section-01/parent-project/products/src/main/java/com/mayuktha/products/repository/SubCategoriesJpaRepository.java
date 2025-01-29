package com.mayuktha.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mayuktha.products.entity.SubCategories;
@Repository
public interface SubCategoriesJpaRepository extends JpaRepository<SubCategories, Integer>{

}
