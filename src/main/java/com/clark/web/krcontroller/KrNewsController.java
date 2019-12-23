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
import com.clark.web.service.AfterBoardService;
import com.clark.web.service.BoardService;
import com.clark.web.service.NewsBoardService;

@Controller
public class KrNewsController {
	
	@Autowired NewsBoardService NewsBoardService;
	
	/**
	 * 글리스트
	 * @param request
	 * @param model
	 * @param page
	 * @param subject
	 * @return
	 */
    @RequestMapping("/KR/community/newsBoardList")
    public String boardListTest(HttpServletRequest request, Model model,
    		@RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
    		@RequestParam(required=false, defaultValue="", name="subject") String subject) {
    Search search = new Search();
    search.setPage(page);
    search.setPage_now((page-1) * search.getPage_unit());
    search.setSubject(subject);
    
    NewsBoardService.selectNewsBoard(model, search);
       return "kr/community/newsboard/newsBoard";
   }
    
    

    /**
     * 글쓰기 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/KR/community/newsBoardWrite")
    public String NewsBoardWrite(HttpServletRequest request, Model model, BoardModel board) {
       return "kr/community/newsboard/newsBoardWrite";
   }
    
    /**
     * 글쓰기 프로세스
     * @param board
     */
    @RequestMapping("/KR/newsBoardWrite.do")
    public String insertNewsBoard(BoardModel board){
    	NewsBoardService.insertNewsBoard(board);
    	return "redirect:/kr/community/newsBoardList";
    }
    
    /**
     * 글보기
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/KR/newsBoardView")
    public String newsWriteProcess(HttpServletRequest request, Model model,BoardModel board,Search search) {
    	NewsBoardService.selectNewsView(model, board,search);
       return "kr/community/newsboard/newsBoardView";
   }
    
    /**
     * 글삭제
     * @param req
     * @param param
     * @return
     */
    @RequestMapping(value = "/KR/newsDelete.do", method = RequestMethod.POST)
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
    @RequestMapping("/KR/community/newsBoardUpdate")
    public String updateNewsBoard(HttpServletRequest request, Model model, BoardModel board) {
    	NewsBoardService.selectNewsViewbyNo(model, board);
       return "kr/community/newsboard/newsBoardModify";
   }
    
    /**
     * 글수정 프로세스
     * @param board
     */
    @RequestMapping("/KR/newsBoardUpdate.do")
    public String updateNewsBoard(BoardModel board){
    	System.out.println(board);
    	return "redirect:/kr/newsBoardView?board_no="+NewsBoardService.updateNewsBoard(board);
    }
    
    
}
