package com.clark.web.krcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KrCompanyController {
    @RequestMapping("/KR/company/CEO")
     public String ceo() {
        return "kr/company/ceo";
    }
    
    @RequestMapping("/KR/company/Executive")
     public String excutive() {
        return "kr/company/executive";
    }
        
    @RequestMapping("/KR/company/contact")
     public String contact() {
        return "kr/company/contact";
    }
    
}
