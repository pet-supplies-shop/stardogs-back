package com.shop.pet.dto;

import java.util.Date;

//로그인 정보 저장
public class Login {
	
	private String email, token, name;
	private Date loginTime;
	
	public Login(String email, String token, String name, Date loginTime) {
		super();
		this.email = email;
		this.token = token;
		this.name = name;
		this.loginTime = loginTime;
	}

	public Login() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	@Override
	public String toString() {
		return "Login [email=" + email + ", token=" + token + ", name=" + name + ", loginTime=" + loginTime
				+ "]";
	}
}
