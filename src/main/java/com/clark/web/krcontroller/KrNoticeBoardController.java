package com.clark.web.krcontroller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;
import com.clark.web.service.NoticeBoardService;

@Controller
public class KrNoticeBoardController {
	
	@Autowired NoticeBoardService noticeBoardService;
	
	/**
	 * 글리스트
	 * @param request
	 * @param model
	 * @param page
	 * @param subject
	 * @return
	 */
    @RequestMapping("/KR/customer/noticeBoardList")
    public String boardListTest(HttpServletRequest request, Model model,
    		@RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
    		@RequestParam(required=false, defaultValue="", name="subject") String subject) {
    Search search = new Search();
    search.setPage(page);
    search.setPage_now((page-1) * search.getPage_unit());
    search.setSubject(subject);
    
    noticeBoardService.selectNoticeBoard(model, search);
       return "kr/customer/noticeboard/noticeBoard";
   }
    
    

    /**
     * 글쓰기 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/KR/customer/noticeBoardWrite")
    public String noticeBoardWrite(HttpServletRequest request, Model model, BoardModel board) {
       return "kr/customer/noticeboard/noticeBoardWrite";
   }
    
    /**
     * 글쓰기 프로세스
     * @param board
     */
    @RequestMapping("/KR/noticeBoardWrite.do")
    public String insertNoticeBoard(BoardModel board){
    	noticeBoardService.insertNoticeBoard(board);
    	return "redirect:/kr/customer/noticeBoardList";
    }
    
    /**
     * 글보기
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/KR/noticeBoardView")
    public String NoticeWriteProcess(HttpServletRequest request, Model model,BoardModel board,Search search) {
    	noticeBoardService.selectNoticeView(model, board,search);
       return "kr/customer/noticeboard/noticeBoardView";
   }
    
    /**
     * 글삭제
     * @param req
     * @param param
     * @return
     */
    @RequestMapping(value = "/KR/noticeDelete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> noticeDelete(HttpServletRequest req, @RequestBody Map<String, Object> param){
    	System.out.println("들어옴");
    	System.out.println(param);
    	return noticeBoardService.deleteNoticeBoard(req, param);
    }
    
    /**
     * 글수정 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/KR/customer/noticeBoardUpdate")
    public String updateNoticeBoard(HttpServletRequest request, Model model, BoardModel board) {
    	noticeBoardService.selectNoticeViewbyNo(model, board);
       return "kr/customer/noticeboard/noticeBoardModify";
   }
    
    /**
     * 글수정 프로세스
     * @param board
     */
    @RequestMapping("/KR/noticeBoardUpdate.do")
    public String updateNoticeBoard(BoardModel board){
    	System.out.println(board);
    	return "redirect:/kr/noticeBoardView?board_no="+noticeBoardService.updateNoticeBoard(board);
    }
    
}
