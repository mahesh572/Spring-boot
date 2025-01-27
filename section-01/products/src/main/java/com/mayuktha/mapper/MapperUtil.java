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
		
		products.setName(productsDto.name());
		products.setDescription(productsDto.description());
		products.setPrice(productsDto.price());
		products.setSku(productsDto.sku());
		products.setCreatedAt(LocalDateTime.now());
		return products;
	}
	
	
}
