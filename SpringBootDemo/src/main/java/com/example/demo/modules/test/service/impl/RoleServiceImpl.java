package com.example.demo.modules.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modules.account.entity.Role;
import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.common.vo.Result.ResultEnum;
import com.example.demo.modules.test.dao.RoleDao;
import com.example.demo.modules.test.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> getUsersByUserId(int roleId) {
		List<Role> roles = roleDao.getRoleByRoleId(roleId);
		return roles;
	}

	@Override
	public Result<Role> insertRole(Role role) {
		Result<Role> result = new Result<Role>(ResultEnum.SUCCESS.status,"Insert success.");
		try{
			roleDao.insertRole(role);
			result.setObject(role);
		}catch(Exception e){
			result.setStatus(ResultEnum.FAILD.status);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
	public Result<Role> updateRole(Role role) {
		Result<Role> result = new Result<Role>(ResultEnum.SUCCESS.status,"Update success.");
		
		roleDao.updateRole(role);
		result.setObject(role);
		
		return result;
	}

	@Override
	public Result<Object> deleteRole(int roleId) {
		Result<Object> result = new Result<Object>(ResultEnum.SUCCESS.status,"Delete success.");
		try{
			roleDao.deleteRole(roleId);
		}catch(Exception e){
			result.setStatus(ResultEnum.FAILD.status);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	

}
