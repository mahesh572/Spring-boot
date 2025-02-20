package com.mayuktha.orders.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayuktha.config.properties.UserContactInfoProperties;
import com.mayuktha.orders.dto.OrderDetailsDto;
import com.mayuktha.orders.entity.Order;
import com.mayuktha.orders.service.OrdersService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/api/v1/orders")
public class OrdersController {
	
	@Autowired
	OrdersService ordersService;
	
	@Autowired
	UserContactInfoProperties userContactInfoProperties;
	
	@PostMapping
	public ResponseEntity<Object> createOrder(@RequestBody OrderDetailsDto orderDetailsDto) {
		ordersService.createOrder(orderDetailsDto);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{orderId}")
	public OrderDetailsDto getOrder(@PathVariable int orderId) {
		return ordersService.fetchOrder(orderId);
	}
	
	@GetMapping(path = "contact")
	public ResponseEntity<Object> contactInfo() {
		// userContactInfoProperties
		return ResponseEntity.ok().body(userContactInfoProperties);
		
	}

}
