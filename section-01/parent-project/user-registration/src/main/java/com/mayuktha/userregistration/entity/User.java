package com.mayuktha.userregistration.entity;

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



@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="telephone")
	private String telephone;
	@Column(name="created_at")
	private LocalDateTime createdAt;
	@Column(name="modified_at")
	private LocalDateTime modifiedAt;
	@Column(name = "email_address")
	private String emailAddress;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id",referencedColumnName = "id")
	private Address address;
}
