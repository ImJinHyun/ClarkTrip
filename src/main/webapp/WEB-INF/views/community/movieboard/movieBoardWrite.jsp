<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />
	<script src="/smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<style>
.col-sm-2 {
	text-align: right;
	margin: auto;
}
.detail-padding {
padding: 0 !important;
}
</style>

<div class="site-section bg-light custom-border-bottom" data-aos="fade" style="background-image: url('/images/aurance/coffee.jpg');width:100% ;background-size:cover;">
	      <div class="container">
	        <div class="row mb-5">
	        
	          <div class="col-md-5 mr-auto">
	            <div class="site-section-heading pt-3 mb-4">
	              <img src="" style="max-width:100%"/>
	            </div>
	            <h1>Community</h1>
	            <p class="text-black"><a href="/" style="">Home</a>&nbsp;&nbsp;<span class="icon-chevron-right" style="font-size:10px"></span>&nbsp;&nbsp;Videos</p>
	    		
	          </div>
	        </div>
	      </div>
</div>
<form action="/movieBoardWrite.do" method="post"  id="frm">
<input type="hidden" name="id" value="${login.userId }"/>
<input type="hidden" name="name" value="${login.userNm}"/>
<div class="site-section bg-light custom-border-bottom" data-aos="fade" >
	      <div class="container">
		      <div class="row">
			        <div class="col-sm-2">Subject</div>
			        <div class="col-sm-10"><input type="text" class="form-control" id="subject" name="subject"></div>
		      </div>
		      <br>
		      <div class="row">
			        <div class="col-sm-2">Content</div>
			        <div class="col-sm-10">
				    <textarea id="summernote" name="content"></textarea>
				    
				    </div>
		      </div>
		      <br>
		      <button type="button" id="savebutton" class="btn btn-success" style="float:right">Write</button>
			</div>
			
</div>
</form>

<script>
     $('#summernote').summernote({
    	 placeholder: 'Please enter something',
       tabsize: 2,
       height: 500
     });
     
     $('.dropdown-toggle').dropdown();

$("#savebutton").on("click", function(){
	 $("#frm").submit();
});
</script><jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />