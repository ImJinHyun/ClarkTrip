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
import com.clark.web.service.MovieBoardService;

@Controller
public class KrMovieController {
	
	@Autowired MovieBoardService movieBoardService;
	
	/**
	 * 글리스트
	 * @param request
	 * @param model
	 * @param page
	 * @param subject
	 * @return
	 */
    @RequestMapping("/KR/community/movieBoardList")
    public String boardListTest(HttpServletRequest request, Model model,
    		@RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
    		@RequestParam(required=false, defaultValue="", name="subject") String subject) {
    Search search = new Search();
    search.setPage(page);
    search.setPage_now((page-1) * search.getPage_unit());
    search.setSubject(subject);
    
    movieBoardService.selectMovieBoard(model, search);
       return "kr/community/movieboard/movieBoard";
   }
    
    /**
     * 글쓰기 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/KR/community/movieBoardWrite")
    public String afterBoardWrite(HttpServletRequest request, Model model, BoardModel board) {
       return "kr/community/movieboard/movieBoardWrite";
   }
    
    /**
     * 글쓰기 프로세스
     * @param board
     */
    @RequestMapping("/KR/movieBoardWrite.do")
    public String insertAfterBoard(BoardModel board){
    	movieBoardService.insertMovieBoard(board);
    	return "redirect:/kr/community/movieBoardList";
    }
    
    /**
     * 글보기
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/KR/movieBoardView")
    public String afterWriteProcess(HttpServletRequest request, Model model,BoardModel board,Search search) {
    	movieBoardService.selectMovieView(model, board,search);
       return "kr/community/movieboard/movieBoardView";
   }
    
    /**
     * 글삭제
     * @param req
     * @param param
     * @return
     */
    @RequestMapping(value = "/KR/movieDelete", method = RequestMethod.POST)
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
    @RequestMapping("/KR/community/movieBoardUpdate")
    public String updateMovieBoard(HttpServletRequest request, Model model, BoardModel board) {
    	movieBoardService.selectMovieViewbyNo(model, board);
       return "kr/community/movieboard/movieBoardModify";
   }
    
    /**
     * 글수정 프로세스
     * @param board
     */
    @RequestMapping("/KR/movieBoardUpdate.do")
    public String updateMovieBoard(BoardModel board){
    	System.out.println(board);
    	return "redirect:/kr/movieBoardView?board_no="+movieBoardService.updateMovieBoard(board);
    }
    
}
