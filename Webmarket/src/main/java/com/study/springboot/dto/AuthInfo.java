package com.study.springboot.dto;

import org.springframework.context.annotation.Configuration;
@Configuration
public class AuthInfo {

	private String id=""; 
	private String name="ROLE_USER";
	
	public AuthInfo() {
		super();
	}
	public AuthInfo(String id, String name ) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
