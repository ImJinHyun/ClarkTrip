package com.clark.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.clark.web.dao.BuyBoardDao;
import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;
import com.clark.web.model.User;

@Service
public class BuyBoardService {
	
	@Autowired BuyBoardDao buyBoardDao;
	
	public List<Map<String, Object>> selectBuyBoard(Model model, Search search) {
		List<Map<String, Object>> list = buyBoardDao.selectBuyBoard(search);
		int listCount = buyBoardDao.selectCountList(search);
		
		search.setPageCnt((long) Math.ceil((float) listCount/ search.getPage_unit())) ;	//전체 페이지 갯 수
		search.paging();		
		
		
		model.addAttribute("list",  list);
		model.addAttribute("search", search);
		
		return list;
	}
	
	public BoardModel selectBuyView(Model model, BoardModel board, Search search){
		BoardModel buy = buyBoardDao.selectBuyView(board);
		int listCount = buyBoardDao.selectCountList(search);
		model.addAttribute("view", buy);
		model.addAttribute("listCount", listCount);
		return buy;
	}


	public int insertBuyBoard(BoardModel boardTest) {
		int a = buyBoardDao.insertBuyBoard(boardTest);
		return a;
	}
	
	/**
	 * 글 수정
	 * @param board
	 */
	public String updateBuyBoard(BoardModel board) {
		//세션 아이디와 board.id 같은지 체크해야함.. 
		int a = buyBoardDao.updateBuyBoard(board);	//글수정
		BoardModel movie = buyBoardDao.selectBuyView(board);		//등록된 글 가져옴
		
		return movie.getBoard_no();
			
	}
	
	/**
	 * 글 삭제
	 * @param req 
	 * @param param
	 * @return 
	 */
	public Map<String, Object> deleteBuyBoard(HttpServletRequest req, Map<String, Object> param) {
		Map<String, Object> returnMsg = new HashMap<String,Object>();
		// 아이디검사
		User userInfo = (User)req.getSession().getAttribute("login");
		
		if (!userInfo.getUserId().equals(param.get("userId"))) {
			returnMsg.put("MSG", "아이디가 일치하지 않습니다.");
			returnMsg.put("cd", "idCheck");
			return returnMsg;
		}
		
		int a = buyBoardDao.deleteBuyBoard(param);
		
		if (a!=1) {
			returnMsg.put("MSG", "삭제를 할 수 없습니다. 다시 시도해주세요.");
			returnMsg.put("cd", "deleteFail");
		}
		returnMsg.put("MSG", "성공적으로 삭제하였습니다.");
		returnMsg.put("cd", "deleteSuc");
		
		return returnMsg;
			
	}

	public void selectBuyViewbyNo(Model model, BoardModel board) {
		BoardModel free = buyBoardDao.selectBuyView(board);
		model.addAttribute("view", free);
	}
}
