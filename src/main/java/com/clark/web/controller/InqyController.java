package com.clark.web.controller;

import com.clark.web.model.BoardModel;
import com.clark.web.model.InqyModel;
import com.clark.web.model.Search;
import com.clark.web.service.InqyBoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class InqyController {
	
	@Autowired InqyBoardService inqyBoardService;
	
	/**
	 * 글리스트
	 * @param request
	 * @param model
	 * @param page
	 * @param subject
	 * @return
	 */
    @RequestMapping("/customer/inqyBoardList")
    public String boardListTest(HttpServletRequest request, Model model,
    		@RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
    		@RequestParam(required=false, defaultValue="", name="subject") String subject) {
    Search search = new Search();
    search.setPage(page);
    search.setPage_now((page-1) * search.getPage_unit());
    search.setSubject(subject);
    search.setLang("EN");
    model.addAttribute("title","CUSTOMER SERVICE");
    
    inqyBoardService.selectInqyBoard(model, search);
       return "customer/inqyboard/inqyBoard";
   }
    
    

    /**
     * 글쓰기 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/customer/inqyBoardWrite")
    public String inqyBoardWrite(HttpServletRequest request, Model model, BoardModel board) {
    	model.addAttribute("title","CUSTOMER SERVICE");
       return "customer/inqyboard/inqyBoardWrite";
   }
    
    /**
     * 글쓰기 프로세스
     * @param board
     */
    @RequestMapping("/inqyBoardWrite.do")
    public String insertInqyBoard(InqyModel inqyModel){
    	inqyModel.setLang("EN");
    	inqyBoardService.insertInqyBoard(inqyModel);
    	return "redirect:/customer/inqyBoardList";
    }
    
    /**
     * 글보기
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/inqyBoardView")
    public String InqyWriteProcess(HttpServletRequest request, Model model,InqyModel board,Search search) {
    	model.addAttribute("title","CUSTOMER SERVICE");
    	inqyBoardService.selectInqyView(model, board,search);
       return "customer/inqyboard/inqyBoardView";
   }
    
    /**
     * 글삭제
     * @param req
     * @param param
     * @return
     */
    @RequestMapping(value = "/inqyDelete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> inqyDelete(HttpServletRequest req, @RequestBody Map<String, Object> param){
    	System.out.println("들어옴");
    	System.out.println(param);
    	return inqyBoardService.deleteInqyBoard(req, param);
    }
    
    /**
     * 글수정 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/customer/inqyBoardUpdate")
    public String updateInqyBoard(HttpServletRequest request, Model model, InqyModel board) {
    	model.addAttribute("title","CUSTOMER SERVICE");
    	inqyBoardService.selectInqyViewbyNo(model, board);
       return "customer/inqyboard/inqyBoardModify";
   }
    
    /**
     * 글수정 프로세스
     * @param board
     */
    @RequestMapping("/inqyBoardUpdate.do")
    public String updateInqyBoard(InqyModel board){
    	System.out.println(board);
    	return "redirect:/inqyBoardView?board_no="+inqyBoardService.updateInqyBoard(board);
    }
    
}
