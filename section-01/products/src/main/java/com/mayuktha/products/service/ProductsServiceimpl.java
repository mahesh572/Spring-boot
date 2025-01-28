package com.mayuktha.products.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayuktha.mapper.MapperUtil;
import com.mayuktha.products.dto.ProductsDto;
import com.mayuktha.products.entity.ProductCategory;
import com.mayuktha.products.entity.ProductSubCategory;
import com.mayuktha.products.entity.Products;
import com.mayuktha.products.exception.ResourceNotFoundException;
import com.mayuktha.products.repository.ProductCategoryJpaRepository;
import com.mayuktha.products.repository.ProductSubCategoriesJpaRepository;
import com.mayuktha.products.repository.ProductsJpaRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductsServiceimpl implements IProductsService{

	private static final Logger log = LoggerFactory.getLogger(ProductsServiceimpl.class);
	
	@Autowired
	ProductsJpaRepository productsJpaRepository;
	
	@Autowired
	ProductCategoryJpaRepository productCategoryJpaRepository;
	
	@Autowired
	ProductSubCategoriesJpaRepository productSubCategoriesJpaRepository;
	
	
	@Override
	@Transactional
	public Products saveProducts(ProductsDto productsDto) {
		Products products = MapperUtil.mapToProduct(productsDto, new Products());
		products=productsJpaRepository.save(products);
		log.debug("ProductsServiceimpl:::product ID :::{}",products.getId());
		
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductId(products.getId());
		productCategory.setCategoryId(productsDto.getCategoryId());
		
		productCategoryJpaRepository.save(productCategory);
		
		ProductSubCategory productSubCategory =new ProductSubCategory();
		productSubCategory.setProductId(products.getId());
		productSubCategory.setSubcategoryId(productsDto.getSubCategoryId());
		
		productSubCategoriesJpaRepository.save(productSubCategory);
		return products;
	}


	@Override
	public ProductsDto fetchProducts(int productId) {
		log.debug("ProductsServiceimpl:::fetchProducts::START::productId :::{}",productId);
		Products product=productsJpaRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("products", "ProductId", String.valueOf(productId)));
		ProductsDto productsDto =MapperUtil.mapToProductsDto(product, new ProductsDto());
		return productsDto;
	}
}
