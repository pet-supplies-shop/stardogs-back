package com.shop.pet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shop.pet.dto.Infor;

//MyBatis 매핑
@Mapper
public interface InforDao {
	//로그인된 이메일에 저장된 펫 데이터 가져옴
	List<Infor> getAllInfor(String email);
}
