package com.example.demo.modules.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.modules.account.entity.Resource;


@Mapper
public interface ResourceDao {


	@Select("select * from resource where resource_id = #{resourceId}")
	List<Resource> getResourceByResourceId(int resourceId);
	
	@Insert("insert into resource (resource_uri,resource_name,permission)"
			+"values (#{resourceUri},#{resourceName},#{permission})")
	@Options(useGeneratedKeys=true,keyColumn="resource_id",keyProperty="resourceId")
	void insertResource(Resource resource);
	
	@Update("update resource set resource_name = #{resourceName} where resource_id = #{resourceId}")
	void updateResource(Resource resource);
	
	@Delete("delete from user where resource_id = #{resourceId}")
	void deleteResource(int resourceId);
}
