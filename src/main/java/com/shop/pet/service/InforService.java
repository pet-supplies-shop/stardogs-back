package com.shop.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.pet.dao.InforDao;
import com.shop.pet.dto.Infor;

@Service
public class InforService {
	@Autowired
	private InforDao inforDao;
	
	public List<Infor> getAllInfor(String email){
		return inforDao.getAllInfor(email);
	}
}
