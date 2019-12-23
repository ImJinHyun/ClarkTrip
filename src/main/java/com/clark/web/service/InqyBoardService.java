package com.clark.web.service;

import com.clark.web.dao.InqyBoardDao;
import com.clark.web.model.BoardModel;
import com.clark.web.model.InqyModel;
import com.clark.web.model.Search;
import com.clark.web.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InqyBoardService {
	
	@Autowired InqyBoardDao inqyBoardDao;
	
	public List<Map<String, Object>> selectInqyBoard(Model model, Search search) {
		List<Map<String, Object>> list = inqyBoardDao.selectInqyBoard(search);
		int listCount = inqyBoardDao.selectCountList(search);
		
		search.setPageCnt((long) Math.ceil((float) listCount/ search.getPage_unit())) ;	//전체 페이지 갯 수
		search.paging();		
		
		System.out.println(list);
		model.addAttribute("list",  list);
		model.addAttribute("search", search);
		
		return list;
	}
	
	public InqyModel selectInqyView(Model model, InqyModel board, Search search){
		InqyModel inqy = inqyBoardDao.selectInqyView(board);
		int listCount = inqyBoardDao.selectCountList(search);
		model.addAttribute("view", inqy);
		model.addAttribute("listCount", listCount);
		return inqy;
	}


	public int insertInqyBoard(InqyModel inqyModel) {
		int a = inqyBoardDao.insertInqyBoard(inqyModel);
		return a;
	}
	
	/**
	 * 글 수정
	 * @param board
	 */
	public String updateInqyBoard(InqyModel board) {
		//세션 아이디와 board.id 같은지 체크해야함.. 
		int a = inqyBoardDao.updateInqyBoard(board);	//글수정
		InqyModel movie = inqyBoardDao.selectInqyView(board);		//등록된 글 가져옴
		
		return movie.getBoard_no();
			
	}
	
	/**
	 * 글 삭제
	 * @param req 
	 * @param param
	 * @return 
	 */
	public Map<String, Object> deleteInqyBoard(HttpServletRequest req, Map<String, Object> param) {
		Map<String, Object> returnMsg = new HashMap<String,Object>();
		// 아이디검사
		User userInfo = (User)req.getSession().getAttribute("login");
		
		if (!userInfo.getUserId().equals(param.get("userId"))) {
			returnMsg.put("MSG", "아이디가 일치하지 않습니다.");
			returnMsg.put("cd", "idCheck");
			return returnMsg;
		}
		
		int a = inqyBoardDao.deleteInqyBoard(param);
		
		if (a!=1) {
			returnMsg.put("MSG", "삭제를 할 수 없습니다. 다시 시도해주세요.");
			returnMsg.put("cd", "deleteFail");
		}
		returnMsg.put("MSG", "성공적으로 삭제하였습니다.");
		returnMsg.put("cd", "deleteSuc");
		
		return returnMsg;
			
	}

	public void selectInqyViewbyNo(Model model, InqyModel board) {
		InqyModel free = inqyBoardDao.selectInqyView(board);
		model.addAttribute("view", free);
	}

}
