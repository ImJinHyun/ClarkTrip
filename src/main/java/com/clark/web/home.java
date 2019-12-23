package com.clark.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clark.web.model.Search;
import com.clark.web.service.FaqBoardService;
import com.clark.web.service.NoticeBoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
public class home {
	
	@Autowired NoticeBoardService noticeBoardService;
	@Autowired FaqBoardService faqBoardService;
	
    @RequestMapping("/")
    public String root_test(HttpServletRequest req, Model model) throws Exception{
    	Search search = new Search();
        search.setPage(1);
        search.setPage_unit(5);
        search.setPage_now((1-1) * search.getPage_unit());
        search.setSubject("");
        search.setLang("EN");
    	
    	model.addAttribute("noticeList", noticeBoardService.selectNoticeBoard(model, search));
    	model.addAttribute("faqList",faqBoardService.selectFaqBoard(model, search));
    	
        return "main";
    }
    
    @RequestMapping("/EN")
    public String enMain(HttpServletRequest req) throws Exception{
        return "en/main";
    }

    @RequestMapping("/KR")
    public String krMain(HttpServletRequest req) throws Exception{
        return "kr/main";
    }
 
    @RequestMapping("/demo")
    public String demo_test() throws Exception{
        return "Hello demo(/demo)";
    }
}
