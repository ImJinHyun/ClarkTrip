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
	            <h1>About</h1>
	            <p class="text-black"><a href="/" style="">Home</a>&nbsp;&nbsp;<span class="icon-chevron-right" style="font-size:10px"></span>&nbsp;&nbsp; CEO Greeting</p>
	    		
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
                <img src="/images/aurance/ceo03.jpg" alt="Image placeholder" class="img-fluid rounded" style="width:100%">    
              </figure>
            </div>
          </div>
          <div class="col-md-6">
    
            <div class="site-section-heading pt-3 mb-4">
              <h2 class="text-black">Jung-yeon Jo CEO</h2>
            </div>
            
            <div>
            	<h5 style="font-weight:bold; color:#5773bd;">Hello.</h5>
            	<h5 style="font-weight:bold; color:#000;">I am Jung-yeon Jo, CEO of EVAN ’S HEALTH & BEAUTY Product Trading.</h5>
            </div>
            <p>First of all, thank you for visiting our company. <br/>
EHB, as the company's name, pursues health and beauty <br/>
Sourcing suitable products in the Philippines and thinking about ways to facilitate market<br/>
As a company that distributes products that are useful for living, it is headquartered in Angeles City, Philippines.<br/>
<br/>
We are currently supplying many products to all parts of the Philippines.<br/>
We are marketing through various online sales platforms.<br/>
<br/>
In KOREA since the early 1990s, the demand for beauty and diet products<br/>
The highest quality products are being launched worldwide.<br/>
<br/>
Recently, eating habits in the Philippines have also changed to grain and meat.<br/>
Problems with weight gain, skin problems caused by excessive UV exposure,<br/>
Due to imbalances in the immune system and diseases in high-risk groups <br/>
Interest in related products is on the rise.<br/>
<br/>
Human beings live with the desire for beauty and health regardless of age or sex.<br/>
The right product choice is absolutely necessary to meet those needs.<br/>
EHB carefully selects products suitable for local consumers in the Philippines.<br/>
Through continuous product research and development, our company's health and beauty <br/>
I hope to keep it.
<br/>
<br/>
Lastly, I wish you and your family a peace and happiness. Thank you.</p>
          
        </div>
      </div>
    </div>
    
    
<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />