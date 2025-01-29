package com.mayuktha.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mayuktha.feign.client.ProductsFeignClient;
import com.mayuktha.orders.dto.OrderDetailsDto;
import com.mayuktha.orders.dto.OrderItemsDto;
import com.mayuktha.orders.entity.Order;
import com.mayuktha.orders.entity.OrderItems;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
public class MapperUtil {
	
	private static final Logger log = LoggerFactory.getLogger(MapperUtil.class);
	
	private final ProductsFeignClient productsFeignClient;
	
	public static Order mapToOrder(OrderDetailsDto orderDetailsDto,Order order) {
		
		order.setStatus("CREATED");
		order.setTotalPrice(orderDetailsDto.getTotal());
		order.setUserId(orderDetailsDto.getUserId());
		order.setCreatedAt(LocalDateTime.now());
		return order;
	}
	public static List<OrderItems> mapToOrderItems(OrderDetailsDto orderDetailsDto) {
		List<OrderItems> OrderItemsList = new ArrayList<OrderItems>();
		if(null!=orderDetailsDto.getOrderItems() && orderDetailsDto.getOrderItems().size()>0) {
			orderDetailsDto.getOrderItems().stream().forEach(item->{
				OrderItems orderItems = new OrderItems();
				orderItems.setOrderId(orderDetailsDto.getOrderId());
				//orderItems.setProductId(item.getProductId());
				orderItems.setCreatedAt(LocalDateTime.now());
				orderItems.setQuantity(item.getQuantity());
				orderItems.setPrice(item.getPrice());
				OrderItemsList.add(orderItems);
			});
			
		}
		return OrderItemsList;
	}
	
	public static OrderDetailsDto mapToOrderDetialsDto(Order order,OrderDetailsDto orderDetailsDto) {
		orderDetailsDto.setOrderId(order.getId());
		orderDetailsDto.setStatus(order.getStatus());
		orderDetailsDto.setUserId(order.getUserId());
		orderDetailsDto.setTotal(order.getTotalPrice());
		return orderDetailsDto;
	}
	
}
