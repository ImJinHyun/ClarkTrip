package com.clark.web.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;

@Repository
public class NoticeBoardDao {
	
	@Autowired SqlSessionTemplate sessionTemplate;
	
	public List<Map<String, Object>> selectBoard() {
		return sessionTemplate.selectList("boardTest.getDual");
	}
	
	public List<Map<String, Object>> selectNoticeBoard(Search search) {
		return sessionTemplate.selectList("noticeBoard.selectNoticeBoard", search);
	}

	public int selectCountList(Search search) {
		return sessionTemplate.selectOne("noticeBoard.selectCountList", search);
	}
	
	public int insertNoticeBoard(BoardModel boardTest) {
		return sessionTemplate.insert("noticeBoard.insertNoticeBoard", boardTest);		
	}

	public BoardModel selectNoticeView(BoardModel board) {
		return sessionTemplate.selectOne("noticeBoard.selectNoticeView", board);
	}
	
	public int updateNoticeBoard(BoardModel board) {
		return sessionTemplate.update("noticeBoard.updateNoticeBoard", board);
	}

	public int deleteNoticeBoard(Map<String, Object> param) {
		return sessionTemplate.delete("noticeBoard.deleteNoticeBoard", param);
	}

}
