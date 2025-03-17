package com.shop.pet.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shop.pet.dto.Login;

@Mapper
public interface LoginDao {
	public void insertToken(Login login) throws Exception;

	public void deleteToken(String token) throws Exception;
	
	public Login checkToken(String authorization) throws Exception;
}