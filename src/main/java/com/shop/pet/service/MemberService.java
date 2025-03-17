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

@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	LoginDao loginDao;

	public Login checkToken(String authorization) throws Exception {
		return loginDao.checkToken(authorization);
	}
	
	public Login tokenLogin(Member m) throws Exception {
		m = memberDao.login(m);
		if(m!=null) {
			String name=m.getName();
			if(name!=null && !name.trim().equals("")) {
				
				String email=m.getEmail();
				
				String salt=UUID.randomUUID().toString();
				System.out.println("salt:"+salt);

				byte[] originalHash=OpenCrypt.getSHA256(email, salt);
				String myToken=OpenCrypt.byteArrayToHex(originalHash);
				System.out.println("myToken : "+myToken);
				
				Login loginInfo=new Login(email, myToken, name, new Date());
				loginDao.insertToken(loginInfo);
				return loginInfo;
			}
		}
		
		return null;		 
	}
	
	public Member login(Member m) throws Exception {
		return memberDao.login(m);
	}
	
	public void insertMember(Member m) throws Exception{
		memberDao.insertMember(m);
	}
	
	public void updateMember(Member m) throws Exception{
		memberDao.updateMember(m);
	}
	
	public void deleteMember(String email) throws Exception{
		memberDao.deleteMember(email);
	}
	
	public void logout(String authorization) throws Exception {
		loginDao.deleteToken(authorization);
		
	}

}