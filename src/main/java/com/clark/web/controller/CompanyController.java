package com.clark.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompanyController {
    @RequestMapping("/company/CEO")
     public String ceo(Model model) {
    	model.addAttribute("title","About");
        return "company/ceo";
    }
    
    @RequestMapping("/company/Executive")
     public String excutive(Model model) {
    	model.addAttribute("title","About");
        return "company/executive";
    }
        
    @RequestMapping("/company/contact")
     public String contact(Model model) {
    	model.addAttribute("title","About");
        return "company/contact";
    }
    
}
