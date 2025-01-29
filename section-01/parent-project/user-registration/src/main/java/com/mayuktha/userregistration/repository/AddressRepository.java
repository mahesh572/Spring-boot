package com.mayuktha.userregistration.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mayuktha.userregistration.entity.Address;
import java.util.List;


public interface AddressRepository extends JpaRepository<Address, Integer>{

	List<Address> findByMobile(String mobile);
	
}
