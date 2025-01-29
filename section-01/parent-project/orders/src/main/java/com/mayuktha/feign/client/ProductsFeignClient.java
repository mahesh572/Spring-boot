package com.mayuktha.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCTS")
public interface ProductsFeignClient {

	@GetMapping(value = "/api/v1/products/{productId}",consumes = "application/json")
	public ResponseEntity<com.mayuktha.orders.response.ApiResponse<com.mayuktha.orders.dto.ProductsDto>> fetchProducts(@PathVariable int productId);
}
