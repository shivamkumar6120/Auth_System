package com.substring.auth.auth_app_backend.services;

import java.util.List;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.substring.auth.auth_app_backend.dtos.UserDto;
import com.substring.auth.auth_app_backend.entities.Provider;
import com.substring.auth.auth_app_backend.entities.User;
import com.substring.auth.auth_app_backend.repositories.UserRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
//@Transactional
@RequiredArgsConstructor
//@AllArgsConstructor
public class UserServicesImpl implements UserServices {

	private final UserRepository userRepository;
	private final ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {

		if (userDto.getEmail() == null || userDto.getEmail().isBlank())
			throw new IllegalArgumentException("Email not found");
		if (userRepository.existsByEmail(userDto.getEmail()))
			throw new IllegalArgumentException("Email already exists");
//		can add some more checks

		User user = modelMapper.map(userDto, User.class);
		user.setProvider(userDto.getProvider() != null ? userDto.getProvider() : Provider.LOCAL);
//		role assign to new User
		
//		TODO
		
		User savedUser = userRepository.save(user);

		UserDto finalDto = modelMapper.map(savedUser, UserDto.class);

		return finalDto;
	}

	@Override
	public UserDto getUserByEamil(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto updateUser(UserDto userDto, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserDto getUserById(String uderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
	    return StreamSupport.stream(userRepository.findAll().spliterator(), false)
	            .map(user -> modelMapper.map(user, UserDto.class))
	            .toList();		
	}

}
