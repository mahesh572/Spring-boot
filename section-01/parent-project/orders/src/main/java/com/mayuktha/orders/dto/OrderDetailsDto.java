package com.mayuktha.orders.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class OrderDetailsDto {
	
	private int userId;
	private int total;
	private String status;
	private LocalDateTime createdAt;
	private int orderId;
	
	private List<ProductsDto> orderItems;
}
