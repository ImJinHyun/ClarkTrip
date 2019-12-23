package com.clark.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.clark.web.dao.BoardDao;
import com.clark.web.dao.FaqBoardDao;
import com.clark.web.dao.NewsBoardDao;
import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;
import com.clark.web.model.User;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

@Service
public class FaqBoardService {
	
	@Autowired FaqBoardDao faqBoardDao;
	
	public List<Map<String, Object>> selectFaqBoard(Model model, Search search) {
		List<Map<String, Object>> list = faqBoardDao.selectFaqBoard(search);
		int listCount = faqBoardDao.selectCountList(search);
		
		search.setPageCnt((long) Math.ceil((float) listCount/ search.getPage_unit())) ;	//전체 페이지 갯 수
		search.paging();		
		
		
		model.addAttribute("list",  list);
		model.addAttribute("search", search);
		
		return list;
	}
	
	public BoardModel selectFaqView(Model model, BoardModel board, Search search){
		BoardModel faq = faqBoardDao.selectFaqView(board);
		int listCount = faqBoardDao.selectCountList(search);
		model.addAttribute("view", faq);
		model.addAttribute("listCount", listCount);
		return faq;
	}


	public int insertFaqBoard(BoardModel boardTest) {
		int a = faqBoardDao.insertFaqBoard(boardTest);
		return a;
	}
	
	/**
	 * 글 수정
	 * @param board
	 */
	public String updateFaqBoard(BoardModel board) {
		//세션 아이디와 board.id 같은지 체크해야함.. 
		int a = faqBoardDao.updateFaqBoard(board);	//글수정
		BoardModel movie = faqBoardDao.selectFaqView(board);		//등록된 글 가져옴
		
		return movie.getBoard_no();
			
	}
	
	/**
	 * 글 삭제
	 * @param req 
	 * @param param
	 * @return 
	 */
	public Map<String, Object> deleteFaqBoard(HttpServletRequest req, Map<String, Object> param) {
		Map<String, Object> returnMsg = new HashMap<String,Object>();
		// 아이디검사
		User userInfo = (User)req.getSession().getAttribute("login");
		
		if (!userInfo.getUserId().equals(param.get("userId"))) {
			returnMsg.put("MSG", "아이디가 일치하지 않습니다.");
			returnMsg.put("cd", "idCheck");
			return returnMsg;
		}
		
		int a = faqBoardDao.deleteFaqBoard(param);
		
		if (a!=1) {
			returnMsg.put("MSG", "삭제를 할 수 없습니다. 다시 시도해주세요.");
			returnMsg.put("cd", "deleteFail");
		}
		returnMsg.put("MSG", "성공적으로 삭제하였습니다.");
		returnMsg.put("cd", "deleteSuc");
		
		return returnMsg;
			
	}

	public void selectFaqViewbyNo(Model model, BoardModel board) {
		BoardModel free = faqBoardDao.selectFaqView(board);
		model.addAttribute("view", free);
	}
}
