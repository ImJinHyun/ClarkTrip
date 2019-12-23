package com.clark.web.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clark.web.model.User;

@Repository
public class MemberDao {

	@Autowired SqlSessionTemplate sessionTemplate;
	
	public int joinProcess(User user) {
		return sessionTemplate.insert("member.joinProcess", user);
	}

	public int idCheck(Map<String, Object> param) {
		return sessionTemplate.selectOne("member.idCheck", param);
	}

	public int telCheck(Map<String, Object> param) {
		return sessionTemplate.selectOne("member.telCheck", param);
				
	}

}
