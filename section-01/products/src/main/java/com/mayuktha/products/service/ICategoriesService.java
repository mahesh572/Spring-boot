package com.mayuktha.products.service;

import org.springframework.stereotype.Service;

import com.mayuktha.products.dto.CategoriesDto;
import com.mayuktha.products.dto.SubCategoriesDto;


public interface ICategoriesService {
	
	void savecategories(CategoriesDto categoriesDto);
	void saveSubCategories(SubCategoriesDto subCategoriesDto);

}
