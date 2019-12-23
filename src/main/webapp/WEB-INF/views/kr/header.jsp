<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Pharma &mdash; Colorlib Template</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <script src="/js/jquery-3.3.1.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Rubik:400,700|Crimson+Text:400,400i" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Cute+Font|Noto+Sans+KR&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="/fonts/icomoon/style.css">
  <link rel="stylesheet" href="/css/custom.css">
  <link rel="stylesheet" href="/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/magnific-popup.css">
  <link rel="stylesheet" href="/css/jquery-ui.css">
  <link rel="stylesheet" href="/css/owl.carousel.min.css">
  <link rel="stylesheet" href="/css/owl.theme.default.min.css">
<!-- include summernote css/js-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="/css/aos.css">
  <link rel="stylesheet" href="/css/style.css">
	<script src="/smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script>
		function getParam(name) {
	    	var se = location.search;
	    	if (se.length > 0) {
	    		var params = se
	    			.substring(1)
	    			.split('&')
	    			.map(function(e) { return e.split('='); })
	    			.filter(function(e) { return e[0] == name; });
	    		if (params.length > 0) {
	    			return decodeURIComponent(params[0][1]);
	    		}
	    	}
	    	return null;
	    }
/*
var type=navigator.appName
if (type=="Netscape")
var lang = navigator.language
else
var lang = navigator.userLanguage

// 국가코드에서 앞 2글자만 자름
var lang = lang.substr(0,2)

// 영어인 경우
if (lang == "en")
window.location.replace('english.html')

// 독일어인 경우
else if (lang == "de")
window.location.replace('german.html')

// 스페인어 인 경우
else if (lang == "es")
window.location.replace('spanish.html')

// 위의 어느것도 아닌경우 (디폴트 페이지)
else
window.location.replace('korean.html')
*/
</script>

<!-- 아래, 국가코드를 참고 하세요

af Afrikaans
ar-ae Arabic (U.A.E.)
ar-bh Arabic (Bahrain)
ar-dz Arabic (Algeria)
ar-eg Arabic (Egypt)
ar-iq Arabic (Iraq)
ar-jo Arabic (Jordan)
ar-kw Arabic (Kuwait)
ar-lb Arabic (Lebanon)
ar-ly Arabic (Libya)
ar-ma Arabic (Morocco)
ar-om Arabic (Oman)
ar-qa Arabic (Qatar)
ar-sa Arabic (Saudi Arabia)
ar-sy Arabic (Syria)
ar-tn Arabic (Tunisia)
ar-ye Arabic (Yemen)
be Belarusian
bg Bulgarian
ca Catalan
cs Czech
da Danish
de German (Standard)
de-at German (Austria)
de-ch German (Switzerland)
de-li German (Liechtenstein)
de-lu German (Luxembourg)
el Greek
en English
en English (Caribbean)
en-au English (Australia)
en-bz English (Belize)
en-ca English (Canada)
en-gb English (Great Britain)
en-ie English (Ireland)
en-jm English (Jamaica)
en-nz English (New Zealand)
en-tt English (Trinidad)
en-us English (United States)
en-za English (South Africa)
es Spanish (Spain Modern)
es Spanish (Spain Traditional)
es-ar Spanish (Argentina)
es-bo Spanish (Bolivia)
es-cl Spanish (Chile)
es-co Spanish (Colombia)
es-cr Spanish (Costa Rica)
es-do Spanish (Dominican Republic)
es-ec Spanish (Ecuador)
es-gt Spanish (Guatemala)
es-hn Spanish (Honduras)
es-mx Spanish (Mexico)
es-ni Spanish (Nicaragua)
es-pa Spanish (Panama)
es-pe Spanish (Peru)
es-pr Spanish (Puerto Rico)
es-py Spanish (Paraguay)
es-sv Spanish (El Salvador)
es-uy Spanish (Uruguay)
es-ve Spanish (Venezuela)
et Estonian
eu Basque
fa Farsi
fi Finnish
fo Faeroese
fr French (Standard)
fr-be French (Belgium)
fr-ca French (Canada)
fr-ch French (Switzerland)
fr-lu French (Luxembourg)
gd Gaelic (Scotland)
gd-ie Gaelic (Ireland)
he Hebrew
hi Hindi
hr Croatian
hu Hungarian
in Indonesian
is Icelandic
it Italian (Standard)
it-ch Italian (Switzerland)
ja Japanese
ji Yiddish
ko Korean
ko Korean (Johab)
lt Lithuanian
lv Latvian
mk Macedonian
ms Malaysian
mt Maltese
nl Dutch (Standard)
nl-be Dutch (Belgium)
no Norwegian (Bokmal)
no Norwegian (Nynorsk)
pl Polish
pt Portuguese (Standard)
pt-br Portuguese (Brazil)
rm Rhaeto-Romanic
ro Romanian
ro-mo Romanian (Moldavia)
ru Russian
ru-mo Russian (Moldavia)
sb Sorbian
sk Slovak
sl Slovenian
sq Albanian
sr Serbian (Cyrillic)
sr Serbian (Latin)
sv Swedish
sv-fi Swedish (Finland)
sx Sutu
sz Sami (Lappish)
th Thai
tn Tswana
tr Turkish
ts Tsonga
uk Ukrainian
ur Urdu
ve Venda
vi Vietnamese
xh Xhosa
zh-cn Chinese (PRC)
zh-hk Chinese (Hong Kong, S.A.R. China)
zh-sg Chinese (Singapore)
zh-tw Chinese (Taiwan)
zu Zulu
-->
</head>

<body>
  <!-- The Modal -->
  <div class="modal fade" id="myModal">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">로그인</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
       <div class="modal-body">
	         <div class="container">
		          <form class="form-signin">
		            <label for="inputEmail" class="sr-only">아이디</label>
		            <input type="text" id="loginId" name="userId" class="form-control" placeholder="아이디" required autofocus>
		            <label for="inputPassword" class="sr-only">비밀번호</label>
		            <input type="password" id="userPw" name="userPw" class="form-control" placeholder="Password" required>
		            <div class="warning"></div>
		            <div class="checkbox">
		              <label>
		                <input type="checkbox" value="remember-me"> 아이디 기억하기
		              </label>
		            </div>
		            <button class="btn btn-lg btn-primary btn-block" id="btnLogin" type="button" onclick="doLogin()">로그인</button>
		          </form>
        	</div>
      </div>
      
      <script type="text/javascript">
      function doLogin(){
    		console.log("doLogin!@");
    		var formData = {
    				userId: $("#loginId").val(),
    				userPw: $("#userPw").val(),
    				uri : window.location.pathname+window.location.search
    		};
    		
    		$.ajax({
    			url: "/login",
    			method: "post",
    		    cache: false,
    		    type: "json",
    		    dataType: "json",
    		    contentType: 'application/json',
    		    data: JSON.stringify(formData),
    		    success: function(data){
        		    console.log(formData);
        		    console.log(data);
        		    location.href=formData.uri;
    			}
    		});	
    	}
      </script>
      
              <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        <a href="/member/join"><button type="button" id="btnJoin" class="btn btn-primary">회원가입</button></a>
      </div>
      
      </div>

      </div>
    </div>
  
  <div class="site-wrap">


    <div class="site-navbar py-2">

      <div class="search-wrap">
        <div class="container">
          <a href="#" class="search-close js-search-close"><span class="icon-close2"></span></a>
          <form action="#" method="post">
            <input type="text" class="form-control" placeholder="Search keyword and hit enter...">
          </form>
        </div>
      </div>

      <div class="container">
        <div class="d-flex align-items-center justify-content-between">
          <div class="logo">
            <div class="site-logo">
              <a href="/"><img src="/images/aurance/top_logo.png"></a>
            </div>
          </div>
          <div class="main-nav d-none d-lg-block">
            <nav class="site-navigation text-right text-md-center" role="navigation">
              <ul class="site-menu js-clone-nav d-none d-lg-block">
              
              	<li class="has-children">
                  <a href="#">회사소개</a>
                  <ul class="dropdown">
                    <li><a href="/company/CEO">CEO 인사말</a></li>
                    <li><a href="/company/Executive">주요임원</a></li>
                    <li><a href="/company/contact">오시는길</a></li>
                  </ul>
                </li>
                 
              	<li class="has-children">
                  <a href="#">제품소개</a>
                  <ul class="dropdown">
                    <li><a href="/introduceFizyme?board_no=0">화이자임 효능/효과</a></li>
                    <li><a href="#">발효홍삼 효능/효과</a></li>
                    <li><a href="#">제품</a></li>
                  </ul>
                </li>
                
                <li class="has-children">
                  <a href="#">커뮤니티</a>
                  <ul class="dropdown">
                    <li><a href="/community/newsBoardList">회사뉴스</a></li>
                    <li><a href="/community/afterBoardList">이용후기</a></li>
                    <li><a href="/community/movieBoardList">관련 동영상</a></li>
                  </ul>
                </li>
                
                <li class="has-children">
                  <a href="#">이벤트</a>
                  <ul class="dropdown">
                    <li><a href="/event/eventBoardList">현재 진행중인 이벤트</a></li>
                    <li><a href="/event/eventBoardListEnd">완료된 이벤트</a></li>
                  </ul>
                </li>
                	<li class="has-children">
                  <a href="#">고객센터</a>
                  <ul class="dropdown">
                    <li><a href="/customer/noticeBoardList">공지사항</a></li>
                    <li><a href="/customer/faqBoardList">자주하시는 질문</a></li>
                    <li><a href="/customer/buyBoardList">제품구입요청</a></li>
                    <li><a href="#">1:1 문의</a></li>
                  </ul>
                </li>

              </ul>
            </nav>
          </div>
          
          <div class="icons">
            <a href="#" class="icons-btn d-inline-block js-search-open"><span class="icon-search"></span></a>
            <a href="#" class="icons-btn d-inline-block bag" data-toggle="modal" data-target="#myModal">
              <span class="icon-user-o"></span>
              <c:if test="${not empty login }">
              <a href="/logout">로그인 되었슴다</a>
              </c:if>
            </a>
            <a href="#" class="site-menu-toggle js-menu-toggle ml-3 d-inline-block d-lg-none"><span
                class="icon-menu"></span></a>
          </div>
        </div>
      </div>
    </div>