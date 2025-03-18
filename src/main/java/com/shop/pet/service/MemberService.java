package com.shop.pet.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.pet.dao.LoginDao;
import com.shop.pet.dao.MemberDao;
import com.shop.pet.dto.Login;
import com.shop.pet.dto.Member;
import com.shop.pet.util.OpenCrypt;

//회원 관련 로직 처리

@Service
public class MemberService {
	@Autowired
	MemberDao memberDao; //회원 관련 DB 작업
	
	@Autowired
	LoginDao loginDao; //로그인 관련 DB 작업

	public Login checkToken(String authorization) throws Exception {
		 //토큰이 DB에 존재하는지 확인
		return loginDao.checkToken(authorization);
	}
	
	public Login tokenLogin(Member m) throws Exception {
		m = memberDao.login(m); //이메일, 비번 일치하는 회원 정보 조회
		if(m!=null) {
			String name = m.getName();
			if(name!=null && !name.trim().equals("")) {
				
				String email=m.getEmail();
				
				String salt=UUID.randomUUID().toString(); //난수 문자열 salt 생성
				System.out.println("salt:"+salt); //salt 확인

				byte[] originalHash=OpenCrypt.getSHA256(email, salt);
				String myToken=OpenCrypt.byteArrayToHex(originalHash);
				System.out.println("myToken : "+myToken);
				
				//로그인 정보 객체 생성
				Login loginInfo = new Login(email, myToken, name, new Date());
				loginDao.insertToken(loginInfo);
				return loginInfo;
			}
		}
		return null;		 
	}
	
	//로그인
	public Member login(Member m) throws Exception {
		return memberDao.login(m);
	}
	
	//회원가입
	public void insertMember(Member m) throws Exception{
		memberDao.insertMember(m);
	}
	
	//회원 정보 수정
	public void updateMember(Member m) throws Exception{
		memberDao.updateMember(m);
	}
	
	//회원 삭제
	public void deleteMember(String email) throws Exception{
		//System.out.println("실행");
		memberDao.deleteMember(email);
	}
	
	//로그아웃
	public void logout(String authorization) throws Exception {
		//토큰을 받아서 DB에서 해당 토큰 삭제
		loginDao.deleteToken(authorization);
	}

}