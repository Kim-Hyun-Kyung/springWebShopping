package com.study.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.dto.Account;

@Mapper
public interface AccountDao {
	public String selectUser (String id);
	
	public String selectAuthority (String id);
	
	public void addAccount(Account account);
	
	public void addAuthority(String id, String autority);
	
	public Account selectAll_User();
}
