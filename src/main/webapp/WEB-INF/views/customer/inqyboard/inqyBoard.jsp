<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />


<div class="site-section bg-light custom-border-bottom" data-aos="fade" style="background-image: url('/images/aurance/coffee.jpg');width:100% ;background-size:cover;">
	      <div class="container">
	        <div class="row mb-5">
	        
	          <div class="col-md-5 mr-auto">
	            <div class="site-section-heading pt-3 mb-4">
	              <img src="" style="max-width:100%"/>
	            </div>
	            <h1>Customer Service</h1>
	            <p class="text-black"><a href="/" style="">Home</a>&nbsp;&nbsp;<span class="icon-chevron-right" style="font-size:10px"></span>&nbsp;&nbsp;Notice</p>
	    		
	          </div>
	        </div>
	      </div>
</div>

<c:if test="${login.grade == 'admin' }">
<div class="site-section custom-border-bottom" data-aos="fade" >
	      <div class="container">
			<h2>INQY</h2>
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
					<td >${node.firstname } ${node.lastname }/ <fmt:formatDate value="${node.reg_dt}" pattern="yyyy-MM-dd"/> </td>
					<td ><a href="/inqyBoardView?board_no=${node.board_no }">${node.subject}</a></td>
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
				
				<a href="/customer/inqyBoardWrite"><button class="btn btn-info btn-sm" >Write</button></a>
	      </div>
</div>
</c:if>

<c:if test="${login.grade != 'admin' }">
<div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-5 text-black">Get In Touch</h2>
          </div>
          <div class="col-md-12">
    
            <form action="/inqyBoardWrite.do" method="post">
    
              <div class="p-3 p-lg-5 border">
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="c_fname" class="text-black">First Name <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="firstName" name="firstName">
                  </div>
                  <div class="col-md-6">
                    <label for="c_lname" class="text-black">Last Name <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="lastName" name="lastName">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">Email <span class="text-danger">*</span></label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Subject </label>
                    <input type="text" class="form-control" id="subject" name="subject">
                  </div>
                </div>
    
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_message" class="text-black">Content </label>
                    <textarea name="content" id="content" cols="30" rows="7" class="form-control"></textarea>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-lg-12">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Send Message">
                  </div>
                </div>
              </div>
            </form>
          </div>
          
        </div>
      </div>
    </div>
  </c:if>

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

<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />