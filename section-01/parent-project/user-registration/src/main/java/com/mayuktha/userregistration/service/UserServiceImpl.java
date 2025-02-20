package com.mayuktha.userregistration.service;


import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mayuktha.controller.UserRegistrationController;
import com.mayuktha.userregistration.dto.UserDto;
import com.mayuktha.userregistration.entity.Address;
import com.mayuktha.userregistration.entity.User;
import com.mayuktha.userregistration.exception.ResourceNotFoundException;
import com.mayuktha.userregistration.exception.UserAlreadyExistedException;
import com.mayuktha.userregistration.exception.UserNotFoundException;
import com.mayuktha.userregistration.mapper.AddressMapper;
import com.mayuktha.userregistration.mapper.UserMapper;
import com.mayuktha.userregistration.repository.AddressRepository;
import com.mayuktha.userregistration.repository.UserRepository;

@Service
public class UserServiceImpl implements IUsersService{

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	
	@Override
	public void createUser(UserDto userDto) {
		List<User> savedUserList=userRepository.findByEmailAddress(userDto.getEmailAddress());
		if(null!=savedUserList && savedUserList.size()>0) {
			throw new UserAlreadyExistedException("User is Already Existed with :"+userDto.getEmailAddress());
		}else {
			List<Address> addressList = addressRepository.findByMobile(userDto.getAddress().getMobile());
			if(null!=addressList && addressList.size()>0) {
				throw new UserAlreadyExistedException("User is Already Existed with :"+userDto.getAddress().getMobile());
			}
		}
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(); 
		User user=UserMapper.mapToUser(userDto, new User());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Address address = AddressMapper.mapToAddress(userDto.getAddress(), new Address());
		addressRepository.save(address);
		user.setAddress(address);
		User userObj=userRepository.save(user);
		
	}
	
	public List<UserDto> fetchAllUsers() {
		List<User> userList=userRepository.findAll();
		log.debug("userList:::{}",userList.size());
		List<UserDto> userDtoList = null;
		if(userList!=null && userList.size()>0) {
			userDtoList=userList.stream().map(user->UserMapper.mapToUserDto(user, new UserDto())).collect(Collectors.toList());
		}else {
			log.debug("userList:::EMPTY");
			throw new UserNotFoundException("Users are not Available");
		}
		return userDtoList;
	}

	@Override
	public void deleteUser(int id) {
		User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User with ID: "+ id +" is Not existed"));
		userRepository.delete(user);
	}
	@Override
	public boolean updateUser(UserDto userDto) {
		boolean isUpdated = false;
		User user = userRepository.findById(userDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "UserId", String.valueOf(userDto.getId()))
        );
		
	UserMapper.mapToUser(userDto, user);
	userRepository.save(user);
	isUpdated = true;
	 return isUpdated;
	}
}
