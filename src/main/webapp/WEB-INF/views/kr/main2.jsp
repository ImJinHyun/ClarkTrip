<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
  <title>ShareSkill</title>
  <meta charset="utf-8">

  <link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script type="text/javascript">
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

</script>	
	
<style>
.carousel-item {
    overflow: hidden;
    height: 400px;
    
    
}

#first-slide {
    background-image: url("/images/aurance/h_main_bg02.jpg");
    background-position: left center;
    background-size: cover;
    background-repeat: no-repeat;
    
}

#second-slide {
    background-image: url("/images/aurance/h_main_bg01.jpg");
    background-position: center top;
    background-size: cover;
    background-repeat: no-repeat;

}

#third-slide {
    background-image: url("../images/cooking.jpg");
    background-position: center center;
    background-size: cover;
    background-repeat: no-repeat;
}

.carousel-caption {
    top: 50%;
    transform: translateY(-50%);
    bottom: initial;
    padding: 30px;
}

.carousel-caption h5 {
    font-size: 32px;
    font-weight: 300;
    margin-bottom: 18px;
}

.carousel-caption p {
    font-size: 22px;
    margin-bottom: 48px;
    font-weight: 300;
}

.carousel-caption .findClass {
    background-color: #5900e7;
    display: inline;
    padding: 10px 30px;
}

.carousel-caption .findClass a {
    color: white;
    font-size: 16px;
    font-weight: 300;
}

.alert {
    border-radius: 5px;
}

.hero-header {
    margin-top: 50px;
    margin-bottom: 70px;
    margin-left: 30px;
    margin-right: 30px;
}

.container {
    margin-left: auto;
    margin-right: auto;
    padding: 0;
    text-align: center;
}

.container #item {
    box-shadow: 0 2px 4px 0 rgba(0,0,0,0.15);
    margin-bottom: 20px;
    padding: 0;
    margin-left: 15px;
    margin-right: 15px;
}

.container #item #class {
    text-align: left;
    padding: 10px;
}

.container #item p {
    font-size: 18px;
    color: #4a4a4a;
    margin-bottom: 10px;
    width: 100%;

}

.container #item #class #user img{
    width: 20px;
    height: 20px;
    margin-right: 3px;
}
.container #item #user p {
    font-size: 13px;
    color: #4a4a4a;
    vertical-align: middle;
    margin: 0;
    display: inline;
}

.clearfix {
    clear: both;
}
</style>
	</head>

<body>

    	   <div id="map" style="width:500px;height:400px;"></div>
    	
    	



    </body>
    </html>