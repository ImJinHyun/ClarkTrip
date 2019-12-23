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
import com.clark.web.service.MovieBoardService;
import com.clark.web.service.NewsBoardService;

@Controller
public class MovieController {
	
	@Autowired MovieBoardService movieBoardService;
	
	/**
	 * 글리스트
	 * @param request
	 * @param model
	 * @param page
	 * @param subject
	 * @return
	 */
    @RequestMapping("/community/movieBoardList")
    public String boardListTest(HttpServletRequest request, Model model,
    		@RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
    		@RequestParam(required=false, defaultValue="", name="subject") String subject) {
    Search search = new Search();
    search.setPage(page);
    search.setPage_now((page-1) * search.getPage_unit());
    search.setSubject(subject);
    search.setLang("EN");
    model.addAttribute("title","COMMUNITY");
    
    movieBoardService.selectMovieBoard(model, search);
       return "community/movieboard/movieBoard";
   }
    
    /**
     * 글쓰기 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/community/movieBoardWrite")
    public String afterBoardWrite(HttpServletRequest request, Model model, BoardModel board) {
    	model.addAttribute("title","COMMUNITY");
       return "community/movieboard/movieBoardWrite";
   }
    
    /**
     * 글쓰기 프로세스
     * @param board
     */
    @RequestMapping("/movieBoardWrite.do")
    public String insertAfterBoard(BoardModel board){
    	board.setLang("EN");
    	movieBoardService.insertMovieBoard(board);
    	return "redirect:/community/movieBoardList";
    }
    
    /**
     * 글보기
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/movieBoardView")
    public String afterWriteProcess(HttpServletRequest request, Model model,BoardModel board,Search search) {
    	model.addAttribute("title","COMMUNITY");
    	movieBoardService.selectMovieView(model, board,search);
       return "community/movieboard/movieBoardView";
   }
    
    /**
     * 글삭제
     * @param req
     * @param param
     * @return
     */
    @RequestMapping(value = "/movieDelete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> movieDelete(HttpServletRequest req, @RequestBody Map<String, Object> param){
    	System.out.println("들어옴");
    	System.out.println(param);
    	return movieBoardService.deleteMovieBoard(req, param);
    }
    
    /**
     * 글수정 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/community/movieBoardUpdate")
    public String updateMovieBoard(HttpServletRequest request, Model model, BoardModel board) {
    	model.addAttribute("title","COMMUNITY");
    	movieBoardService.selectMovieViewbyNo(model, board);
       return "community/movieboard/movieBoardModify";
   }
    
    /**
     * 글수정 프로세스
     * @param board
     */
    @RequestMapping("/movieBoardUpdate.do")
    public String updateMovieBoard(BoardModel board){
    	System.out.println(board);
    	return "redirect:/movieBoardView?board_no="+movieBoardService.updateMovieBoard(board);
    }
    
}
