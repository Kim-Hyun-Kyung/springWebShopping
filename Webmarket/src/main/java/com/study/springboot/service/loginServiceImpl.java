package com.study.springboot.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import com.study.springboot.dao.loginDao;
import com.study.springboot.dto.Account;

@Service
public class loginServiceImpl implements loginService{

	@Resource
	loginDao dao;
	@Resource
	Account account;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	@Override
	public Account selectUser(String id) {	
		account = dao.selectUser(id);
		return account;
	}

	@Override
	public int addUser(Account user) {
		try {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			
			dao.addUser(user);
			System.out.println("회원가입 성공.");
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

	@Override
	public boolean validationId(String id) {
		
		try {
				List <String> resultId = dao.validationId(id);
				System.out.println("ID 조회 성공");
			
				for(int i=0; i<resultId.size(); i++) {
					
					if(id.equals(resultId.get(i))){
						return false;
					}
					
				}
				return true;
		}catch(Exception e) {
			System.out.println("ID 조회에 실패하였습니다.");
			return false;
		}
	}
	

}
