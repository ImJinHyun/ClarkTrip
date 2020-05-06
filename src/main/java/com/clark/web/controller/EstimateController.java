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
import com.clark.web.service.EstimateService;
import com.clark.web.service.NewsBoardService;

@Controller
public class EstimateController {
	
	@Autowired EstimateService estimateService;
	
	/**
	 * 글리스트
	 * @param request
	 * @param model
	 * @param page
	 * @param subject
	 * @return
	 */
    @RequestMapping("/Estimate")
    public String boardListTest(HttpServletRequest request, Model model,
    		@RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
    		@RequestParam(required=false, defaultValue="", name="subject") String subject) {
    Search search = new Search();
    search.setPage(page);
    search.setPage_now((page-1) * search.getPage_unit());
    search.setSubject(subject);
    search.setLang("EN");
    model.addAttribute("title","견적문의");
    
    estimateService.selectAfterBoard(model, search);
       return "estimate/list";
   }
    
    

    /**
     * 글쓰기 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/Estimate/write")
    public String afterBoardWrite(HttpServletRequest request, Model model, BoardModel board) {
    	model.addAttribute("title","견적문의");
       return "estimate/write";
   }
    
    /**
     * 글쓰기 프로세스
     * @param board
     */
    @RequestMapping("/Estimate/write.do")
    public String insertEstimateBoard(BoardModel board, Model model){
    	board.setLang("EN");
    	System.out.println(board);
    	model.addAttribute("title","견적문의");
    	estimateService.insertAfterBoard(board);
    	return "redirect:/estimate/list";
    }
    
    /**
     * 글보기
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/Estimate/view")
    public String freeWriteProcess(HttpServletRequest request, Model model,BoardModel board,Search search) {
    	model.addAttribute("title","견적문의");
    	estimateService.selectAfterView(model, board,search);
       return "estimate/afterBoardView";
   }
    
    /**
     * 글삭제
     * @param req
     * @param param
     * @return
     */
    @RequestMapping(value = "/Estimate/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> afterDelete(HttpServletRequest req, @RequestBody Map<String, Object> param, Model model){
    	model.addAttribute("title","견적문의");
    	System.out.println("들어옴");
    	System.out.println(param);
    	return estimateService.deleteAfterBoard(req, param);
    }
    
    /**
     * 글수정 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping(value="/Estimate/update.do" ,method=RequestMethod.GET )
    public String updateAfterBoard(HttpServletRequest request, Model model, BoardModel board) {
    	model.addAttribute("title","견적문의");
    	estimateService.selectAfterViewbyNo(model, board);
       return "estimate/afterBoardModify";
   }
    
    /**
     * 글수정 프로세스
     * @param board
     */
    @RequestMapping(value="/Estimate/update.do" ,method=RequestMethod.POST)
    public String updateFreeBoard(BoardModel board, Model model){
    	model.addAttribute("title","견적문의");
    	System.out.println(board);
    	return "redirect:/afterBoardView?board_no="+estimateService.updateAfterBoard(board);
    }
    
    	
    
}
