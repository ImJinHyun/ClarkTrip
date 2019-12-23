package com.clark.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.clark.web.dao.NoticeBoardDao;
import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;
import com.clark.web.model.User;

@Service
public class NoticeBoardService {
	
	@Autowired NoticeBoardDao noticeBoardDao;
	
	public List<Map<String, Object>> selectNoticeBoard(Model model, Search search) {
		List<Map<String, Object>> list = noticeBoardDao.selectNoticeBoard(search);
		int listCount = noticeBoardDao.selectCountList(search);
		
		search.setPageCnt((long) Math.ceil((float) listCount/ search.getPage_unit())) ;	//전체 페이지 갯 수
		search.paging();		
		
		
		model.addAttribute("list",  list);
		model.addAttribute("search", search);
		
		return list;
	}
	
	public BoardModel selectNoticeView(Model model, BoardModel board, Search search){
		BoardModel notice = noticeBoardDao.selectNoticeView(board);
		int listCount = noticeBoardDao.selectCountList(search);
		model.addAttribute("view", notice);
		model.addAttribute("listCount", listCount);
		return notice;
	}


	public int insertNoticeBoard(BoardModel boardTest) {
		int a = noticeBoardDao.insertNoticeBoard(boardTest);
		return a;
	}
	
	/**
	 * 글 수정
	 * @param board
	 */
	public String updateNoticeBoard(BoardModel board) {
		//세션 아이디와 board.id 같은지 체크해야함.. 
		int a = noticeBoardDao.updateNoticeBoard(board);	//글수정
		BoardModel movie = noticeBoardDao.selectNoticeView(board);		//등록된 글 가져옴
		
		return movie.getBoard_no();
			
	}
	
	/**
	 * 글 삭제
	 * @param req 
	 * @param param
	 * @return 
	 */
	public Map<String, Object> deleteNoticeBoard(HttpServletRequest req, Map<String, Object> param) {
		Map<String, Object> returnMsg = new HashMap<String,Object>();
		// 아이디검사
		User userInfo = (User)req.getSession().getAttribute("login");
		
		if (!userInfo.getUserId().equals(param.get("userId"))) {
			returnMsg.put("MSG", "아이디가 일치하지 않습니다.");
			returnMsg.put("cd", "idCheck");
			return returnMsg;
		}
		
		int a = noticeBoardDao.deleteNoticeBoard(param);
		
		if (a!=1) {
			returnMsg.put("MSG", "삭제를 할 수 없습니다. 다시 시도해주세요.");
			returnMsg.put("cd", "deleteFail");
		}
		returnMsg.put("MSG", "성공적으로 삭제하였습니다.");
		returnMsg.put("cd", "deleteSuc");
		
		return returnMsg;
			
	}

	public void selectNoticeViewbyNo(Model model, BoardModel board) {
		BoardModel free = noticeBoardDao.selectNoticeView(board);
		model.addAttribute("view", free);
	}
}
