package com.study.springboot.service;

import org.springframework.stereotype.Service;

import com.study.springboot.dto.UserDto;
@Service
public interface loginService {
	public UserDto  selectUser(String id);
	
	public int addUser(UserDto user);
	
	public void updatePw(String id,String pw);
}
