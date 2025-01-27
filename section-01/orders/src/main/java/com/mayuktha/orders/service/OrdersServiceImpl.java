package com.mayuktha.orders.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayuktha.mapper.MapperUtil;
import com.mayuktha.orders.dto.OrderDetailsDto;
import com.mayuktha.orders.entity.Order;
import com.mayuktha.orders.entity.OrderItems;
import com.mayuktha.orders.repository.OrderItemsJpaRepository;
import com.mayuktha.orders.repository.OrderJpaRepository;

import jakarta.transaction.Transactional;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	OrderJpaRepository orderJpaRepository;
	
	@Autowired
	OrderItemsJpaRepository orderItemsJpaRepository;
	
	@Transactional
	public void createOrder(OrderDetailsDto orderDetailsDto) {
		Order order=MapperUtil.mapToOrder(orderDetailsDto, new Order());
		order=orderJpaRepository.save(order);
		if(null!=order) {
			orderDetailsDto.setOrderId(order.getId());
			List<OrderItems> orederItemsList = MapperUtil.mapToOrderItems(orderDetailsDto);
			orderItemsJpaRepository.saveAll(orederItemsList);
		}
	}
	
	public Optional<Order> fetchOrder(int orderId) {
		return orderJpaRepository.findById(orderId);
	}
}
