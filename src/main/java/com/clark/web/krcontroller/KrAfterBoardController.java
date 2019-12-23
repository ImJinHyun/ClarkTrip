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
import com.clark.web.service.AfterBoardService;

@Controller
public class KrAfterBoardController {
	
	@Autowired AfterBoardService afterBoardService;
	
	/**
	 * 글리스트
	 * @param request
	 * @param model
	 * @param page
	 * @param subject
	 * @return
	 */
    @RequestMapping("/KR/community/afterBoardList")
    public String boardListTest(HttpServletRequest request, Model model,
    		@RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
    		@RequestParam(required=false, defaultValue="", name="subject") String subject) {
    Search search = new Search();
    search.setPage(page);
    search.setPage_now((page-1) * search.getPage_unit());
    search.setSubject(subject);
    
    afterBoardService.selectAfterBoard(model, search);
       return "kr/community/afterboard/afterBoard";
   }
    
    

    /**
     * 글쓰기 페이지이동
     * @param request
     * @param model
     * @param
     * @return
     */
    @RequestMapping("/KR/community/afterBoardWrite")
    public String afterBoardWrite(HttpServletRequest request, Model model, BoardModel board) {
       return "kr/community/afterboard/afterBoardWrite";
   }
    
    /**
     * 글쓰기 프로세스
     * @param board
     */
    @RequestMapping("/KR/afterBoardWrite")
    public String insertAfterBoard(BoardModel board){
    	afterBoardService.insertAfterBoard(board);
    	return "redirect:/kr/community/afterBoardList";
    }
    
    /**
     * 글보기
     * @param request
     * @param model
     * @param
     * @return
     */
    @RequestMapping("/KR/afterBoardView")
    public String freeWriteProcess(HttpServletRequest request, Model model,BoardModel board,Search search) {
    	afterBoardService.selectAfterView(model, board,search);
       return "kr/community/afterboard/afterBoardView";
   }
    
    /**
     * 글삭제
     * @param req
     * @param param
     * @return
     */
    @RequestMapping(value = "/KR/afterDelete.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> afterDelete(HttpServletRequest req, @RequestBody Map<String, Object> param){
    	System.out.println("들어옴");
    	System.out.println(param);
    	return afterBoardService.deleteAfterBoard(req, param);
    }
    
    /**
     * 글수정 페이지이동
     * @param request
     * @param model
     * @param
     * @return
     */
    @RequestMapping(value="/KR/community/afterBoardUpdate.do" ,method=RequestMethod.GET )
    public String updateAfterBoard(HttpServletRequest request, Model model, BoardModel board) {
    	afterBoardService.selectAfterViewbyNo(model, board);
       return "kr/community/afterboard/afterBoardModify";
   }
    
    /**
     * 글수정 프로세스
     * @param board
     */
    @RequestMapping(value="/KR/community/afterBoardUpdate.do" ,method=RequestMethod.POST)
    public String updateFreeBoard(BoardModel board){
    	System.out.println(board);
    	return "redirect:kr//afterBoardView?board_no="+afterBoardService.updateAfterBoard(board);
    }
    
}
