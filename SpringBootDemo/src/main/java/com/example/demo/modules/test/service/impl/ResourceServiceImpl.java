package com.example.demo.modules.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modules.account.entity.Resource;
import com.example.demo.modules.account.entity.Role;
import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.common.vo.Result.ResultEnum;
import com.example.demo.modules.test.dao.ResourceDao;
import com.example.demo.modules.test.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService{

	@Autowired
	private ResourceDao resourceDao;
	
	@Override
	public List<Resource> getUsersByResourceId(int resourceId) {
		List<Resource> resource = resourceDao.getResourceByResourceId(resourceId);
		return resource;
	}

	@Override
	public Result<Resource> insertResource(Resource resource) {
		Result<Resource> result = new Result<Resource>(ResultEnum.SUCCESS.status,"Insert success.");
		try{
			resourceDao.insertResource(resource);
			result.setObject(resource);
		}catch(Exception e){
			result.setStatus(ResultEnum.FAILD.status);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
	public Result<Resource> updateResource(Resource resource) {
		Result<Resource> result = new Result<Resource>(ResultEnum.SUCCESS.status,"Update success.");
		
		resourceDao.updateResource(resource);
		result.setObject(resource);
		
		return result;
	}

	@Override
	public Result<Object> deleteResource(int resourceId) {
		Result<Object> result = new Result<Object>(ResultEnum.SUCCESS.status,"Delete success.");
		try{
			resourceDao.deleteResource(resourceId);
		}catch(Exception e){
			result.setStatus(ResultEnum.FAILD.status);
			result.setMessage(e.getMessage());
		}
		return result;
	}

}
