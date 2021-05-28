package com.study.springboot.service;

import org.springframework.stereotype.Service;

import com.study.springboot.dto.Account;
@Service
public interface loginService {
	public Account  selectUser(String id);
	
	public int addUser(Account user);
	
	public void updatePw(String id,String pw);
	
	public boolean validationId(String id);
}
