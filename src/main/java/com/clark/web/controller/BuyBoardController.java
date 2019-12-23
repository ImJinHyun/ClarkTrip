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
import com.clark.web.service.BuyBoardService;

@Controller
public class BuyBoardController {
	
	@Autowired BuyBoardService buyBoardService;
	
	/**
	 * 글리스트
	 * @param request
	 * @param model
	 * @param page
	 * @param subject
	 * @return
	 */
    @RequestMapping("/customer/buyBoardList")
    public String boardListTest(HttpServletRequest request, Model model,
    		@RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
    		@RequestParam(required=false, defaultValue="", name="subject") String subject) {
    Search search = new Search();
    search.setPage(page);
    search.setPage_now((page-1) * search.getPage_unit());
    search.setSubject(subject);
    search.setLang("EN"); 
    search.setPage_unit(15);
    
    model.addAttribute("title","CUSTOMER SERVICE");
    buyBoardService.selectBuyBoard(model, search);
       return "customer/buyboard/buyBoard";
   }
    
    

    /**
     * 글쓰기 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/customer/buyBoardWrite")
    public String buyBoardWrite(HttpServletRequest request, Model model, BoardModel board) {
    	model.addAttribute("title","CUSTOMER SERVICE");
       return "customer/buyboard/buyBoardWrite";
   }
    
    /**
     * 글쓰기 프로세스
     * @param board
     */
    @RequestMapping("/buyBoardWrite.do")
    public String insertBuyBoard(BoardModel board, Model model){
    	board.setLang("EN");
    	model.addAttribute("title","CUSTOMER SERVICE");
    	buyBoardService.insertBuyBoard(board);
    	return "redirect:/customer/buyBoardList";
    }
    
    /**
     * 글보기
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/buyBoardView")
    public String BuyWriteProcess(HttpServletRequest request, Model model,BoardModel board,Search search) {
    	model.addAttribute("title","CUSTOMER SERVICE");
    	buyBoardService.selectBuyView(model, board,search);
       return "customer/buyboard/buyBoardView";
   }
    
    /**
     * 글삭제
     * @param req
     * @param param
     * @return
     */
    @RequestMapping(value = "/buyDelete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> buyDelete(HttpServletRequest req, @RequestBody Map<String, Object> param){
    	System.out.println("들어옴");
    	System.out.println(param);
    	return buyBoardService.deleteBuyBoard(req, param);
    }
    
    /**
     * 글수정 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/customer/buyBoardUpdate")
    public String updateBuyBoard(HttpServletRequest request, Model model, BoardModel board) {
    	model.addAttribute("title","CUSTOMER SERVICE");
    	buyBoardService.selectBuyViewbyNo(model, board);
       return "customer/buyboard/buyBoardModify";
   }
    
    /**
     * 글수정 프로세스
     * @param board
     */
    @RequestMapping("/buyBoardUpdate.do")
    public String updateBuyBoard(BoardModel board){
    	System.out.println(board);
    	return "redirect:/buyBoardView?board_no="+buyBoardService.updateBuyBoard(board);
    }
    
}
