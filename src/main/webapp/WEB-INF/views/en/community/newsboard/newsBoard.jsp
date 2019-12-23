<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/en/header.jsp" flush="false" />
<script>

function moveWrite() {

	var grade = "${empty login.grade ? '' : login.grade}";
	if (!grade) {
		alert("해당 게시판은 관리자만 작성 가능합니다.");
	} else if (grade == "admin"){
			location.href = "/community/newsBoardWrite";
	}
}
</script>

<div class="site-section bg-light custom-border-bottom" data-aos="fade" style="background-image: url('/images/aurance/coffee.jpg');width:100% ;background-size:cover;">
	      <div class="container">
	        <div class="row mb-5">
	        
	          <div class="col-md-5 mr-auto">
	            <div class="site-section-heading pt-3 mb-4">
	              <img src="" style="max-width:100%"/>
	            </div>
	            <h1>Community</h1>
	            <p class="text-black"><a href="/EN" style="">Home</a>&nbsp;&nbsp;<span class="icon-chevron-right" style="font-size:10px"></span>&nbsp;&nbsp;News</p>
	    		
	          </div>
	        </div>
	      </div>
</div>

<div class="site-section custom-border-bottom" data-aos="fade" >
	      <div class="container">
			<h2></h2>
			  <p></p>            
			  <table class="table table-hover">
			    <thead>
			      <tr>
			        <th style="width:15%">No</th>
			        <th style="width:15%">Writer/Date</th>
			        <th>제목</th>
			      </tr>
			    </thead>
			    <tbody>
					<c:forEach var="node" items="${list }">
					<tr>
					<td >${node.board_no }</td>
					<td >${node.name } / <fmt:formatDate value="${node.reg_dt}" pattern="yyyy-MM-dd"/> </td>
					<td ><a href="/newsBoardView?board_no=${node.board_no }">${node.subject}</a></td>
					</tr>
					</c:forEach> 
					
			    </tbody>
			  </table>
			  <br>
				<div class="row mt-5">
		          <div class="col-md-12 text-center">
		            <div class="site-block-27">
		              <ul>
		            <c:if test="${search.prev}">
		                <li onclick="movePage(${search.startPage-1})" style="cursor:pointer">&lt;</li>
	               	</c:if>
	               	<c:forEach var="node" begin="${search.startPage}" end="${search.endPage}">
	               		<c:choose>
	               			<c:when test="${search.page == node}">
		                		<li class="active" onclick="movePage(${node});" style="cursor:pointer"><span>${node }</span></li>
		                	</c:when>
			                <c:otherwise>
			                	<li class="" onclick="movePage(${node});" style="cursor:pointer"><span>${node }</span></li>
			                </c:otherwise>
		                </c:choose>
		             </c:forEach>
		             <c:if test="${search.next}">
		             	<li onclick="movePage(${search.endPage+1});" style="cursor:pointer">&gt;</li>
		             </c:if>
		             </ul>
		            </div>
		          </div>
		        </div>
		        
				<c:if test="${not empty login && login.grade == 'admin' }">				
				<button class="btn btn-info btn-sm"  onclick="moveWrite();" >Write</button>
				</c:if>
	      </div>
</div>
  
  

<script>
function movePage(page) {

	var page = page;
	var subject = "";
	
	location.href = window.location.pathname+"?page="+page+"&subject="+subject;
}

function search() {
	location.href = window.location.pathname+"?page=1&category="+category+"&content="+content+"&replyYn="+replyYn;
	
	
}

</script>

<jsp:include page="/WEB-INF/views/en/footer.jsp" flush="false" />