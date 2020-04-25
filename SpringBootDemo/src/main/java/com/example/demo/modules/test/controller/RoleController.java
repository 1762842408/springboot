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

import com.example.demo.modules.account.entity.Role;
import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.test.service.RoleService;


@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/roles/{roleId}")
	public List<Role> getCitiesByCountryId(@PathVariable int roleId){
		return roleService.getUsersByUserId(roleId);
	}
	
	@PostMapping(value="/role",consumes="application/json")
	public Result<Role> insertCity(@RequestBody Role role){
		return roleService.insertRole(role);
	}
	
	@PutMapping(value="/role",consumes="application/x-www-form-urlencoded")
	public Result<Role> updateRole(@ModelAttribute Role role){
		return roleService.updateRole(role);
		
	}
	
	@DeleteMapping("/role/{roleId}")
	public Result<Object> deleteCity(@PathVariable int roleId){
		return roleService.deleteRole(roleId);
	}
	
}
