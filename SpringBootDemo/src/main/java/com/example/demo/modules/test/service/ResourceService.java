package com.example.demo.modules.test.service;

import java.util.List;

import com.example.demo.modules.account.entity.Resource;
import com.example.demo.modules.common.vo.Result;

public interface ResourceService {


	List<Resource> getUsersByResourceId(int resourceId);
	
	Result<Resource> insertResource(Resource resource);
	
	Result<Resource> updateResource(Resource resource);
	
	Result<Object> deleteResource(int resourceId);
}
