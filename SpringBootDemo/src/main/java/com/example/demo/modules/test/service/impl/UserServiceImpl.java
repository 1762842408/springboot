package com.example.demo.modules.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modules.account.entity.User;
import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.common.vo.Result.ResultEnum;
import com.example.demo.modules.test.dao.CityDao;
import com.example.demo.modules.test.dao.UserDao;
import com.example.demo.modules.test.entity.City;
import com.example.demo.modules.test.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUsersByUserId(int userId) {
		List<User> users = userDao.getUsersByUserId(userId);
		return users;
	}

	@Override
	public Result<User> insertUser(User user) {
		Result<User> result = new Result<User>(ResultEnum.SUCCESS.status,"Insert success.");
		try{
			userDao.insertUser(user);
			result.setObject(user);
		}catch(Exception e){
			result.setStatus(ResultEnum.FAILD.status);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
	public Result<User> updateUser(User user) {
		
		Result<User> result = new Result<User>(ResultEnum.SUCCESS.status,"Update success.");
		
		userDao.updateUser(user);
		result.setObject(user);
		
		return result;
	}

	@Override
	public Result<Object> deleteUser(int userId) {
		Result<Object> result = new Result<Object>(ResultEnum.SUCCESS.status,"Delete success.");
		try{
			userDao.deleteUser(userId);;
		}catch(Exception e){
			result.setStatus(ResultEnum.FAILD.status);
			result.setMessage(e.getMessage());
		}
		return result;

	}


	
	

}
