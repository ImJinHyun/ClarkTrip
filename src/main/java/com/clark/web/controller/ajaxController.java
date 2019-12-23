package com.clark.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clark.web.CrytoSHA3;
import com.clark.web.model.User;
import com.clark.web.service.BoardService;
import com.clark.web.service.MemberService;

import lombok.SneakyThrows;

@Controller
public class ajaxController {
	
	@Autowired BoardService boardService;
	@Autowired MemberService memberService;
	
	
    @RequestMapping("/ajax")
	public String root_test(HttpServletRequest request, Model model) {
    	boardService.selectBoard(model);
        return "ajax";
    }
    
    @PostMapping(value = "/ajaxTest", produces = "application/json;charset=UTF-8")
    @ResponseBody
 	public Map<String, Object> ajax_test(HttpServletRequest request, Model model, @RequestParam Map<String, Object> param) {
     	param.put("suc", "통신성공");
     	System.out.println(param);
         return param;
     }
}
