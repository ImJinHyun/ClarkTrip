<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
	            <h1 style="color:#000">Purchase Service</h1>
	            <p class="text-black"><a href="/" style="">Home</a>&nbsp;&nbsp;<span class="icon-chevron-right" style="font-size:10px"></span>&nbsp;&nbsp;Purchase</p>
	    		
	          </div>
	        </div>
	      </div>
</div>

      <div class="site-section">
      <div class="container">
      <h2>Customer</h2>
      <br/><br/>
        
        <!-- <div class="row">
          <div class="col-sm-6 col-lg-4 text-center item mb-4">
            <span class="tag">preparing</span>
            <a href="https://www.lazada.com.ph/-i412362701-s1006302888.html?spm=a2o7j.10605800.new-navigation.19.7f2a1e136a1Chh&urlFlag=true&mp=2"> <img src="/images/product_01.png" alt="Image"></a>
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
        </div> -->
 		

        <c:set var ="node2" value="${list}"/>
        <c:forEach var="node" items="${list }" varStatus="status" step="3">
          <c:if test="${status.index%3 == 0 }">
          <div class="row">
            <div class="col-sm-6 col-lg-4 text-center item mb-4">
            <c:if test="${node2[status.index].path eq '' }">
            <span class="tag">Preparing</span>
            </c:if>
                <a href="${node2[status.index].path}"><img src="${node2[status.index].upload_img }" width="270px" height="370px"  alt="Image"></a>
                <h3 class="text-dark" style="font-size:18px !important;"><a href="${node2[status.index].path }">${node2[status.index].subject }</a></h3>
                <p class="price">${node2[status.index].pride }</p>
            </div>
            <c:if test="${node2[status.index+1] ne null}">
            <div class="col-sm-6 col-lg-4 text-center item mb-4">
            <c:if test="${node2[status.index+1].path eq '' }">
            <span class="tag">Preparing</span>
            </c:if>
                <a href="${node2[status.index+1].path}"><img src="${node2[status.index+1].upload_img }" width="270px" height="370px"  alt="Image"></a>
                <h3 class="text-dark" style="font-size:18px !important;"><a href="${node2[status.index+1].path }">${node2[status.index+1].subject }</a></h3>
                <p class="price">${node2[status.index+1].pride }</p>
            </div>
            </c:if>
            <c:if test="${node2[status.index+2] ne null}">
            <div class="col-sm-6 col-lg-4 text-center item mb-4">
            <c:if test="${node2[status.index+2].path eq '' }">
            <span class="tag">Preparing</span>
            </c:if>
                <a href="${node2[status.index+2].path}"><img src="${node2[status.index+2].upload_img }" width="270px" height="370px"  alt="Image"></a>
                <h3 class="text-dark" style="font-size:18px !important;"><a href="${node2[status.index+2].path }">${node2[status.index+2].subject }</a></h3>
                <p class="price">${node2[status.index+2].pride }</p>
            </div>
            </c:if>
        </div>
</c:if>

        </c:forEach>

        
        
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

function dateToYYYYMMDD(date){
    function pad(num) {
        num = num + '';
        return num.length < 2 ? '0' + num : num;
    }
    return date.getFullYear() + '-' + pad(date.getMonth()+1) + '-' + pad(date.getDate());
}

</script>

<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />