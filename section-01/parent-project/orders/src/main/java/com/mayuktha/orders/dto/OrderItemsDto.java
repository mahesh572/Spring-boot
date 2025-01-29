package com.mayuktha.orders.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @ToString @NoArgsConstructor
public class OrderItemsDto {
	
	private int productId;
	private int quantity;
	private int orderId;
	private float price;

}
