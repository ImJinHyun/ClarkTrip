package com.clark.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;
import com.clark.web.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
    @RequestMapping("/introduceFizyme")
    public String boardViewTest(HttpServletRequest request, Model model,BoardModel board,Search search) {
    	model.addAttribute("title","ITEM DISCRIPTION");
   	boardService.introduce(model, board,search);
       return "board/introduceView";
   }


    @RequestMapping("/boardWrite.do")
    public String boardWriteTest(HttpServletRequest request, Model model, BoardModel boardTest) {
    	System.err.println(boardTest.toString());
   	boardService.insertBoard(boardTest);
       return "board/boardViewTest";
   }
    
}
