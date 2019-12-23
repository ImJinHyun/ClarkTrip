package com.clark.web.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;

@Repository
public class EventBoardDao {
	
	@Autowired SqlSessionTemplate sessionTemplate;
	
	public List<Map<String, Object>> selectBoard() {
		return sessionTemplate.selectList("boardTest.getDual");
	}
	
	public List<Map<String, Object>> selectEventBoard(Search search) {
		return sessionTemplate.selectList("eventBoard.selectEventBoard", search);
	}

	public int selectCountList(Search search) {
		return sessionTemplate.selectOne("eventBoard.selectCountList", search);
	}
	
	public int insertEventBoard(BoardModel boardTest) {
		return sessionTemplate.insert("eventBoard.insertEventBoard", boardTest);		
	}

	public BoardModel selectEventView(BoardModel board) {
		return sessionTemplate.selectOne("eventBoard.selectEventView", board);
	}
	
	public int updateEventBoard(BoardModel board) {
		return sessionTemplate.update("eventBoard.updateEventBoard", board);
	}

	public int deleteEventBoard(Map<String, Object> param) {
		return sessionTemplate.delete("eventBoard.deleteEventBoard", param);
	}

}
