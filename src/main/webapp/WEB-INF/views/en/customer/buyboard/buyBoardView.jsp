<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/en/header.jsp" flush="false" />

<div class="site-section bg-light custom-border-bottom" data-aos="fade" style="background-image: url('/images/aurance/coffee.jpg');width:100% ;background-size:cover;">
	      <div class="container">
	        <div class="row mb-5">
	        
	          <div class="col-md-5 mr-auto">
	            <div class="site-section-heading pt-3 mb-4">
	              <img src="" style="max-width:100%"/>
	            </div>
	            <h1>Customer Service</h1>
	            <p class="text-black"><a href="/EN" style="">Home</a>&nbsp;&nbsp;<span class="icon-chevron-right" style="font-size:10px"></span>&nbsp;&nbsp;Purchase</p>
	    		
	          </div>
	        </div>
	      </div>
</div>
<br>
<div class="container">
                    <div class="row">
                        <!-- @03-08 추가 및 수정 -->
                        <div class="col-sm-12">
                            <article>
                                <div class="article__title text-center">
                                    <h1 class="h3">${view.subject }</h1>
                                    <span><i class="icon icon--xs icon-Calendar-4"></i><fmt:formatDate value="${view.reg_dt}" pattern="yyyy-MM-dd HH:MM:SS"/></span>
                                    &nbsp;/&nbsp;${view.id }                              </div> 
                                
                                <div class=" text-center sns-share">
                                	<a href="#" title="Facebook 공유하기"><i class="icon icon-Facebook"></i></a>
                                    <a href="#" title="Twitter 공유하기"><i class="icon icon-Twitter"></i></a>
                                </div>
                                
                                <hr>
                                <!--//.article__title text-center-->
                                
                                <div class="article__body">  
                                	${view.content }                                    
                                </div>
                                <div style="text-align: right;">
					<c:if test="${view.id == login.userId }">
						<button type="button" class="btn btn-danger btn-sm"
							onclick="boardDel()">삭제</button>

						<button type="button" class="btn btn-info btn-sm"
							onclick="update()">수정</button>
					</c:if>
				</div>
				<script type="text/javascript">
				function boardDel(){
					var deleteYn = confirm("삭제하면 복구할 수 없습니다.\n게시글을 삭제하시겠습니까?");
					var formData = {
							boardNo : ${view.board_no},
							userId : "${view.id}"
						};
					if (deleteYn) {
						$.ajax({
							url: "/buyDelete",
						    type: "POST",
						    data: JSON.stringify(formData),
						    contentType: 'application/json',
						    dataType: "json",
						    success: function(data){
								    console.log(data.MSG);
								    console.log(data.cd);
									if(data.cd == "idCheck") {
										alert("작성자와 로그인정보가 다릅니다.");
										location.reload();
									} else if(data.cd == "deleteFail") {
										alert("삭제할 수 없습니다. 관리자에게 문의해주세요");
										location.reload();
									} else {
										alert("게시글이 삭제되었습니다.");			
										location.href="/customer/buyBoardList";	
									}
						    },
							error : function(request,status,error){
								  alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
						       }
						});	
					}		
				}
				                        
				function update(){
				location.href= "/customer/buyBoardUpdate?board_no="+"${view.board_no}"
				}
				</script>
                                <hr>
                                <!--//.article__body review-text-body-->
                                
                                <div class="text-center">
                                <c:if test="${view.board_no >= 2}">
                                <a class="btn type--uppercase btn-more-view btn-80" href="buyBoardView?board_no=${view.board_no-1 }">
                                    	<span class="btn__text">
                                        	이전글
                                        </span>
                                </a>
                                </c:if>
                                
                               	<a class="btn type--uppercase btn-more-view btn-80" href="/customer/buyBoardList">
                                   	<span class="btn__text">
                                       	목록
                                       </span>
                                   </a>
                                <c:if test="${listCount != view.board_no}">
								<a class="btn type--uppercase btn-more-view btn-80" href="buyBoardView?board_no=${view.board_no+1 }">
                                    	<span class="btn__text">
                                        	다음글
                                        </span>
                                </a>
                                </c:if>
                                </div>
                                <!--//.text-center-->
                                <hr>
                            </article>
                        </div>
                    </div>
                    <!--//.row-->
                </div>
                <!--//.container-->

<jsp:include page="/WEB-INF/views/en/footer.jsp" flush="false" />