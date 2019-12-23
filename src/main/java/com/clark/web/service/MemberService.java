package com.clark.web.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clark.web.dao.MemberDao;
import com.clark.web.model.User;

@Service
public class MemberService {
	
	@Autowired MemberDao memberDao;
	
	public int joinProcess(User user) {
		return memberDao.joinProcess(user);
	}
	
	public int idCheck(Map<String, Object> param) {
		return memberDao.idCheck(param);
	}

	public int telCheck(Map<String, Object> param) {
		return memberDao.telCheck(param);
	}
}
