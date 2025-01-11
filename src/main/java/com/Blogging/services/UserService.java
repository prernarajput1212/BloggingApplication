package com.Blogging.services;

import com.Blogging.Entity.User;
import com.Blogging.Payloads.UserDto;

import java.util.List;;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto userDto, Integer UserId);
	
	void deleteUser(Integer UserId);
	
	UserDto getUserById(Integer UserId);
	
	List<UserDto> getAllUsers();

}
