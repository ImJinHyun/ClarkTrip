<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />
<script>

</script>

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

<div class="site-section custom-border-bottom" data-aos="fade" >
	      <div class="container">
			<h2>Hover Rows</h2>
			  <p>The .table-hover class enables a hover state (grey background on mouse over) on table rows:</p>            
			  <table class="table table-hover">
			    <thead>
			      <tr>
			        <th>번호</th>
			        <th>작성자/날짜</th>
			        <th>제목</th>
			      </tr>
			    </thead>
			    <tbody>
					<c:forEach var="node" items="${list }">
					<tr>
					<td>${node.board_id }</td>
					<td>${node.subject}</td>
					<td>${node.reg_dt}</td>
					</tr>
					</c:forEach> 
					
			    </tbody>
			  </table>
			  <br>
				<ul class="pagination pagination-sm" style="float:right">
				  <li class="page-item"><a class="page-link" href="#">Prev</a></li>
				  <li class="page-item"><a class="page-link" href="#">1</a></li>
				  <li class="page-item"><a class="page-link" href="#">2</a></li>
				  <li class="page-item"><a class="page-link" href="#">3</a></li>
				  <li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
	      </div>
</div>
  

<script>
function movePage() {

	var page = "";
	var category = "";
	var content = "";
	var replyYn = "";
	
	location.href = "/?page ="+page+"&category="+category+"&content="+content+"replyYn="+replyYn;
}

function search() {
	location.href = "/?page=1&category="+category+"&content="+content+"&replyYn="+replyYn;
	
	
}
</script>

<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />