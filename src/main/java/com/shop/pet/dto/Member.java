package com.shop.pet.dto;

import java.util.Date;

//사용자 정보 저장
public class Member {
	
	private String email, pwd, name;
	private Date registDate;
	public Member(String email, String pwd, String name, Date registDate) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.registDate = registDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public Member() {
		super();
	}
	@Override
	public String toString() {
		return "Member [email=" + email + ", pwd=" + pwd + ", name=" + name + ", registDate=" + registDate + "]";
	}
}