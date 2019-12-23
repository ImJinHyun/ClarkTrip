package com.clark.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.clark.web.dao.BoardDao;
import com.clark.web.dao.EventBoardDao;
import com.clark.web.dao.NewsBoardDao;
import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;
import com.clark.web.model.User;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

@Service
public class EventBoardService {
	
	@Autowired EventBoardDao eventBoardDao;
	
	public List<Map<String, Object>> selectEventBoard(Model model, Search search) {
		List<Map<String, Object>> list = eventBoardDao.selectEventBoard(search);
		int listCount = eventBoardDao.selectCountList(search);
		
		search.setPageCnt((long) Math.ceil((float) listCount/ search.getPage_unit())) ;	//전체 페이지 갯 수
		search.paging();		
		
		
		model.addAttribute("list",  list);
		model.addAttribute("search", search);
		
		return list;
	}
	
	public BoardModel selectEventView(Model model, BoardModel board, Search search){
		BoardModel event = eventBoardDao.selectEventView(board);
		int listCount = eventBoardDao.selectCountList(search);
		model.addAttribute("view", event);
		model.addAttribute("listCount", listCount);
		return event;
	}


	public int insertEventBoard(BoardModel boardTest) {
		int a = eventBoardDao.insertEventBoard(boardTest);
		System.out.println(boardTest);
		return a;
	}
	
	/**
	 * 글 수정
	 * @param board
	 */
	public String updateEventBoard(BoardModel board) {
		//세션 아이디와 board.id 같은지 체크해야함.. 
		int a = eventBoardDao.updateEventBoard(board);	//글수정
		BoardModel movie = eventBoardDao.selectEventView(board);		//등록된 글 가져옴
		
		return movie.getBoard_no();
			
	}
	
	/**
	 * 글 삭제
	 * @param req 
	 * @param param
	 * @return 
	 */
	public Map<String, Object> deleteEventBoard(HttpServletRequest req, Map<String, Object> param) {
		Map<String, Object> returnMsg = new HashMap<String,Object>();
		// 아이디검사
		User userInfo = (User)req.getSession().getAttribute("login");
		
		if (!userInfo.getUserId().equals(param.get("userId"))) {
			returnMsg.put("MSG", "아이디가 일치하지 않습니다.");
			returnMsg.put("cd", "idCheck");
			return returnMsg;
		}
		
		int a = eventBoardDao.deleteEventBoard(param);
		
		if (a!=1) {
			returnMsg.put("MSG", "삭제를 할 수 없습니다. 다시 시도해주세요.");
			returnMsg.put("cd", "deleteFail");
		}
		returnMsg.put("MSG", "성공적으로 삭제하였습니다.");
		returnMsg.put("cd", "deleteSuc");
		
		return returnMsg;
			
	}

	public void selectEventViewbyNo(Model model, BoardModel board) {
		BoardModel free = eventBoardDao.selectEventView(board);
		model.addAttribute("view", free);
	}
}
