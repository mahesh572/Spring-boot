package com.mayuktha.orders.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mayuktha.feign.client.ProductsFeignClient;
import com.mayuktha.mapper.MapperUtil;
import com.mayuktha.orders.dto.OrderDetailsDto;
import com.mayuktha.orders.dto.ProductsDto;
import com.mayuktha.orders.entity.Order;
import com.mayuktha.orders.entity.OrderItems;
import com.mayuktha.orders.exception.ResourceNotFoundException;
import com.mayuktha.orders.repository.OrderItemsJpaRepository;
import com.mayuktha.orders.repository.OrderJpaRepository;
import com.mayuktha.orders.response.ApiResponse;

import jakarta.transaction.Transactional;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	private static final Logger log = LoggerFactory.getLogger(OrdersServiceImpl.class);
	
	@Autowired
	OrderJpaRepository orderJpaRepository;
	
	@Autowired
	OrderItemsJpaRepository orderItemsJpaRepository;
	
	@Autowired
	ProductsFeignClient productsFeignClient;
	
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

	
	public  OrderDetailsDto fetchOrder(int orderId) {
		log.debug("OrdersServiceImpl::::fetchOrder::{}",orderId);
		Order order = orderJpaRepository.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("Order", "OrderId", String.valueOf(orderId)));
		OrderDetailsDto orderDetailsDto = MapperUtil.mapToOrderDetialsDto(order, new OrderDetailsDto());
		Optional<OrderItems> orderItems = orderItemsJpaRepository.findById(order.getId());
		List<ProductsDto> productsDtoList = new ArrayList<>();
		orderItems.stream().forEach(item->{
			ResponseEntity<com.mayuktha.orders.response.ApiResponse<com.mayuktha.orders.dto.ProductsDto>> apiresponseEntity = productsFeignClient.fetchProducts(1);
			 ProductsDto productsDto = apiresponseEntity.getBody().getData();
			 productsDtoList.add(productsDto);
			// log.debug("OrdersServiceImpl:::fetchOrder::::"+apiresponseEntity);
			// log.debug("OrdersServiceImpl:::::fetchOrder:::"+apiresponseEntity.getBody());
		});
		orderDetailsDto.setOrderItems(productsDtoList);
		
		return orderDetailsDto; 
	}
	
}
