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
import com.clark.web.service.AfterBoardService;
import com.clark.web.service.BoardService;
import com.clark.web.service.NewsBoardService;

@Controller
public class NewsController {
	
	@Autowired NewsBoardService NewsBoardService;
	
	/**
	 * 글리스트
	 * @param request
	 * @param model
	 * @param page
	 * @param subject
	 * @return
	 */
    @RequestMapping("/community/newsBoardList")
    public String boardListTest(HttpServletRequest request, Model model,
    		@RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
    		@RequestParam(required=false, defaultValue="", name="subject") String subject) {
    Search search = new Search();
    search.setPage(page);
    search.setPage_now((page-1) * search.getPage_unit());
    search.setSubject(subject);
    search.setLang("EN");
    model.addAttribute("title","COMMUNITY");
    
    NewsBoardService.selectNewsBoard(model, search);
       return "community/newsboard/newsBoard";
   }
    
    

    /**
     * 글쓰기 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/community/newsBoardWrite")
    public String NewsBoardWrite(HttpServletRequest request, Model model, BoardModel board) {
    	model.addAttribute("title","COMMUNITY");
       return "community/newsboard/newsBoardWrite";
   }
    
    /**
     * 글쓰기 프로세스
     * @param board
     */
    @RequestMapping("/newsBoardWrite.do")
    public String insertNewsBoard(BoardModel board){
    	board.setLang("EN");
    	NewsBoardService.insertNewsBoard(board);
    	return "redirect:/community/newsBoardList";
    }
    
    /**
     * 글보기
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/newsBoardView")
    public String newsWriteProcess(HttpServletRequest request, Model model,BoardModel board,Search search) {
    	model.addAttribute("title","COMMUNITY");
    	NewsBoardService.selectNewsView(model, board,search);
       return "community/newsboard/newsBoardView";
   }
    
    /**
     * 글삭제
     * @param req
     * @param param
     * @return
     */
    @RequestMapping(value = "/newsDelete.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> newsDelete(HttpServletRequest req, @RequestBody Map<String, Object> param){
    	System.out.println("들어옴");
    	System.out.println(param);
    	return NewsBoardService.deleteNewsBoard(req, param);
    }
    
    /**
     * 글수정 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/community/newsBoardUpdate")
    public String updateNewsBoard(HttpServletRequest request, Model model, BoardModel board) {
    	model.addAttribute("title","COMMUNITY");
    	NewsBoardService.selectNewsViewbyNo(model, board);
       return "community/newsboard/newsBoardModify";
   }
    
    /**
     * 글수정 프로세스
     * @param board
     */
    @RequestMapping("/newsBoardUpdate.do")
    public String updateNewsBoard(BoardModel board){
    	System.out.println(board);
    	return "redirect:/newsBoardView?board_no="+NewsBoardService.updateNewsBoard(board);
    }
    
    
}
