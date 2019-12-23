package com.clark.web.model;

import lombok.Data;

@Data
public class Search {
	int category = 0;
	String subject = "";
	
	String startDate;
	String endDate;
	String event_Yn;
	
	long page = 1;
	long page_now = 1;
	long page_unit = 10;
	
	long pageCnt; //전체 페이지
	long startPage;
	long endPage;
	long displayPage = 5;
	
	long replyYn = 0;
	
	// 언어설정
	String lang;
	
	boolean prev;
	boolean next;
	
	public void paging(){
        // prev, next, beginPage, endPage를 계산해서 만든다.
        // 2+9 = 11, 11/10 = 1, 1*10 = 10
        // 10+9 = 19, 19/10 = 1, 1*10 = 10
        // 11+9 = 20, 20/10 = 2, 2*10 = 20
        // 20+9 = 29, 29/10 = 2, 2*10 = 20
        // 111+9 = 120 120/10 = 12, 12*10 = 120
        
        // (2+9)/10 * 10 (1번 방법)
        //endPage = ((page+(displayPage-1))/displayPage)*displayPage;
        
        // 1/10 0.1(올림) 1 (2번 방법)
        endPage = ((int)Math.ceil(page/(double)displayPage))*displayPage;
        System.out.println("endPage : " + endPage);
        
        this.startPage = endPage - (displayPage - 1);
        System.out.println("beginPage : " + startPage);
             
        if(pageCnt<endPage){
            endPage = pageCnt;
            this.next = false;
        }else{
            this.next = true;
        }
        this.prev = (startPage==1)?false:true;//page가 11이상에만 나온다.
        System.out.println("endPage : " + endPage);
        System.out.println("totalPage : " + pageCnt);
        
    }


}