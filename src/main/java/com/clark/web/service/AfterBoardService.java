package com.clark.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.clark.web.dao.AfterBoardDao;
import com.clark.web.dao.BoardDao;
import com.clark.web.dao.NewsBoardDao;
import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;
import com.clark.web.model.User;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

@Service
public class AfterBoardService {
	
	@Autowired AfterBoardDao afterBoardDao;
	
	public List<Map<String, Object>> selectAfterBoard(Model model, Search search) {
		List<Map<String, Object>> list = afterBoardDao.selectAfterBoard(search);
		int listCount = afterBoardDao.selectCountList(search);
		
		search.setPageCnt((long) Math.ceil((float) listCount/ search.getPage_unit())) ;	//전체 페이지 갯 수
		search.paging();		
		
		
		model.addAttribute("list",  list);
		model.addAttribute("search", search);
		
		return list;
	}
	
	public BoardModel selectAfterView(Model model, BoardModel board, Search search){
		BoardModel after = afterBoardDao.selectAfterView(board);
		int listCount = afterBoardDao.selectCountList(search);
		model.addAttribute("view", after);
		model.addAttribute("listCount", listCount);
		return after;
	}


	public int insertAfterBoard(BoardModel boardTest) {
		int a = afterBoardDao.insertAfterBoard(boardTest);
		return a;
	}
	
	/**
	 * 글 수정
	 * @param board
	 */
	public String updateAfterBoard(BoardModel board) {
		//세션 아이디와 board.id 같은지 체크해야함.. 
		int a = afterBoardDao.updateAfterBoard(board);	//글수정
		BoardModel movie = afterBoardDao.selectAfterView(board);		//등록된 글 가져옴
		
		return movie.getBoard_no();
			
	}
	
	/**
	 * 글 삭제
	 * @param req 
	 * @param param
	 * @return 
	 */
	public Map<String, Object> deleteAfterBoard(HttpServletRequest req, Map<String, Object> param) {
		Map<String, Object> returnMsg = new HashMap<String,Object>();
		// 아이디검사
		User userInfo = (User)req.getSession().getAttribute("login");
		
		if (!userInfo.getUserId().equals(param.get("userId"))) {
			returnMsg.put("MSG", "아이디가 일치하지 않습니다.");
			returnMsg.put("cd", "idCheck");
			return returnMsg;
		}
		
		int a = afterBoardDao.deleteAfterBoard(param);
		
		if (a!=1) {
			returnMsg.put("MSG", "삭제를 할 수 없습니다. 다시 시도해주세요.");
			returnMsg.put("cd", "deleteFail");
		}
		returnMsg.put("MSG", "성공적으로 삭제하였습니다.");
		returnMsg.put("cd", "deleteSuc");
		
		return returnMsg;
			
	}

	public void selectAfterViewbyNo(Model model, BoardModel board) {
		BoardModel free = afterBoardDao.selectAfterView(board);
		model.addAttribute("view", free);
	}
}
