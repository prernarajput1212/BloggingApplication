package com.Blogging.controllers;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blogging.Payloads.UserDto;
import com.Blogging.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
@Autowired
private UserService userService;
	
	//post->ccreate user
@PostMapping("/create")	
public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
{
	UserDto createdUserDto= this.userService.createUser(userDto);
	return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);
	
}
	//put-> update user

@PutMapping("/{userId}")
public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userId") Integer uid)
{
	UserDto updatedUser =this.userService.updateUser(userDto, uid);
	return new ResponseEntity<UserDto>(updatedUser,HttpStatus.OK);
}
	//Delete user
@DeleteMapping("/{userId}")
public void deleteUser(@PathVariable ("userId") Integer uid)
{
	this.userService.deleteUser(uid);
	//return new ResponseEntity(Map.of("message", "User Successfully Deleted"),HttpStatus.OK);
}
	//get all users
@GetMapping("/AllUser")
		public ResponseEntity<List<UserDto>> getAllUsers(){
	return ResponseEntity.ok(this.userService.getAllUsers()) ;
	
}
//get single users
@GetMapping("/{userId}")
		public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
	
	return ResponseEntity.ok(this.userService.getUserById(userId)) ;
}
	

}
