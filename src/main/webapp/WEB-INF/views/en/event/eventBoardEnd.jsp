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
	            <h1>Event</h1>
	            <p class="text-black"><a href="/EN" style="">Home</a>&nbsp;&nbsp;<span class="icon-chevron-right" style="font-size:10px"></span>&nbsp;&nbsp;Completed Event</p>
	    		
	          </div>
	        </div>
	      </div>
</div>

<div class="site-section custom-border-bottom" data-aos="fade" >
	      <div class="container">
			<h2>Completed Event</h2>
			  <p></p>            
			  <table class="table table-hover">
			    <thead>
			      <tr>
			        <th style="width:15%">No</th>
			        <th style="width:15%">Writer/Date</th>
			        <th>Subject</th>
			      </tr>
			    </thead>
			    <tbody>
					<c:forEach var="node" items="${list }">
					<tr>
					<td >${node.board_no }</td>
					<td >${node.name } / <fmt:formatDate value="${node.reg_dt}" pattern="yyyy-MM-dd"/> </td>
					<td ><a href="/eventBoardView?board_no=${node.board_no }">${node.subject}</a></td>
					</tr>
					</c:forEach> 
					
			    </tbody>
			  </table>

			  <br>
				<ul class="pagination pagination-sm" style="float:right">
				<c:if test="${search.prev}">
				<li class="page-item"><a class="page-link" href="#">Prev</a></li>
				</c:if>
				<c:forEach var="node" begin="${search.startPage}" end="${search.endPage}">
						<c:choose>
							<c:when test="${search.page == node}">
								<li class="page-item active"><a class="page-link" href="#" onclick="movePage(${node});">${node}</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link" href="#" onclick="movePage(${node});">${node}</a></li>
							</c:otherwise>
						</c:choose>
						
				 </c:forEach>
				  <li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
				<a href="/event/eventBoardWrite"><button class="" >Write</button></a>
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

function dateToYYYYMMDD(date){
    function pad(num) {
        num = num + '';
        return num.length < 2 ? '0' + num : num;
    }
    return date.getFullYear() + '-' + pad(date.getMonth()+1) + '-' + pad(date.getDate());
}

</script>

<jsp:include page="/WEB-INF/views/en/footer.jsp" flush="false" />