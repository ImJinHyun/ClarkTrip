package com.clark.web.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;

@Repository
public class AfterBoardDao {
	
	@Autowired SqlSessionTemplate sessionTemplate;
	
	public List<Map<String, Object>> selectBoard() {
		return sessionTemplate.selectList("boardTest.getDual");
	}
	
	public List<Map<String, Object>> selectAfterBoard(Search search) {
		return sessionTemplate.selectList("afterBoard.selectAfterBoard", search);
	}

	public int selectCountList(Search search) {
		return sessionTemplate.selectOne("afterBoard.selectCountList", search);
	}
	
	public int insertAfterBoard(BoardModel boardTest) {
		return sessionTemplate.insert("afterBoard.insertAfterBoard", boardTest);		
	}

	public BoardModel selectAfterView(BoardModel board) {
		return sessionTemplate.selectOne("afterBoard.selectAfterView", board);
	}
	
	public int updateAfterBoard(BoardModel board) {
		return sessionTemplate.update("afterBoard.updateAfterBoard", board);
	}

	public int deleteAfterBoard(Map<String, Object> param) {
		return sessionTemplate.delete("afterBoard.deleteAfterBoard", param);
	}

}
