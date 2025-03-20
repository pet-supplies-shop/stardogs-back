package com.shop.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.pet.dto.Pet;
import com.shop.pet.service.PetService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("http://127.0.0.1:5500/")
public class PetController {
	@Autowired
	PetService petService;
	
	@PostMapping("insertPet")
	public String insertPet(@RequestBody Pet p) {
		//System.out.println("petcontroller: "+p);
//		if(p==null) {
//			System.out.println("요청된 pet 객체 없음");
//		}
		try {
			//System.out.println("애견 클라이언트 요청: "+p);
			petService.insertPet(p);
			return p.getPetName() + " 정보 등록 완료";
		} catch (Exception e) {
			e.printStackTrace();
			return "애견 정보 등록 실패";
		}
	}
	
	
}
