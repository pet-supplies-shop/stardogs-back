package com.shop.pet.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.shop.pet.dto.Login;
import com.shop.pet.dto.Member;
import com.shop.pet.service.MemberService;


@RestController
@CrossOrigin("http://127.0.0.1:5500/")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@PostMapping("logout")
	public void logout(@RequestHeader String authorization) { //request 헤더로 들어옴
		System.out.println(authorization);
		try {
			memberService.logout(authorization);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PostMapping("tokenLogin")
	public Map<String,String> tokenLogin(@RequestBody Member m) {
		System.out.println(m);
		
		Map<String,String> responseMap=new HashMap<>();
		
		try { //loginInfo에 email, token, name 들어가 있음
			Login loginInfo = memberService.tokenLogin(m);
			
			if(loginInfo!=null && loginInfo.getName()!=null && loginInfo.getToken()!=null) {
				responseMap.put("name", loginInfo.getName());
				responseMap.put("Authorization", loginInfo.getToken());
			}else {
				responseMap.put("msg", "다시 로그인 해주세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseMap.put("msg", "다시 로그인 해주세요");
		}
		return responseMap;
	}
	
	@PostMapping("login")
	public Map<String,String> login(@RequestBody Member m) {
		System.out.println(m);
		
		Map<String,String> responseMap=new HashMap<>();
		
		try {
			m=memberService.login(m);
			String name=m.getName();
			if(m!=null && name!=null && !name.trim().equals("")) {
				responseMap.put("name", name);
			}else {
				responseMap.put("msg", "다시 로그인 해주세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseMap.put("msg", "다시 로그인 해주세요");
		}
		return responseMap;
	}
	
	@PostMapping("insertMember")
	public String insertMember(@RequestBody Member m) {
		System.out.println(m);
		try {
			memberService.insertMember(m);
			return m.getName()+"님 가입을 환영합니다";
		} catch (Exception e) {
			e.printStackTrace();
			return "회원 가입 실패";
		}
	}
	
	@PostMapping("updateMember")
	public String updateMember(@RequestBody Member m) {
		System.out.println(m);
		try {
			memberService.updateMember(m);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "email과 pwd 확인해 주세요";
		}
	}
	
	@PostMapping("deleteMember")
	public String deleteMember(@RequestBody String email) {
		System.out.println(email);
		try {
			memberService.deleteMember(email);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "email과 pwd 확인해 주세요";
		}
	}

}