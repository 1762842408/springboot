package com.example.demo.modules.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modules.account.entity.User;
import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.test.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users/{userId}")
	public List<User> getCitiesByCountryId(@PathVariable int userId){
		return userService.getUsersByUserId(userId);
	}
	
	@PostMapping(value="/user",consumes="application/json")
	public Result<User> insertCity(@RequestBody User user){
		return userService.insertUser(user);
	}
	
	@PutMapping(value="/user",consumes="application/x-www-form-urlencoded")
	public Result<User> updateCity(@ModelAttribute User user){
		return userService.updateUser(user);
		
	}
	
	@DeleteMapping("/user/{userId}")
	public Result<Object> deleteCity(@PathVariable int userId){
		return userService.deleteUser(userId);
	}
	
}
