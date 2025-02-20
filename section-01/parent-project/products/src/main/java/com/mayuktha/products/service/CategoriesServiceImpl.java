package com.mayuktha.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayuktha.mapper.MapperUtil;
import com.mayuktha.products.dto.CategoriesDto;
import com.mayuktha.products.dto.SubCategoriesDto;
import com.mayuktha.products.entity.Categories;
import com.mayuktha.products.entity.SubCategories;
import com.mayuktha.products.repository.CategoriesJparepository;
import com.mayuktha.products.repository.SubCategoriesJpaRepository;

@Service
public class CategoriesServiceImpl implements ICategoriesService{

	@Autowired
	CategoriesJparepository categoriesJparepository;
	@Autowired
	SubCategoriesJpaRepository subCategoriesJpaRepository;
	
	@Override
	public void savecategories(CategoriesDto categoriesDto) {
		
		Categories categories = MapperUtil.mapToCategories(categoriesDto, new Categories());
		categories = categoriesJparepository.save(categories);
	}
	@Override
	public void saveSubCategories(SubCategoriesDto subCategoriesDto) {
		SubCategories subCategories = MapperUtil.mapToSubCategories(subCategoriesDto, new SubCategories());
		subCategoriesJpaRepository.save(subCategories);
	}
	
	
}
