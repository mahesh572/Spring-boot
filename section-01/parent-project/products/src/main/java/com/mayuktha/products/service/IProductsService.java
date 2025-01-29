package com.mayuktha.products.service;

import com.mayuktha.products.dto.ProductsDto;
import com.mayuktha.products.entity.Products;

public interface IProductsService {
	
	Products saveProducts(ProductsDto productsDto);
	ProductsDto fetchProducts(int productId);

}
