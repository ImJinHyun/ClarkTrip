<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />

<div class="site-section bg-light custom-border-bottom" data-aos="fade" style="background-image: url('/images/aurance/h_community_bg.jpg');width:100% ;background-size:cover;">
	      <div class="container">
	        <div class="row mb-5">
	        
	          <div class="col-md-5 mr-auto">
	            <div class="site-section-heading pt-3 mb-4">
	              <img src="" style="max-width:100%"/>
	            </div>
	            <h1>커뮤니티</h1>
	            <p class="text-black"><a href="/EN" style="">Home</a>&nbsp;&nbsp;<span class="icon-chevron-right" style="font-size:10px"></span>&nbsp;&nbsp;오시는길</p>
	    		
	          </div>
	        </div>
	      </div>
</div>

<div class="container">
                    <div class="row">
                        <!-- @03-08 추가 및 수정 -->
                        <div class="col-sm-12">
                            <article>
                                <div class="article__title text-center">
                                    <h1 class="h3">바나나가 변비에 최고라고 알고 계시나요?</h1>
                                    <span><i class="icon icon--xs icon-Calendar-4"></i> 2018-03-15 11:07:36</span>
                                    &nbsp;/&nbsp;아오란코리아                                </div> 
                                
                                <div class=" text-center sns-share">
                                	<a href="#" title="Facebook 공유하기"><i class="icon icon-Facebook"></i></a>
                                    <a href="#" title="Twitter 공유하기"><i class="icon icon-Twitter"></i></a>
                                </div>
                                
                                <hr>
                                <!--//.article__title text-center-->
                                
                                <div class="article__body">  
                                	${view.content }                                    
                                </div>
                                <hr>
                                <!--//.article__body review-text-body-->
                                
                                <div class="text-center">
                                	                                    <a class="btn type--uppercase btn-more-view btn-80" href="/board/lists/healthHB">
                                    	<span class="btn__text">
                                        	목록
                                        </span>
                                    </a>
                                                                        <a class="btn type--uppercase btn-more-view btn-80" href="/board/read/healthHB/2">
                                    	<span class="btn__text">
                                        	다음글
                                        </span>
                                    </a>
                                                                                                        </div>
                                <!--//.text-center-->
                                <hr>
                            </article>
                        </div>
                    </div>
                    <!--//.row-->
                </div>
                <!--//.container-->

<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />