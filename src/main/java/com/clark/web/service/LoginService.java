package com.clark.web.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bouncycastle.jcajce.provider.digest.Keccak.DigestKeccak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clark.web.CrytoSHA3;
import com.clark.web.dao.UserDao;
import com.clark.web.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoginService {
	
	@Autowired UserDao userDao;
	
	public Map<String, Object> doLogin(HttpServletRequest req, HttpServletResponse res, HttpSession session, Map<String, Object> param) throws IOException {
		CrytoSHA3 crytoSHA3 = new CrytoSHA3();
		Map<String, Object> returnParam = new HashMap<String, Object>();
		
		String pw = param.get("userPw").toString();
		
		//회원 정보 조회
		User userInfo = userDao.selectAuranceUser(param);
		if (userInfo == null) {
			returnParam.put("MSG", "There is no member information.\r\n Please check the ID");
			returnParam.put("cd", "0");
			
			return returnParam;
		}
		
		//비번 비교
		if (userInfo.getUserPw().equals(crytoSHA3.crytoSHA3(pw, 512))) {
			
			userInfo.setLastLoginDt(new Date()); //마지막 로그인 시간 넣고
			userInfo.setUserPw("");	 //세션에 비번은 버리고
			session.setAttribute("login", userInfo);
			 
			log.info("로그인 입력 : " + userInfo.toString());
			
			returnParam.put("MSG", "로그인성공");
			
			return returnParam;
		} else {
			returnParam.put("MSG", "Please contact your administrator");
		}
		
		
		return returnParam;
	}
	
}
