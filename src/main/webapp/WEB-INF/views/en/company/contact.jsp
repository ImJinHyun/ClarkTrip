<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/en/header.jsp" flush="false" />

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
	            <p class="text-black"><a href="/EN" style="">Home</a>&nbsp;&nbsp;<span class="icon-chevron-right" style="font-size:10px"></span>&nbsp;&nbsp;Way to Come</p>
	    		
	          </div>
	        </div>
	      </div>
</div>  	
    
      <div class="container">
      <div id="map" style="width:100%;height:400px; background-image: url('/images/aurance/map.jpg');width:100% ;background-size:cover;"></div>
      </div>
   

<div class="site-section site-section-sm site-blocks-1 border-0" data-aos="fade">
	      <div class="container">
        <div class="row" style="text-align: center;">
          <div class="col-md-6 col-lg-6 mb-4 mb-lg-0">
            <div class="block-7" >
              <h3 style="color:#d2c8a3;"><div class="icon-map-marker" style="font-size:40px;"></div>Evan’s Health and Beauty Products Trading (EHBPT)</h3>
              <p>304 silverling Bld. 216 Fil-Am Friendship Hwy, Angeles, Pampanga</p>
            </div>
          </div>

          <div class="col-md-6 col-lg-6">
            <div class="block-5 mb-5">
              <h3 style="color:#d2c8a3;"><div class="icon-headphones" style="font-size:40px;"></div>Call</h3>
              <p>0000-000-0000</p>
            </div>


          </div>
        </div>
      </div>
</div> 

<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />