package com.clark.web.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clark.web.model.User;

@Repository
public class UserDao {
	
	@Autowired SqlSessionTemplate sessionTemplate;
	
	public User selectAuranceUser(Map<String, Object> param) {
		return sessionTemplate.selectOne("user.selectAuranceUser", param);
	}
	
	public void updateAuranceLogin(User user) {
		sessionTemplate.update("user.updateAuranceLogin", user);
	}
}
