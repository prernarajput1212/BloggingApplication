package com.Blogging.services.Impl;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blogging.Entity.User;
import com.Blogging.Exceptions.ResourceNotFoundException;
import com.Blogging.Payloads.UserDto;
import com.Blogging.Respositories.UserRepo;
import com.Blogging.services.UserService;
import com.Blogging.Entity.*;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		// create user
		User user=this.dtoToUser(userDto);
		User savedUser=this.userRepo.save(user);
				
		return this.UserToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer UserId) {
		// upadting the values of user
		
		User user= this.userRepo.findById(UserId).orElseThrow(()->new ResourceNotFoundException("User","UserId",UserId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser=this.userRepo.save(user);
		return this.UserToDto(updatedUser);
	
	}

	@Override
	public void deleteUser(Integer UserId) {
		// Deleting the user
User user= this.userRepo.findById(UserId).orElseThrow(()->new ResourceNotFoundException("User","UserId",UserId));
		
		this.userRepo.delete(user);
	}

	@Override
	public UserDto getUserById(Integer UserId) {
		// Getting the user on the bases of id
		User user= this.userRepo.findById(UserId).orElseThrow(()->new ResourceNotFoundException("User","UserId",UserId));
		
		return this.UserToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// Getting All the user
List<User>users=this.userRepo.findAll();
List<UserDto>userDto= users.stream().map(user->this.UserToDto(user)).collect(Collectors.toList());
		return userDto ;
	}
	
	public User dtoToUser(UserDto userDto) 
	{
		User user=new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		return user;
	}
	public UserDto UserToDto(User user)
	{
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setName(user.getName());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());
		return userDto;
	}
	
	

}
