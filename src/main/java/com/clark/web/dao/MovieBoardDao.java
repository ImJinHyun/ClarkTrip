package com.clark.web.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;

@Repository
public class MovieBoardDao {
	
	@Autowired SqlSessionTemplate sessionTemplate;
	
	public List<Map<String, Object>> selectBoard() {
		return sessionTemplate.selectList("boardTest.getDual");
	}

	public List<Map<String, Object>> selectMovieBoard(Search search) {
		return sessionTemplate.selectList("movieBoard.selectMovieBoard", search);
	}

	public int selectCountList(Search search) {
		return sessionTemplate.selectOne("movieBoard.selectCountList", search);
	}
	
	public BoardModel selectMovieView(BoardModel board) {
		return sessionTemplate.selectOne("movieBoard.selectMovieView", board);
	}

	public int updateMovieBoard(BoardModel board) {
		return sessionTemplate.update("movieBoard.updateMovieBoard", board);
	}

	public int deleteMovieBoard(Map<String, Object> param) {
		return sessionTemplate.delete("movieBoard.deleteMovieBoard", param);
	}

	public int insertMovieBoard(BoardModel board) {
		return sessionTemplate.insert("movieBoard.insertMovieBoard", board);
	}

}
