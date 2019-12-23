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
public class MemberController {
	
	@Autowired BoardService boardService;
	@Autowired MemberService memberService;
	
	
    @RequestMapping("/member/join")
	public String root_test(HttpServletRequest request, Model model) {
    	//boardService.selectBoardTest(model);
        return "member/join";
    }
    
    @PostMapping(value="/member/joinProcess")
    @ResponseBody
    @SneakyThrows
	public Map<String, Object> joinProcess(HttpServletRequest request, Model model, @RequestBody Map<String, Object> param) {
    	CrytoSHA3 crytoSHA3 = new CrytoSHA3();
    	
    	Map<String, Object> returnMsg = new HashMap<String, Object>();
    	
    	User user = new User();
    	
    	try {
    		user.setUserId(param.get("userId").toString());
        	user.setUserNm(param.get("userNm").toString());
        	user.setUserPw(crytoSHA3.crytoSHA3(param.get("userPw").toString(), 512));
        	user.setBirth(param.get("birth").toString());
        	user.setEmail(param.get("email").toString());
        	user.setTel(param.get("tel").toString());
        	user.setGender(param.get("gender").toString());
        	
        	//user.setEmailReceiveYn(param.get("emailReceiveYn").toString());
        	//user.setSmsReceiveYn(param.get("smsReceiveYn").toString());
        	user.setAddrfull(param.get("addrfull").toString());
        	user.setZipcode(param.get("zipcode").toString());
        	
        	int idCheck = memberService.idCheck(param);
        	int telCheck = memberService.telCheck(param);
        			
        	
    		if(idCheck > 0) {
    			returnMsg.put("MSG", "FAIL");
    			returnMsg.put("cd", "idCheck");
    			return returnMsg;
    		} 
    		
    		if(telCheck > 0) {
    			returnMsg.put("MSG", "FAIL");
    			returnMsg.put("cd", "telCheck");
    			return returnMsg;
    		} 
        	
    		int joinCheck = memberService.joinProcess(user);
    		
    		if(joinCheck > 0) {
    			returnMsg.put("MSG", "SUC");
    			returnMsg.put("cd", "join");
    		} else {
    			returnMsg.put("MSG", "FAIL");
    			returnMsg.put("cd", "join");
    		}
		} catch (Exception e) {
			
			returnMsg.put("MSG", "FAIL");
			returnMsg.put("cd", e.getMessage());
			e.printStackTrace();
		}
    	
    	
        return returnMsg;
    }

}
