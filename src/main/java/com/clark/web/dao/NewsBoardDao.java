package com.clark.web.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;

@Repository
public class NewsBoardDao {
	
	@Autowired SqlSessionTemplate sessionTemplate;
	
	public List<Map<String, Object>> selectBoard() {
		return sessionTemplate.selectList("boardTest.getDual");
		
	}

	public List<Map<String, Object>> selectNewsBoard(Search search) {
		return sessionTemplate.selectList("newsBoard.selectNewsBoard", search);
	}

	public int selectCountList(Search search) {
		return sessionTemplate.selectOne("newsBoard.selectCountList", search);
	}
	
	public int insertNewsBoard(BoardModel boardTest) {
		return sessionTemplate.insert("newsBoard.insertNewsBoard", boardTest);		
	}

	public BoardModel selectNewsView(BoardModel board) {
		return sessionTemplate.selectOne("newsBoard.selectNewsView", board);
	}
	
	public int updateNewsBoard(BoardModel board) {
		return sessionTemplate.update("newsBoard.updateNewsBoard", board);
	}

	public int deleteNewsBoard(Map<String, Object> param) {
		return sessionTemplate.delete("newsBoard.deleteNewsBoard", param);
	}

}
