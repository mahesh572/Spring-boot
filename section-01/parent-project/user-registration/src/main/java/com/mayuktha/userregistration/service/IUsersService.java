package com.mayuktha.userregistration.service;

import java.util.List;

import com.mayuktha.userregistration.dto.UserDto;

public interface IUsersService {
	void createUser(UserDto userDto);
	List<UserDto> fetchAllUsers();
	void deleteUser(int id);
	boolean updateUser(UserDto userDto);
}
