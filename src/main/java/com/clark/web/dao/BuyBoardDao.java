package com.clark.web.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;

@Repository
public class BuyBoardDao {
	
	@Autowired SqlSessionTemplate sessionTemplate;
	
	public List<Map<String, Object>> selectBoard() {
		return sessionTemplate.selectList("boardTest.getDual");
	}
	
	public List<Map<String, Object>> selectBuyBoard(Search search) {
		return sessionTemplate.selectList("buyBoard.selectBuyBoard", search);
	}

	public int selectCountList(Search search) {
		return sessionTemplate.selectOne("buyBoard.selectCountList", search);
	}
	
	public int insertBuyBoard(BoardModel boardTest) {
		return sessionTemplate.insert("buyBoard.insertBuyBoard", boardTest);		
	}

	public BoardModel selectBuyView(BoardModel board) {
		return sessionTemplate.selectOne("buyBoard.selectBuyView", board);
	}
	
	public int updateBuyBoard(BoardModel board) {
		return sessionTemplate.update("buyBoard.updateBuyBoard", board);
	}

	public int deleteBuyBoard(Map<String, Object> param) {
		return sessionTemplate.delete("buyBoard.deleteBuyBoard", param);
	}

}
