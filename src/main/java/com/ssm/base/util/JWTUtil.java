package com.ssm.base.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;


public class JWTUtil {
 
	public static String SECRET = "SDFEEdfdeFDRE";
	
//	public static String createToken() throws Exception {
//		//签发时间
//		Date istDate = new Date();
//		
//		//设置过期时间
//		Calendar nowTime = Calendar.getInstance();
//		nowTime.add(Calendar.MINUTE, 1);
//		Date expiresDate = nowTime.getTime();
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("alg", "HS256");
//		map.put("typ", "JWT");
//		
//		String token = JWT.create()
//				.withHeader(map)
//				.withClaim("name", "test")
//				.withClaim("age", 11)
//				.withExpiresAt(expiresDate)
//				.withIssuedAt(istDate)
//				.sign(Algorithm.HMAC256(SECRET));
//		
//		return token;
//	}
//	
//	public static Map<String, Claim> verifyToken(String token) throws Exception{
//		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
//		DecodedJWT jwt = null;
//		try {
//			jwt = verifier.verify(token);
//		} catch (Exception e) {
//			throw new RuntimeException("凭证过期！");
//		}
//		
//		return jwt.getClaims();
//	}
	
//	public static void main(String[] args) throws Exception {
//		String token = JWTUtil.createToken();
//		
//		System.out.println(token);
//		//正常测试
//		Map<String, Claim> verifyToken = JWTUtil.verifyToken(token);
//		String asString = verifyToken.get("name").asString();
//		System.out.println(asString);
//		
//		//过期测试
//		token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoidGVzdCIsImV4cCI6MTUyNzQ5NzA3MiwiaWF0IjoxNTI3NDk3MDExLCJhZ2UiOjExfQ.yg1Hn4FT0OWu8KecNzvaayMEbbDrKctjWlI4bblcRfA";
//		Map<String, Claim> verifyToken2 = JWTUtil.verifyToken(token);
//	}
}
