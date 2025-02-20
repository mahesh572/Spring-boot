package com.mayuktha.products.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sub_categories")
@Setter @Getter @ToString @AllArgsConstructor @NoArgsConstructor
public class SubCategories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "sub_category_name")
	private String subcategoryname;
	
	private String description;
	
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	@Column(name = "modified_at")
	private LocalDateTime modifiedAt;
	@Column(name = "deleted_at")
	private LocalDateTime deletedAt;
	
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "parent_category_id")
	private int parentCategoryId;
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "category_id",referencedColumnName = "id") private
	 * Categories categories;
	 */
}
