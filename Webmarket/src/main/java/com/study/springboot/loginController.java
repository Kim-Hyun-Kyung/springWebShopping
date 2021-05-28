package com.study.springboot;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.dto.Account;
import com.study.springboot.service.loginService;

@Controller
public class loginController {
	@Resource
	loginService loginservice;
	@Resource
	Account account;
	@Resource
	PasswordEncoder passwordEncoder;
	@RequestMapping("/user/login")
	public String login() {
		System.out.println("로그인!!!~~");
		
		return "userlogin";
	}
	
	@RequestMapping("/security_check")
	public String login_check(Model model, HttpServletRequest request) {
		String id = request.getParameter("username");
		String pw = request.getParameter("password");		
		//입력받은 비밀번호 복호화 
		
		account = loginservice.selectUser(id);
		if(account.getId().equals(id)) {
			if(passwordEncoder.matches(id, pw)) {
				System.out.println("인증 성공!!!!");
				//권한 부여
				
			}
		}
		System.out.println(account.getId()+" id 조회 결과@~" +account.getPassword()+"pw조회 ");
		return "Welcome";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}
	
	@RequestMapping("/addMember")
	public String addMember(HttpServletRequest request) {
		
		return "addMember";
	}
	
	
	@RequestMapping("/processAddMember")
	public String processAddMember(Model model,HttpServletRequest request) {
		System.out.println("!!회원가입 프로세스 호출!!");
		
		account.setId(request.getParameter("id"));
		
		String pw = request.getParameter("password"); //단방향 암호화 
		account.setPassword(passwordEncoder.encode(pw));
		
		System.out.println(account.getPassword()+" 암호화 후 비밀번호" 
				+ pw +" 암호화 전 비밀번호");
			
		account.setName(request.getParameter("name"));
		
		account.setGrade(request.getParameter("grade"));
		
		String phone = request.getParameter("phone1")
				+request.getParameter("phone2")
				+request.getParameter("phone3");
		account.setPhone(phone);
		
		account.setAddress(request.getParameter("address"));
		
		int result = loginservice.addUser(account);
		String resultScript ="";
		System.out.println(result +" result");
		if(result==1) {
			resultScript="<script type='text/javascript'>alert('회원가입에 성공하셨습니다.');</script>";
			model.addAttribute("resultScript ",resultScript);
			return "Welcome";
		}else{
			resultScript="<script>alert('회원가입에 실패하셨습니다.');</script>";
			model.addAttribute("resultScript ",resultScript);
			return "forward:/addMember.do";
		}
	}
}
