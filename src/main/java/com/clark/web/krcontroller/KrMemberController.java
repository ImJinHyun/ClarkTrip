package com.clark.web.krcontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clark.web.service.BoardService;
import com.clark.web.service.MemberService;

@Controller
public class KrMemberController {
	
	@Autowired BoardService boardService;
	@Autowired MemberService memberService;
	
	
    @RequestMapping("/KR/member/join")
	public String root_test(HttpServletRequest request, Model model) {
    	//boardService.selectBoardTest(model);
        return "kr/member/join";
    }
    

}
