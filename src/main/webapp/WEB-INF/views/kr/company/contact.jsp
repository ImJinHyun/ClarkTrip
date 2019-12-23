<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />

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
	            <p class="text-black"><a href="/" style="">Home</a>&nbsp;&nbsp;<span class="icon-chevron-right" style="font-size:10px"></span>&nbsp;&nbsp;오시는길</p>
	    		
	          </div>
	        </div>
	      </div>
</div>  	
    
      <div class="container">
      <div id="map" style="width:100%;height:400px;"></div>
      </div>
    <script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b381b93157f55ac4d0d54f1db6c31417" autoload=false></script>
    <script>
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(37.569506,126.917309), //지도의 중심좌표.
			level: 3 //지도의 레벨(확대, 축소 정도)
		};
		
		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

		// 마커가 표시될 위치입니다 
		var markerPosition  = new kakao.maps.LatLng(37.569506,126.917309); 

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    position: markerPosition
		});

		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);

		// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
		// marker.setMap(null);    
		
		var iwContent = '<div style="padding:5px;">Aurance Korea</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		    iwPosition = new kakao.maps.LatLng(37.569706,126.917320), //인포윈도우 표시 위치입니다
		    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
		
		// 인포윈도우를 생성하고 지도에 표시합니다
		var infowindow = new kakao.maps.InfoWindow({
		    map: map, // 인포윈도우가 표시될 지도
		    position : iwPosition, 
		    content : iwContent,
		    removable : iwRemoveable
		});
</script>

<div class="site-section site-section-sm site-blocks-1 border-0" data-aos="fade">
	      <div class="container">
        <div class="row" style="text-align: center;">
          <div class="col-md-6 col-lg-6 mb-4 mb-lg-0">
            <div class="block-7" >
              <h3 style="color:#d2c8a3;"><div class="icon-map-marker" style="font-size:40px;"></div>아오란코리아</h3>
              <p>서울특별시 서대문구 모래내로 143,
					210호 (창덕에버빌)</p>
            </div>
          </div>

          <div class="col-md-6 col-lg-6">
            <div class="block-5 mb-5">
              <h3 style="color:#d2c8a3;"><div class="icon-headphones" style="font-size:40px;"></div>팩스</h3>
              <p>02-307-8655</p>
            </div>


          </div>
        </div>
      </div>
</div> 

<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />