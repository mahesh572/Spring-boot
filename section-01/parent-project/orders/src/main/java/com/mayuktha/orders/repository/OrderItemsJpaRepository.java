package com.mayuktha.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mayuktha.orders.entity.OrderItems;

@Repository
public interface OrderItemsJpaRepository extends JpaRepository<OrderItems, Integer>{

}
