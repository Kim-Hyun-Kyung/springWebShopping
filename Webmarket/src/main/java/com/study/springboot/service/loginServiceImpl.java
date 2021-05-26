package com.study.springboot.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.study.springboot.dao.loginDao;
import com.study.springboot.dto.UserDto;

@Service
public class loginServiceImpl implements loginService{

	@Resource
	loginDao dao;
	@Resource
	UserDto dto;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	@Override
	public UserDto selectUser(String id) {	
		dto = dao.selectUser(id);
		return dto;
	}

	@Override
	public int addUser(UserDto user) {
		try {
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {

				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					dao.addUser(user);
				}
			});
			System.out.println("회원가입 성공!");
			return 1;			
		}catch(Exception e){
			System.out.println("회원가입에 실패하였습니다.");
			return 0;
		}
	}

	@Override
	public void updatePw(String id,String pw) {
		dao.updatePw(id,pw);		
	}
	

}
