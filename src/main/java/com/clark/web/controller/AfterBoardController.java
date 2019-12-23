package com.clark.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;
import com.clark.web.service.AfterBoardService;
import com.clark.web.service.BoardService;
import com.clark.web.service.NewsBoardService;

@Controller
public class AfterBoardController {
	
	@Autowired AfterBoardService afterBoardService;
	
	/**
	 * 글리스트
	 * @param request
	 * @param model
	 * @param page
	 * @param subject
	 * @return
	 */
    @RequestMapping("/community/afterBoardList")
    public String boardListTest(HttpServletRequest request, Model model,
    		@RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
    		@RequestParam(required=false, defaultValue="", name="subject") String subject) {
    Search search = new Search();
    search.setPage(page);
    search.setPage_now((page-1) * search.getPage_unit());
    search.setSubject(subject);
    search.setLang("EN");
    model.addAttribute("title","COMMUNITY");
    
    afterBoardService.selectAfterBoard(model, search);
       return "community/afterboard/afterBoard";
   }
    
    

    /**
     * 글쓰기 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/community/afterBoardWrite")
    public String afterBoardWrite(HttpServletRequest request, Model model, BoardModel board) {
    	model.addAttribute("title","COMMUNITY");
       return "community/afterboard/afterBoardWrite";
   }
    
    /**
     * 글쓰기 프로세스
     * @param board
     */
    @RequestMapping("/afterBoardWrite")
    public String insertAfterBoard(BoardModel board, Model model){
    	board.setLang("EN");
    	System.out.println(board);
    	model.addAttribute("title","COMMUNITY");
    	afterBoardService.insertAfterBoard(board);
    	return "redirect:/community/afterBoardList";
    }
    
    /**
     * 글보기
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/afterBoardView")
    public String freeWriteProcess(HttpServletRequest request, Model model,BoardModel board,Search search) {
    	model.addAttribute("title","COMMUNITY");
    	afterBoardService.selectAfterView(model, board,search);
       return "community/afterboard/afterBoardView";
   }
    
    /**
     * 글삭제
     * @param req
     * @param param
     * @return
     */
    @RequestMapping(value = "/afterDelete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> afterDelete(HttpServletRequest req, @RequestBody Map<String, Object> param, Model model){
    	model.addAttribute("title","COMMUNITY");
    	System.out.println("들어옴");
    	System.out.println(param);
    	return afterBoardService.deleteAfterBoard(req, param);
    }
    
    /**
     * 글수정 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping(value="/community/afterBoardUpdate.do" ,method=RequestMethod.GET )
    public String updateAfterBoard(HttpServletRequest request, Model model, BoardModel board) {
    	model.addAttribute("title","COMMUNITY");
    	afterBoardService.selectAfterViewbyNo(model, board);
       return "community/afterboard/afterBoardModify";
   }
    
    /**
     * 글수정 프로세스
     * @param board
     */
    @RequestMapping(value="/community/afterBoardUpdate.do" ,method=RequestMethod.POST)
    public String updateFreeBoard(BoardModel board, Model model){
    	model.addAttribute("title","COMMUNITY");
    	System.out.println(board);
    	return "redirect:/afterBoardView?board_no="+afterBoardService.updateAfterBoard(board);
    }
    
    	
    
}
