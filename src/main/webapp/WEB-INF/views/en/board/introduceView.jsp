<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/en/header.jsp" flush="false" />

<div class="site-section bg-light custom-border-bottom" data-aos="fade" style="background-image: url('/images/aurance/blood_orange.jpg');width:100% ;background-size:cover;">
	      <div class="container">
	        <div class="row mb-5">
	        
	          <div class="col-md-5 mr-auto">
	            <div class="site-section-heading pt-3 mb-4">
	              <img src="" style="max-width:100%"/>
	            </div>
	            <h1 style="color:#000;">화이자임 효능/효과</h1>
	    		
	          </div>
	        </div>
	      </div>
</div>
<br>
<div class="site-section site-section-sm site-blocks-1 border-0 aos-init aos-animate">
<div class="container">
                    <div class="row">
                        <!-- @03-08 추가 및 수정 -->
                        <div class="col-sm-12">
                                <div class="article__title text-center">
                                    <h1 class="h3">${view.subject }</h1>
                                    <span><i class="icon icon--xs icon-Calendar-4"></i><fmt:formatDate value="${view.reg_dt}" pattern="yyyy-MM-dd HH:MM:SS"/></span>
                                    &nbsp;/&nbsp;${view.name }                              </div> 
                                
                                <div class=" text-center sns-share">
                                	<a href="#" title="Facebook 공유하기"><i class="icon icon-Facebook"></i></a>
                                    <a href="#" title="Twitter 공유하기"><i class="icon icon-Twitter"></i></a>
                                </div>
                         </div>
</div>
</div>
</div>
                                <hr>
                                <!--//.article__title text-center-->
<div class="site-section site-section-sm site-blocks-1 border-0 aos-init aos-animate">
<div class="container">
                    <div class="row">
                        <!-- @03-08 추가 및 수정 -->
                        <div class="col-sm-12">
                                	${view.content }                                    
						</div>
						</div>
						</div>
						</div>
                                <hr>
                                <!--//.article__body review-text-body-->
                                
                                <div class="text-center">
                                <c:if test="${view.board_no >= 2}">
                                <a class="btn type--uppercase btn-more-view btn-80" href="afterBoardView?board_no=${view.board_no-1 }">
                                    	<span class="btn__text">
                                        	이전글
                                        </span>
                                </a>
                                </c:if>
                                
                               	<a class="btn type--uppercase btn-more-view btn-80" href="/community/afterBoardList">
                                   	<span class="btn__text">
                                       	목록
                                       </span>
                                   </a>
                                <c:if test="${listCount != view.board_no}">
								<a class="btn type--uppercase btn-more-view btn-80" href="afterBoardView?board_no=${view.board_no+1 }">
                                    	<span class="btn__text">
                                        	다음글
                                        </span>
                                </a>
                                </c:if>
                                </div>
                                <!--//.text-center-->
                                <hr>
                        </div>
                    </div>
                    <!--//.row-->
                </div>
                <!--//.container-->

<jsp:include page="/WEB-INF/views/en/footer.jsp" flush="false" />