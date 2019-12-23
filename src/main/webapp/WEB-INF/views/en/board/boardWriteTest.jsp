<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
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
<form action="boardWrite.do" method="post" `>
<div class="site-section bg-light custom-border-bottom" data-aos="fade" >
	      <div class="container">
		      <div class="row">
			        <div class="col-sm-3">제목</div>
			        <div class="col-sm-9"><input type="text" class="form-control" id="subject" name="subject"></div>
		      </div>
		      <br>
		      <div class="row">
			        <div class="col-sm-3">내용</div>
			        <div class="col-sm-9">
				    <textarea id="summernote" name="content"></textarea>
				    <script>
				      $('#summernote').summernote({
				        placeholder: 'Hello bootstrap 4',
				        tabsize: 2,
				        height: 100
				      });
				      $('.dropdown-toggle').dropdown();
				    </script>
				    </div>
		      </div>
		      <br>
		      <button type="submit" class="btn btn-success" style="float:right">글등록</button>
			</div>
			
</div>
</form>

<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />