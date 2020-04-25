package com.example.demo.modules.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.modules.account.entity.User;


@Mapper
public interface UserDao {
	
	@Select("select * from user where user_id = #{userId}")
	List<User> getUsersByUserId(int userId);
	
	@Insert("insert into user (user_name,password,create_date)"
			+"values (#{userName},#{password},#{createDate})")
	@Options(useGeneratedKeys=true,keyColumn="user_id",keyProperty="userId")
	void insertUser(User user);
	
	@Update("update user set user_name = #{userName} where user_id = #{userId}")
	void updateUser(User user);
	
	@Delete("delete from user where user_id = #{userId}")
	void deleteUser(int userId);
}
