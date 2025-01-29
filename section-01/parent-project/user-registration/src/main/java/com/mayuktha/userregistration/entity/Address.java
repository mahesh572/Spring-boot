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

@Entity
@Table(name = "user_address")
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="address_line1")
	private String addressLine1;
	@Column(name="address_line2")
	private String addressLine2;
	@Column(name="city")
	private String city;
	@Column(name="postal_code")
	private String postalCode;
	@Column(name="country")
	private String country;
	@Column(name="mobile")
	private String mobile;
	
	
}
