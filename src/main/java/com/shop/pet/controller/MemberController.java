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


@RestController //json 데이터 반환
@CrossOrigin("http://127.0.0.1:5500/") //CORS 요청 허용
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	//로그아웃
	@PostMapping("logout")
	public void logout(@RequestHeader String authorization) { //request 헤더로 들어옴
		System.out.println(authorization);
		try {
			//토큰 삭제
			memberService.logout(authorization);
			System.out.println("토큰 삭제");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//토큰 로그인
	@PostMapping("tokenLogin")
	public Map<String,String> tokenLogin(@RequestBody Member m) {
		//System.out.println(m);
		
		Map<String,String> responseMap = new HashMap<>();
		
		try { //loginInfo에 email, token, name 들어가 있음
			Login loginInfo = memberService.tokenLogin(m);
			
			//로그인 성공 시 이름, 토큰 반환
			if(loginInfo!=null && loginInfo.getName()!=null && loginInfo.getToken()!=null) {
				responseMap.put("name", loginInfo.getName());
				responseMap.put("Authorization", loginInfo.getToken());
			}else {
				responseMap.put("msg", "다시 로그인 해주세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseMap.put("msg", "exception!");
		}
		return responseMap;
	}
	
	//일반 로그인
	@PostMapping("login")
	public Map<String,String> login(@RequestBody Member m) {
		//System.out.println(m);
		
		Map<String,String> responseMap=new HashMap<>();
		
		try {
			m = memberService.login(m);
			String name = m.getName();
			
			//로그인 성공 시 이름 반환
			if(m!=null && name!=null && !name.trim().equals("")) {
				responseMap.put("name", name);
			}else {
				responseMap.put("msg", "다시 로그인 해주세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseMap.put("msg", "Exception!");
		}
		return responseMap;
	}
	
	//회원가입
	@PostMapping("insertMember")
	public String insertMember(@RequestBody Member m) {
		//System.out.println(m);
		
		try {
			memberService.insertMember(m);
			return m.getName()+"님 회원가입 되었습니다.";
		} catch (Exception e) {
			e.printStackTrace();
			return "회원 가입 실패";
		}
	}
	
	//회원 정보 수정
	@PostMapping("updateMember")
	public String updateMember(@RequestBody Member m) {
		System.out.println(m);
		try {
			memberService.updateMember(m);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "email과 pwd를 확인해 주세요";
		}
	}
	
	//회원 삭제
	@PostMapping("deleteMember")
	public String deleteMember(@RequestBody String email) {
		System.out.println("삭제 요청된 email" + email);
		try {
			memberService.deleteMember(email);
			return email + "회원 삭제됨";
		} catch (Exception e) {
			e.printStackTrace();
			return "email과 pwd를 확인해 주세요";
		}
	}
}