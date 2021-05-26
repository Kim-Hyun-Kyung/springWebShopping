package com.study.springboot.dto;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDto {
	
	private String id ="";
	private String pw ="";
	private String name ="";
	private String junum ="";
	private String grade ="Role_basic";
	private String email ="";
	private String phone ="";
	private String address ="";
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJunum() {
		return junum;
	}

	public void setJunum(String junum) {
		this.junum = junum;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserDto() {
		super();
	}

	public UserDto(String id, String pw, String name, String junum, String email, String phone, String address,
			String grade) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.junum = junum;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.grade = grade;
	}

	

	
	
	
}
