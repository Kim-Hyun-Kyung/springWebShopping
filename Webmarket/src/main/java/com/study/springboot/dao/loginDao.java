package com.study.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.dto.UserDto;

@Mapper
public interface loginDao {

	public UserDto selectUser(@Param("id") String id);
	
	public void addUser(UserDto user);
	
	public void updatePw(@Param("id") String id,@Param("pw") String pw);
	
}
