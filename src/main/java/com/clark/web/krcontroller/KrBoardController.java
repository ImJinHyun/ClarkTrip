package com.clark.web.krcontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;
import com.clark.web.service.BoardService;

@Controller
public class KrBoardController {
	
	@Autowired BoardService boardService;
	
    @RequestMapping("/KR/introduceFizyme")
    public String boardViewTest(HttpServletRequest request, Model model,BoardModel board,Search search) {
   	boardService.introduce(model, board,search);
       return "kr/board/introduceView";
   }

}
