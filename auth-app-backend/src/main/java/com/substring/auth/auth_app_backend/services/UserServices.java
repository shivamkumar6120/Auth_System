package com.substring.auth.auth_app_backend.services;

import java.util.List;

import com.substring.auth.auth_app_backend.dtos.UserDto;

public interface UserServices {
	
//	create user
	UserDto createUser (UserDto userDto);
	
//	get user by email 
	UserDto getUserByEamil(String email);
	
//	update user
	UserDto updateUser(UserDto userDto, String userId);
	
//	delete user
	void deleteUser(String userId);
	
//	get user by id
	UserDto getUserById(String uderId);
	
//	get all user
	List<UserDto> getAllUsers();

}
