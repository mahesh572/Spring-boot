package com.mayuktha.products.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_inventory")
public class ProductInventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "product_id")
	private int productId;
	
	private int quantity;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	@Column(name = "modified_at")
	private LocalDateTime modifiedAt;
	@Column(name = "deleted_at")
	private LocalDateTime deletedAt;

}
