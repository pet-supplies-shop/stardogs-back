package com.shop.pet.util;

import java.util.Base64;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenProvider {
	private static String salt = Base64.getEncoder().encodeToString("솔트".getBytes());

	//JWT 생성
	public static String createToken(String data) {
		Claims claims = Jwts.claims(); //객체 생성
		claims.put("name", data); //토큰 내부에 name이라는 키에 data 값을 저장

		Date now = new Date(); //현재 시간 저장
		System.out.println(now);

		return Jwts.builder()
				.setHeaderParam(Header.TYPE, Header.JWT_TYPE) //헤더를 JWT 타입으로 설정
				.setClaims(claims) //내용부 설정
				.setIssuedAt(now) //현재 시간을 발급 시간으로 설정
				.setExpiration(new Date(now.getTime() + (1000L * 60 * 30))) //만료 시간 30분으로 설정
				.signWith(SignatureAlgorithm.HS256, salt) //salt키를 이용하여 토큰 위조, 변조 확인
				.compact(); //최종 JWT 문자열 생성하여 반환
	}

	//토큰 유효성 검사
	public static boolean validateToken(String jwtToken) {
	    return !getInformation(jwtToken).getExpiration() //토큰 만료 시간을 가져옴
	    		.before(new Date());//만료시간이 지났으면 true 이므로 !을 붙여야함
	}

	//토큰 정보 추출
	public static Claims getInformation(String jwtToken) {
		return Jwts.parser()
				.setSigningKey(salt) //저장된 salt 키로 JWT 서명 검증
				.parseClaimsJws(jwtToken) //JWT 해석 및 검증
				.getBody(); //내용부 데이터 가져옴
	}
}
