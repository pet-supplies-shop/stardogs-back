package com.shop.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.pet.dto.Infor;
import com.shop.pet.service.InforService;

@RestController
@RequestMapping("/infor")
@CrossOrigin("http://127.0.0.1:5500/")
//    http://localhost:8080/infor/getAllInfor/{email}
public class InforController {
	@Autowired
	private InforService inforService;
	
	@GetMapping("/getAllInfor/{email}")
	public List<Infor> getAllInfor(@PathVariable String email){
		return inforService.getAllInfor(email);
	}
}
