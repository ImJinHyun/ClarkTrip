package com.clark.web.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clark.web.model.BoardModel;
import com.clark.web.model.InqyModel;
import com.clark.web.model.Search;

import java.util.List;
import java.util.Map;

@Repository
public class InqyBoardDao {
	
	@Autowired SqlSessionTemplate sessionTemplate;
	
	public List<Map<String, Object>> selectBoard() {
		return sessionTemplate.selectList("boardTest.getDual");
	}
	
	public List<Map<String, Object>> selectInqyBoard(Search search) {
		return sessionTemplate.selectList("inqyBoard.selectInqyBoard", search);
	}

	public int selectCountList(Search search) {
		return sessionTemplate.selectOne("inqyBoard.selectCountList", search);
	}
	
	public int insertInqyBoard(InqyModel inqyModel) {
		return sessionTemplate.insert("inqyBoard.insertInqyBoard", inqyModel);
	}

	public InqyModel selectInqyView(InqyModel board) {
		return sessionTemplate.selectOne("inqyBoard.selectInqyView", board);
	}
	
	public int updateInqyBoard(InqyModel board) {
		return sessionTemplate.update("inqyBoard.updateInqyBoard", board);
	}

	public int deleteInqyBoard(Map<String, Object> param) {
		return sessionTemplate.delete("inqyBoard.deleteInqyBoard", param);
	}

}
