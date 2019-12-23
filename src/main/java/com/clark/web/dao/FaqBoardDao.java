package com.clark.web.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;

@Repository
public class FaqBoardDao {
	
	@Autowired SqlSessionTemplate sessionTemplate;
	
	public List<Map<String, Object>> selectBoard() {
		return sessionTemplate.selectList("boardTest.getDual");
	}
	
	public List<Map<String, Object>> selectFaqBoard(Search search) {
		return sessionTemplate.selectList("faqBoard.selectFaqBoard", search);
	}

	public int selectCountList(Search search) {
		return sessionTemplate.selectOne("faqBoard.selectCountList", search);
	}
	
	public int insertFaqBoard(BoardModel boardTest) {
		return sessionTemplate.insert("faqBoard.insertFaqBoard", boardTest);		
	}

	public BoardModel selectFaqView(BoardModel board) {
		return sessionTemplate.selectOne("faqBoard.selectFaqView", board);
	}
	
	public int updateFaqBoard(BoardModel board) {
		return sessionTemplate.update("faqBoard.updateFaqBoard", board);
	}

	public int deleteFaqBoard(Map<String, Object> param) {
		return sessionTemplate.delete("faqBoard.deleteFaqBoard", param);
	}

}
