package com.clark.web.controller;

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
import com.clark.web.service.EventBoardService;

@Controller
public class EventBoardController {
	
	@Autowired EventBoardService eventBoardService;
	
	/**
	 * 글리스트
	 * @param request
	 * @param model
	 * @param page
	 * @param subject
	 * @return
	 */
    @RequestMapping("/event/eventBoardList")
    public String boardListTest(HttpServletRequest request, Model model,
    		@RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
    		@RequestParam(required=false, defaultValue="", name="subject") String subject) {
    Search search = new Search();
    search.setPage(page);
    search.setPage_now((page-1) * search.getPage_unit());
    search.setSubject(subject);
    search.setEvent_Yn("Y");
    search.setLang("EN");
    model.addAttribute("title","EVENT");
    eventBoardService.selectEventBoard(model, search);
       return "event/eventBoard";
   }
    
	/**
	 * 종료된 이벤트 리스트
	 * @param request
	 * @param model
	 * @param page
	 * @param subject
	 * @return
	 */
    @RequestMapping("/event/eventBoardListEnd")
    public String boardListEnd(HttpServletRequest request, Model model,
    		@RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
    		@RequestParam(required=false, defaultValue="", name="subject") String subject) {
    Search search = new Search();
    search.setPage(page);
    search.setPage_now((page-1) * search.getPage_unit());
    search.setSubject(subject);
    search.setEvent_Yn("N");
    search.setLang("EN");
    model.addAttribute("title","EVENT");
    eventBoardService.selectEventBoard(model, search);
       return "event/eventBoardEnd";
   }
    
    

    /**
     * 글쓰기 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/event/eventBoardWrite")
    public String eventBoardWrite(HttpServletRequest request, Model model, BoardModel board) {
    	model.addAttribute("title","EVENT");
       return "event/eventBoardWrite";
   }
    
    /**
     * 글쓰기 프로세스
     * @param board
     */
    @RequestMapping("/eventBoardWrite.do")
    public String insertEventBoard(BoardModel board){
    	board.setLang("EN");
    	eventBoardService.insertEventBoard(board);
    	return "redirect:/event/eventBoardList";
    }
    
    /**
     * 글보기
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/eventBoardView")
    public String EventWriteProcess(HttpServletRequest request, Model model,BoardModel board,Search search) {
    	model.addAttribute("title","EVENT");
    	eventBoardService.selectEventView(model, board,search);
       return "event/eventBoardView";
   }
    
    /**
     * 글삭제
     * @param req
     * @param param
     * @return
     */
    @RequestMapping(value = "/eventDelete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> eventDelete(HttpServletRequest req, @RequestBody Map<String, Object> param){
    	System.out.println("들어옴");
    	System.out.println(param);
    	return eventBoardService.deleteEventBoard(req, param);
    }
    
    /**
     * 글수정 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/event/eventBoardUpdate")
    public String updateEventBoard(HttpServletRequest request, Model model, BoardModel board) {
    	eventBoardService.selectEventViewbyNo(model, board);
       return "event/eventBoardModify";
   }
    
    /**
     * 글수정 프로세스
     * @param board
     */
    @RequestMapping("/eventBoardUpdate.do")
    public String updateEventBoard(BoardModel board){
    	System.out.println(board);
    	return "redirect:/eventBoardView?board_no="+eventBoardService.updateEventBoard(board);
    }
    
}
