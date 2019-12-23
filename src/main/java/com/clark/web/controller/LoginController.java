package com.clark.web.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clark.web.service.LoginService;

import lombok.SneakyThrows;

@Controller
public class LoginController {
	
	@Autowired LoginService loginService;
	
    @RequestMapping("/login")
    public String root_test() throws Exception{
   	System.out.println("로그인페이지 이동");
       return "login";
   }
	
	@PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
	@ResponseBody
	@SneakyThrows
	public Map<String, Object> doLogin(HttpServletRequest req, HttpSession session ,HttpServletResponse res, @RequestBody Map<String, Object> param) throws IOException {
		return loginService.doLogin(req, res, session, param);
	}
	
	@GetMapping("/logout")
	public void logout(HttpServletRequest req, HttpSession session ,HttpServletResponse res) throws IOException {
		session.invalidate();
		res.sendRedirect("/");
		
	}
	
	
}
