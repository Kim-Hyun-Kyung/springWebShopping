package com.study.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.dto.Account;

@Mapper
public interface loginDao {

	public Account selectUser(@Param("id") String id);
	
	public void addUser(Account account);
	
	public void updatePw(@Param("id") String id,@Param("pw") String pw);
	
	public List<String> validationId(@Param("id")String id);
}
