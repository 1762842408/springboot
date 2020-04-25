package com.example.demo.modules.test.service;

import java.util.List;

import com.example.demo.modules.account.entity.User;
import com.example.demo.modules.common.vo.Result;


public interface UserService {

	List<User> getUsersByUserId(int userId);
	
	Result<User> insertUser(User user);
	
	Result<User> updateUser(User user);
	
	Result<Object> deleteUser(int cityId);
}
