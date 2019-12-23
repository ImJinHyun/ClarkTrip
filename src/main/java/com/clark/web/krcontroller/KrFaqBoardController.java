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
import com.clark.web.service.FaqBoardService;

@Controller
public class KrFaqBoardController {
	
	@Autowired FaqBoardService faqBoardService;
	
	/**
	 * 글리스트
	 * @param request
	 * @param model
	 * @param page
	 * @param subject
	 * @return
	 */
    @RequestMapping("/KR/customer/faqBoardList")
    public String boardListTest(HttpServletRequest request, Model model,
    		@RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
    		@RequestParam(required=false, defaultValue="", name="subject") String subject) {
    Search search = new Search();
    search.setPage(page);
    search.setPage_now((page-1) * search.getPage_unit());
    search.setSubject(subject);
    
    faqBoardService.selectFaqBoard(model, search);
       return "kr/customer/faqboard/faqBoard";
   }
    
    

    /**
     * 글쓰기 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/KR/customer/faqBoardWrite")
    public String faqBoardWrite(HttpServletRequest request, Model model, BoardModel board) {
       return "kr/customer/faqboard/faqBoardWrite";
   }
    
    /**
     * 글쓰기 프로세스
     * @param board
     */
    @RequestMapping("/KR/faqBoardWrite.do")
    public String insertFaqBoard(BoardModel board){
    	faqBoardService.insertFaqBoard(board);
    	return "redirect:/kr/customer/faqBoardList";
    }
    
    /**
     * 글보기
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/KR/faqBoardView")
    public String FaqWriteProcess(HttpServletRequest request, Model model,BoardModel board,Search search) {
    	faqBoardService.selectFaqView(model, board,search);
       return "kr/customer/faqboard/faqBoardView";
   }
    
    /**
     * 글삭제
     * @param req
     * @param param
     * @return
     */
    @RequestMapping(value = "/KR/faqDelete.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> faqDelete(HttpServletRequest req, @RequestBody Map<String, Object> param){
    	System.out.println("들어옴");
    	System.out.println(param);
    	return faqBoardService.deleteFaqBoard(req, param);
    }
    
    /**
     * 글수정 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/KR/customer/faqBoardUpdate")
    public String updateFaqBoard(HttpServletRequest request, Model model, BoardModel board) {
    	faqBoardService.selectFaqViewbyNo(model, board);
       return "kr/customer/faqboard/faqBoardModify";
   }
    
    /**
     * 글수정 프로세스
     * @param board
     */
    @RequestMapping("/KR/faqBoardUpdate.do")
    public String updateFaqBoard(BoardModel board){
    	System.out.println(board);
    	return "redirect:/kr/faqBoardView?board_no="+faqBoardService.updateFaqBoard(board);
    }
    
}
