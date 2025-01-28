package com.mayuktha.orders.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString @NoArgsConstructor @AllArgsConstructor
public class ProductsDto{
	String name;
	String description;
	String sku;
	float price;
	int categoryId;
	int subCategoryId;
	int quantity ;
}
