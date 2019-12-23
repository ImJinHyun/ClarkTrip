<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/en/header.jsp" flush="false" />
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
	            <h1>About</h1>
	            <p class="text-black"><a href="/EN" style="">Home</a>&nbsp;&nbsp;<span class="icon-chevron-right" style="font-size:10px"></span>&nbsp;&nbsp; Executive</p>
	    		
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
                <img src="/images/aurance/executive_1.jpg" alt="Image placeholder" class="img-fluid rounded" style="width:100%;">
              </figure>
            </div>
          </div>
          <div class="col-md-5 mr-auto">
    
    
            <div class="site-section-heading pt-3 mb-4">
              <h2 class="text-black">Ronel Tiamzon</h2>
            </div>
           <div id="ceo2_1">
           <br>
            <p>Direct Manager</p>
            <p>E-mail : ronelTiamzon@gmail.com</p>
            <p>Sales Director Manager at Evan’s Health and Beauty Products Trading (EHBPT)<br/>
			Financial Wealth Planner at FWD Life Philippines<br/>
			Former Marketing Executive at GV Radios Corp.<br/>
			Former Sales Leader at Energy Gold Corporation.<br/>
			Former Senior Property Investment Consultant at Alveo Land Corp.<br/>
			Former Store Supervisor at Guess? Marquee Mall.</p>
					
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
              <h2 class="text-black">Anna Marie B. Bermudez</h2>
            </div>
            
           <div id="ceo2_1">
           <br>
            <!-- <h5 style="font-weight: bold; color:#000;">걸어온 길</h5>-->
            <p>Online Marketing Manager</p>
            <p>E-mail : hbonlineanna1018@gmail.com</p>
            <p>Online Marketing Manager atEvan’s Health and Beauty Products Trading (EHBPT)<br/>
					PCI Travel Agency Local Tourguide<br/>
					Jake Tour Local Tourguide& Online Advertising<br/>
					Phil So Good Travel Agency Local Tourguide</p>
    		</div>
          </div>
        </div>
      </div>
    </div> 
    
<jsp:include page="/WEB-INF/views/en/footer.jsp" flush="false" />