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
                <img src="/images/aurance/ceo01.jpg" alt="Image placeholder" class="img-fluid rounded" style="width:100%;">
              </figure>
            </div>
          </div>
          <div class="col-md-5 mr-auto">
    
    
            <div class="site-section-heading pt-3 mb-4">
              <h2 class="text-black">임원일 임원</h2>
            </div>
           <div id="ceo2_1">
           <br>
            <p>직책 : 이사</p>
            <p>email : 화이자임@lovely.com</p>
            
					
    		</div>
    		
          </div>
        </div>
      </div>
    </div> 
    
 <div class="site-section bg-light custom-border-bottom" data-aos="fade">
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
              <h2 class="text-black">임원이 임원</h2>
            </div>
            
           <div id="ceo2_1">
           <br>
            <!-- <h5 style="font-weight: bold; color:#000;">걸어온 길</h5>-->
            <p>직책 : 이사</p>
            <p>email : 화이자임@lovely.com</p>
    		</div>
    		
			
          </div>
        </div>
      </div>
    </div> 
    
<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />