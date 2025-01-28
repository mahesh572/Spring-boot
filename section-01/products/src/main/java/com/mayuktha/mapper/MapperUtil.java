package com.mayuktha.mapper;

import java.time.LocalDateTime;

import com.mayuktha.products.dto.CategoriesDto;
import com.mayuktha.products.dto.ProductsDto;
import com.mayuktha.products.dto.SubCategoriesDto;
import com.mayuktha.products.entity.Categories;
import com.mayuktha.products.entity.Products;
import com.mayuktha.products.entity.SubCategories;

public class MapperUtil {

	public static Categories mapToCategories(CategoriesDto categoriesDto,Categories categories) {
		categories.setCategoryname(categoriesDto.categoryName());
		categories.setDescription(categoriesDto.description());
		categories.setCreatedAt(LocalDateTime.now());
		return categories;
	}
	public static SubCategories mapToSubCategories(SubCategoriesDto subCategoriesDto,SubCategories subCategories) {
		subCategories.setCategoryId(subCategoriesDto.category_id());
		subCategories.setDescription(subCategoriesDto.description());
		subCategories.setSubcategoryname(subCategoriesDto.sub_category_name());
		subCategories.setCreatedAt(LocalDateTime.now());
		subCategories.setParentCategoryId(subCategoriesDto.parent_category_id());
		return subCategories;
	}
	
	public static Products mapToProduct(ProductsDto productsDto,Products products) {
		
		products.setName(productsDto.getName());
		products.setDescription(productsDto.getDescription());
		products.setPrice(productsDto.getPrice());
		products.setSku(productsDto.getSku());
		products.setCreatedAt(LocalDateTime.now());
		return products;
	}
	
	public static ProductsDto mapToProductsDto(Products products,ProductsDto productsDto) {
		productsDto.setName(products.getName());
		productsDto.setPrice(products.getPrice());
		productsDto.setDescription(products.getDescription());
		return productsDto;
	}
}
