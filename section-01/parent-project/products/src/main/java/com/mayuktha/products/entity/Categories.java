package com.mayuktha.products.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categories")
@Setter @Getter @ToString @AllArgsConstructor @NoArgsConstructor
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "category_name")
	private String categoryname;
	@Column(name = "description")
	private String description;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	@Column(name = "modified_at")
	private LocalDateTime modifiedAt;
	@Column(name = "deleted_at")
	private LocalDateTime deletedAt;
	
	

}
