package com.clark.web.krcontroller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;
import com.clark.web.service.BuyBoardService;

@Controller
public class KrBuyBoardController {

    /**
     * 글리스트
     * @param request
     * @param model
     * @param page
     * @param subject
     * @return
     */
    @RequestMapping("/KR/customer/buyBoardList")
    public String boardListTest(HttpServletRequest request, Model model,
                                @RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
                                @RequestParam(required=false, defaultValue="", name="subject") String subject) {
        Search search = new Search();
        search.setPage(page);
        search.setPage_now((page-1) * search.getPage_unit());
        search.setSubject(subject);

        buyBoardService.selectBuyBoard(model, search);
        return "kr/customer/buyboard/buyBoard";
    }

	@Autowired BuyBoardService buyBoardService;



    /**
     * 글쓰기 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/KR/customer/buyBoardWrite")
    public String buyBoardWrite(HttpServletRequest request, Model model, BoardModel board) {
       return "kr/customer/buyboard/buyBoardWrite";
   }

    /**
     * 글쓰기 프로세스
     * @param board
     */
    @RequestMapping("/KR/buyBoardWrite.do")
    public String insertBuyBoard(BoardModel board){
    	buyBoardService.insertBuyBoard(board);
    	return "redirect:/kr/customer/buyBoardList";
    }

    /**
     * 글보기
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/KR/buyBoardView")
    public String BuyWriteProcess(HttpServletRequest request, Model model,BoardModel board,Search search) {
    	buyBoardService.selectBuyView(model, board,search);
       return "kr/customer/buyboard/buyBoardView";
   }

    /**
     * 글삭제
     * @param req
     * @param param
     * @return
     */
    @RequestMapping(value = "/KR/buyDelete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> buyDelete(HttpServletRequest req, @RequestBody Map<String, Object> param){
    	System.out.println("들어옴");
    	System.out.println(param);
    	return buyBoardService.deleteBuyBoard(req, param);
    }

    /**
     * 글수정 페이지이동
     * @param request
     * @param model
     * @param boardTest
     * @return
     */
    @RequestMapping("/KR/customer/buyBoardUpdate")
    public String updateBuyBoard(HttpServletRequest request, Model model, BoardModel board) {
    	buyBoardService.selectBuyViewbyNo(model, board);
       return "kr/customer/buyboard/buyBoardModify";
   }
    
    /**
     * 글수정 프로세스
     * @param board
     */
    @RequestMapping("/KR/buyBoardUpdate.do")
    public String updateBuyBoard(BoardModel board){
    	System.out.println(board);
    	return "redirect:/kr/buyBoardView?board_no="+buyBoardService.updateBuyBoard(board);
    }
    
}
