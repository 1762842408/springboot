package com.example.demo.modules.test.service;

import java.util.List;

import com.example.demo.modules.account.entity.Role;
import com.example.demo.modules.common.vo.Result;

public interface RoleService {

	List<Role> getUsersByUserId(int roleId);
	
	Result<Role> insertRole(Role role);
	
	Result<Role> updateRole(Role role);
	
	Result<Object> deleteRole(int roleId);
}
