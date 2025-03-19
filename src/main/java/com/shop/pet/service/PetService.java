package com.shop.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.pet.dao.PetDao;
import com.shop.pet.dto.Pet;

@Service
public class PetService {
	@Autowired
	PetDao petDao;
	public void insertPet(Pet p) throws Exception{
		//System.out.println("애견 입력 데이터 : "+p);
		petDao.insertPet(p);
	}
}
