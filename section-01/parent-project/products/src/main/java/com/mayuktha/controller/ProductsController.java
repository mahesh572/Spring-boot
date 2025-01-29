package com.mayuktha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayuktha.products.dto.ProductsDto;
import com.mayuktha.products.response.ApiResponse;
import com.mayuktha.products.service.IProductsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/api/v1/products",produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductsController {

	private static final Logger log = LoggerFactory.getLogger(ProductsController.class);
	
	
	@Autowired
	IProductsService iProductsService;
	
	
	@PostMapping
	public ResponseEntity saveProducts(@RequestBody ProductsDto productsDto) {
		iProductsService.saveProducts(productsDto);
		ApiResponse<String> apiResponse = new ApiResponse<String>(HttpStatus.CREATED.value(),"SUCCESS","Record has been Created Successfully",null);
		return ResponseEntity.ok().body(apiResponse);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<ApiResponse<ProductsDto>> fetchProducts(@PathVariable int productId ) {
		log.debug("ProductsController::fetchProducts::::"+productId);
		ProductsDto productsDto = iProductsService.fetchProducts(productId);
		log.debug("ProductsController::productsDto::::"+productsDto);
		ApiResponse<ProductsDto> apiResponse = new ApiResponse<ProductsDto>(HttpStatus.OK.value(),"SUCCESS","",productsDto);
		return ResponseEntity.ok(apiResponse);
	}
	
}
