<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />
  <link rel="stylesheet" href="/css/main.css">
<style>
.nav-pills .nav-link.active, .nav-pills .show>.nav-link {
background-color: #d2c8a3 !important;
color: #fff !important;
}
a.nav-link{
color: #d2c8a3 !important;
}
</style>
<script>
	var slideIndex = 1;
	showSlides(slideIndex);
	
	function currentSlide(n) {
	  showSlides(slideIndex = n);
	}
	
	function showSlides(n) {
		switch(n) {
		case 1: 
			console.log("클릭11");
			$("#ceo1_2").css("display", "none");
			$("#ceo1_1").fadeIn();
			break;
		case 2:
			$("#ceo1_1").css("display", "none");
			$("#ceo1_2").fadeIn();
			break;
		case 3:
			$("#ceo2_2").css("display", "none");
			$("#ceo2_1").fadeIn();
			break;
		case 4:
			$("#ceo2_1").css("display", "none");
			$("#ceo2_2").fadeIn();
			break;
		}  
	}
</script>

<div class="site-section bg-light custom-border-bottom" data-aos="fade" style="background-image: url('/images/aurance/h_about_bg.jpg');width:100% ;background-size:cover;">
	      <div class="container">
	        <div class="row mb-5">
	        
	          <div class="col-md-5 mr-auto">
	            <div class="site-section-heading pt-3 mb-4">
	              <img src="" style="max-width:100%"/>
	            </div>
	            <h1>회사소개</h1>
	            <p class="text-black"><a href="/" style="">Home</a>&nbsp;&nbsp;<span class="icon-chevron-right" style="font-size:10px"></span>&nbsp;&nbsp; Ceo인사말</p>
	    		
	          </div>
	        </div>
	      </div>
	    </div>  	

   	<div class="site-section bg-light custom-border-bottom" data-aos="fade">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-6">
            <div class="block-16">
              <figure style="margin:auto;">
                <img src="/images/aurance/ceo01.jpg" alt="Image placeholder" class="img-fluid rounded" style="width:100%">    
              </figure>
            </div>
          </div>
          <div class="col-md-6">
    
            <div class="site-section-heading pt-3 mb-4">
              <h2 class="text-black">조정연 회장</h2>
            </div>
            
            <div>
            	<h5 style="font-weight:bold; color:#5773bd;">안녕하십니까?</h5>
            	<h5 style="font-weight:bold; color:#000;">EVAN’S HEALTH & BEAUTY 대표 조정연 입니다.</h5>
            </div>
            <p>저희 EHB는 회사의 이름 그대로 건강과 아름다움을 추구하는 회사로서 <br/>
필리핀 현지에 적합한 제품을 소싱하고, 원활한 시장 활성화를 위해 방법을 고민하여 <br/>
생활에 유익한 상품을 유통하는 회사로써 필리핀 앙헬레스시에 본사를 두고 운영하고 있습니다.<br/>
<br/>
현재 필리핀 전 지역을 대상으로 많은 제품을 공급하고 있으며 <br/>
여러가지 온라인 판매 플랫폼을 통해서 마케팅을 진행하고 있습니다.<br/>
<br/>
한국은 이미 1990년대 초반부터 뷰티 / 다이어트 관련 제품에 대한 수요가 증가하고<br/>
전 세계적으로 최고급 수준의 제품들이 출시되고 있는 상황입니다.<br/>
<br/>
최근 필리핀 현지의 식습관 또한 곡류와 육류 위주로 변경됨에 따라 <br/>
체중증가에 따른 문제, 과다한 자외선 노출로 인한 피부 트러블 문제,<br/>
면역체계 불균형으로 인한 성인병 및 고위험군 의 질병 문제등으로 인해 <br/>
관련 제품에 대한 관심도가 증가하는 추세입니다.<br/>
<br/>
인간은 남녀노소를 불문하고 아름다움과 건강에 대한 욕구를 가지고 살아갑니다.<br/>
제대로 된 제품 선택은 그러한 욕구충족을 위해 절대적으로 필요한 것이라 생각 됩니다.<br/>
저희 EHB는 필리핀 현지 소비자에게 적합한 제품들을 엄선하여 수입하고 있습니다.<br/>
앞으로 저희 회사 지속적인 제품 연구개발을 통해 고객 분들의 건강과 아름다움을 <br/>
유지할 수 있도록 노력하겠습니다.<br/>
<br/>
마지막으로 저희 회사의 제품을 구매하시는 모든분들의 가정에 평화와 행복이 가득하시길 바랍니다. 감사합니다.</p>
            
            
			  <!-- <ul class="nav nav-pills" role="tablist">
			    <li class="nav-item" onclick="currentSlide(1)">
			      <a class="nav-link active dot" data-toggle="pill" href="#home"><div class="icon-user-circle-o" style="font-size:70px;"></div></a>
			    </li>
			    <li class="nav-item "  onclick="currentSlide(2)">
			      <a class="nav-link" data-toggle="pill" href="#menu1" ><div class="icon-trophy" style="font-size:70px;"></div></a>
			    </li>
			  </ul>
			<div id="ceo1_1" ><br>
            <h5 style="font-weight: bold; color:#000;">걸어온 길</h5>
            <p>現 중화동남아여행업협회(AITA) 회장<br>
		           現 화방관광 대표이사<br>
				現 아오란코리아 대표이사<br>
				現 HB 개발 대표이사 제주 파크 사이드 호텔 운영<br>
				서울특별시 명예 시민 선정 MICE 분야 독보적인 경쟁력을 자랑하는 기업<br>
				2016.6 - 상해 신유국제사 유한공사 8000명 유치</p>
			</div>	
			
			<div id="ceo1_2" style="display: none;"><br>
            <h5 style="font-weight: bold; color:#000;">주요 수상내역</h5>
            <p>2014년 한국관광공사 기업회의 인센티브 관광 유치지원 대상 <br>
					2015년 제52회 무역의날 1천만불탑 수상<br>
					2015년 중소기업품질경영대상<br>
					2016년 서울관광마케팅 특별공로상<br>
					2016년 대한민국 해양관광 대상 수상</p>
			</div>	
          </div> -->
          
        </div>
      </div>
    </div>
    
    <!-- <div class="site-section bg-light custom-border-bottom" data-aos="fade">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-6 order-md-2">
            <div class="block-16">
              <figure>
                <img src="/images/aurance/ceo02.jpg" alt="Image placeholder" class="img-fluid rounded" style="width:100%;">
              </figure>
            </div>
          </div>
          <div class="col-md-5 mr-auto">
    
    
            <div class="site-section-heading pt-3 mb-4">
              <h2 class="text-black">배환수 사장</h2>
            </div>
            
            <ul class="nav nav-pills" role="tablist">
			    <li class="nav-item" onclick="currentSlide(3)">
			      <a class="nav-link active dot" data-toggle="pill" href="#home"><div class="icon-user-circle-o" style="font-size:70px;"></div></a>
			    </li>
			    <li class="nav-item "  onclick="currentSlide(4)">
			      <a class="nav-link" data-toggle="pill" href="#menu1" ><div class="icon-trophy" style="font-size:70px;"></div></a>
			    </li>
			  </ul>
           <div id="ceo2_1">
           <br>
            <h5 style="font-weight: bold; color:#000;">걸어온 길</h5>
            <p>2017.05 ㈜아오란코리아로 개명 / 2017.03 (주)넥스트비티 MOU 체결 2017.03 중국 아오란그룹 외자 유치 성공<br>
					2016.11 HB PARTNERS 설립 M-COMMERCE (이동 전자상거래) 기업<br>
					現 아오란코리아 사장 /前 삼성생명 지점장<br>
					前 학사장교 48기 /성균관대 경제학과 · 경영학과(복수전공)<br></p>
    		</div>
    		
    		<div id="ceo2_2" style="display: none;">
    		<br>
            <h5 style="font-weight: bold; color:#000;">주요 수상내역</h5>
            <p>2017 한국일보 뷰티산업대상 엠커머스 뷰티 부문 수상<br>
					2017 아시아 퍼스트 브랜드 어워즈 엠커머스 뷰티 부문 수상<br>
					2017 미스아시아 어워즈 선발대회 심사위원</p>
			</div>	
			
          </div>
        </div>
      </div>
    </div> -->
    
<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />