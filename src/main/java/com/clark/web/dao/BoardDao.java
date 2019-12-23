package com.clark.web.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clark.web.model.BoardModel;

@Repository
public class BoardDao {
	
	@Autowired SqlSessionTemplate sessionTemplate;
	
	public List<Map<String, Object>> selectBoard() {
		return sessionTemplate.selectList("boardTest.getDual");
		
	}

	public int insertBoard(BoardModel boardTest) {
		return sessionTemplate.insert("boardTest.insertBoard", boardTest);		
		
	}

	public Map<String, Object> selectViewTest(String subject) {
		return sessionTemplate.selectOne("boardTest.selectViewTest", subject);
	}

	public BoardModel introduce(BoardModel board) {
		return sessionTemplate.selectOne("boardTest.introduce", board);
	}
}
