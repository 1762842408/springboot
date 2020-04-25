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

import com.example.demo.modules.account.entity.Resource;
import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.test.service.ResourceService;


@RestController
@RequestMapping("/api")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/roles/{roleId}")
	public List<Resource> getCitiesByCountryId(@PathVariable int resourceId){
		return resourceService.getUsersByResourceId(resourceId);
	}
	
	@PostMapping(value="/role",consumes="application/json")
	public Result<Resource> insertResource(@RequestBody Resource resource){
		return resourceService.insertResource(resource);
	}
	
	@PutMapping(value="/role",consumes="application/x-www-form-urlencoded")
	public Result<Resource> updateRole(@ModelAttribute Resource resource){
		return resourceService.updateResource(resource);
		
	}
	
	@DeleteMapping("/role/{roleId}")
	public Result<Object> deleteCity(@PathVariable int resourceId){
		return resourceService.deleteResource(resourceId);
	}
}
