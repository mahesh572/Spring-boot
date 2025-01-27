package com.mayuktha.orders.service;


import java.util.Optional;

import com.mayuktha.orders.dto.OrderDetailsDto;
import com.mayuktha.orders.entity.Order;

public interface OrdersService {
	
	void createOrder(OrderDetailsDto orderDetailsDto);
	public Optional<Order> fetchOrder(int orderId);

}
