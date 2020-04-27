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
	
	@RequestMapping("/resources/{resourceId}")
	public List<Resource> getCitiesByCountryId(@PathVariable int resourceId){
		return resourceService.getUsersByResourceId(resourceId);
	}
	
	@PostMapping(value="/resource",consumes="application/json")
	public Result<Resource> insertResource(@RequestBody Resource resource){
		return resourceService.insertResource(resource);
	}
	
	@PutMapping(value="/resource",consumes="application/x-www-form-urlencoded")
	public Result<Resource> updateResource(@ModelAttribute Resource resource){
		return resourceService.updateResource(resource);
		
	}
	
	@DeleteMapping("/resource/{resourceId}")
	public Result<Object> deleteResource(@PathVariable int resourceId){
		return resourceService.deleteResource(resourceId);
	}
}
