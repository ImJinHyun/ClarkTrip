package com.clark.web.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.clark.web.dao.AfterBoardDao;
import com.clark.web.dao.BoardDao;
import com.clark.web.dao.MovieBoardDao;
import com.clark.web.dao.NewsBoardDao;
import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;
import com.clark.web.model.User;

import java.util.*;

@Service
public class MovieBoardService {
	
	@Autowired MovieBoardDao movieBoardDao;
	
	/**
	 * 글 리스트
	 * @param model
	 * @param search
	 * @return
	 */
	public List<Map<String, Object>> selectMovieBoard(Model model, Search search) {
		
		List<Map<String, Object>> list = movieBoardDao.selectMovieBoard(search);
		int listCount = movieBoardDao.selectCountList(search);
		
		search.setPageCnt((long) Math.ceil((float) listCount/ search.getPage_unit())) ;	//전체 페이지 갯 수
		search.paging();		
		System.out.println(search.toString());
		
		
		model.addAttribute("list",  list);
		model.addAttribute("search", search);
		
		return list;
	}
	
	/**
	 * 글보기
	 * @param model
	 * @param board
	 * @param search
	 * @return
	 */
	public BoardModel selectMovieView(Model model, BoardModel board, Search search){
		BoardModel after = movieBoardDao.selectMovieView(board);
		int listCount = movieBoardDao.selectCountList(search);
		model.addAttribute("view", after);
		model.addAttribute("listCount", listCount);
		return after;
	}

	/**
	 * 글쓰기
	 * @param board
	 * @return
	 */
		public int insertMovieBoard(BoardModel board) {
			System.out.println(board);
			int a = movieBoardDao.insertMovieBoard(board);
			return a;
		}
		
	/**
	 * 글 수정
	 * @param board
	 */
	public String updateMovieBoard(BoardModel board) {
		//세션 아이디와 board.id 같은지 체크해야함.. 
		int a = movieBoardDao.updateMovieBoard(board);	//글수정
		BoardModel movie = movieBoardDao.selectMovieView(board);		//등록된 글 가져옴
		
		return movie.getBoard_no();
			
	}
	
	/**
	 * 글 삭제
	 * @param req 
	 * @param param
	 * @return 
	 */
	public Map<String, Object> deleteMovieBoard(HttpServletRequest req, Map<String, Object> param) {
		Map<String, Object> returnMsg = new HashMap<String,Object>();
		// 아이디검사
		User userInfo = (User)req.getSession().getAttribute("login");
		
		if (!userInfo.getUserId().equals(param.get("userId"))) {
			returnMsg.put("MSG", "아이디가 일치하지 않습니다.");
			returnMsg.put("cd", "idCheck");
			return returnMsg;
		}
		
		int a = movieBoardDao.deleteMovieBoard(param);
		
		if (a!=1) {
			returnMsg.put("MSG", "삭제를 할 수 없습니다. 다시 시도해주세요.");
			returnMsg.put("cd", "deleteFail");
		}
		returnMsg.put("MSG", "성공적으로 삭제하였습니다.");
		returnMsg.put("cd", "deleteSuc");
		
		return returnMsg;
			
	}

	public void selectMovieViewbyNo(Model model, BoardModel board) {
		BoardModel movie = movieBoardDao.selectMovieView(board);
		model.addAttribute("view", movie);
	}
}
