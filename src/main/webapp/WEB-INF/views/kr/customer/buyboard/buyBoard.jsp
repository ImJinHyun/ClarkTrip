<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />
<script>
function moveWrite() {
	var grade = "${empty login.grade ? '' : login.grade}";
	if (!grade) {
		alert("해당 게시판은 관리자만 작성 가능합니다.");
	} else if (grade == "admin"){
			location.href = "/customer/buyBoardWrite";
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
	            <h1 style="color:#000">고객센터</h1>
	            <p class="text-black"><a href="/" style="">Home</a>&nbsp;&nbsp;<span class="icon-chevron-right" style="font-size:10px"></span>&nbsp;&nbsp;제품 구입요청</p>
	    		
	          </div>
	        </div>
	      </div>
</div>

      <div class="site-section">
      <div class="container">
      <h2>제품 구입요청</h2>
        
        <div class="row">
          <div class="col-sm-6 col-lg-4 text-center item mb-4">
            <span class="tag">Sale</span>
            <a href="shop-single.html"> <img src="/images/product_01.png" alt="Image"></a>
            <h3 class="text-dark"><a href="shop-single.html">Bioderma</a></h3>
            <p class="price"><del>95.00</del> &mdash; $55.00</p>
          </div>
          <div class="col-sm-6 col-lg-4 text-center item mb-4">
            <a href="shop-single.html"> <img src="/images/product_02.png" alt="Image"></a>
            <h3 class="text-dark"><a href="shop-single.html">Chanca Piedra</a></h3>
            <p class="price">$70.00</p>
          </div>
          <div class="col-sm-6 col-lg-4 text-center item mb-4">
            <a href="shop-single.html"> <img src="/images/product_03.png" alt="Image"></a>
            <h3 class="text-dark"><a href="shop-single.html">Umcka Cold Care</a></h3>
            <p class="price">$120.00</p>
          </div>
        </div>
        
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
					<button class="btn btn-info btn-sm"  onclick="moveWrite();" >글쓰기</button>
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

function dateToYYYYMMDD(date){
    function pad(num) {
        num = num + '';
        return num.length < 2 ? '0' + num : num;
    }
    return date.getFullYear() + '-' + pad(date.getMonth()+1) + '-' + pad(date.getDate());
}

</script>

<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />