<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/en/header.jsp" flush="false" />
<style>
.form-group{
clear:both;
}
.col-lg-10{
float:right
}

.col-lg-2 {

}
</style>
<div class="site-section bg-light custom-border-bottom" data-aos="fade" style="background-image: url('/images/aurance/coffee.jpg');width:100% ;background-size:cover;">
	      <div class="container">
	        <div class="row mb-5">
	        
	          <div class="col-md-5 mr-auto">
	            <div class="site-section-heading pt-3 mb-4">
	              <img src="" style="max-width:100%"/>
	            </div>
	            <h1>Sign-up</h1>
	            <p class="text-black"><a href="/EN" style="">Home</a>&nbsp;&nbsp;<span class="icon-chevron-right" style="font-size:10px"></span>&nbsp;&nbsp;Sign-up</p>
	    		
	          </div>
	        </div>
	      </div>
</div>

<!-- 모달창 -->
            <div class="modal fade" id="defaultModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Alert</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            
                        </div>
                        <div class="modal-body">
                            <p class="modal-contents"></p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <!--// 모달창 -->
            
	<div class="site-section custom-border-bottom" data-aos="fade" >
    	 <div class="container"><!-- 좌우측의 공간 확보 -->
                <!-- 본문 들어가는 부분 -->
 
        <form class="form-horizontal" method="post" action="/member/joinProcess" id="form">
        <div class="p-3 p-lg-5 border">
            
            <div class="form-group row">
                  <div class="col-md-12">
                	<label for="inputId" class="text-black">ID <span class="text-danger">*</span></label>
                    <input type="text" class="form-control onlyAlphabetAndNumber" id="userId" name="userId" data-rule-required="true" placeholder="" maxlength="30">
           		</div>
           	</div> 
           
            <div class="form-group row" id="divPassword">
                <div class="col-lg-12">
                <label for="inputPassword" class="text-black">Password <span class="text-danger">*</span></label>
                    <input type="password" class="form-control" id="password" name="userPw" data-rule-required="true" placeholder="password" maxlength="30">
                </div>
            </div>
            
            <div class="form-group row" id="divPasswordCheck">
                <div class="col-lg-12">
                <label for="inputPasswordCheck" class="text-black">Password Check <span class="text-danger">*</span></label>
                    <input type="password" class="form-control" id="passwordCheck" data-rule-required="true" placeholder="password Check" maxlength="30">
                </div>
            </div>
            
            <div class="form-group row" id="divName">
                <div class="col-lg-12">
                <label for="inputName" class="text-black">Full Name <span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="userNm" name="userNm" data-rule-required="true" placeholder="Full name" maxlength="8">
                </div>
            </div>
            
             <div class="form-group row" id="birth">
                <div class="col-lg-12">
                <label for="birth" class="text-black">Birth <span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="birth" name="birth" data-rule-required="true" placeholder="Birth" maxlength="8">
                </div>
            </div>
            
             
            <div class="form-group row" id="divEmail">
                <div class="col-lg-12">
                <label for="inputEmail" class="text-black">Email <span class="text-danger">*</span></label>
                    <input type="email" class="form-control" id="email" name="email" data-rule-required="true" placeholder="Email" maxlength="40">
                </div>
            </div>
            
            <div class="form-group row" id="divTEL">
                <div class="col-lg-12">
                <label for="inputTEL" class="text-black">Phone Num<span class="text-danger">*</span></label>
                    <input type="tel" class="form-control onlyNumber" id="TEL" name="tel" data-rule-required="true" placeholder="Please enter only numbers except-." maxlength="11">
                </div>
            </div>
            
            <div class="form-group row">
                <div class="col-lg-12">
                <label for="inputTEL" class="text-black">Sex <span class="text-danger">*</span></label>
                    <select class="form-control" id="gender" name="gender">
                        <option value="F">Female</option>
                        <option value="M">Male</option>
                    </select>
                </div>
            </div>
            
            <div class="form-group row" >
                <div class="col-lg-12">
                <label for="addrFull" class="text-black">Full Address </label>
                       <input type="text" class="form-control" id="addrfull" name="addrFull" data-rule-required="true" placeholder="배송지주소" maxlength="100">
                </div>
            </div>
            
            <div class="form-group row">
                <div class="col-lg-12">
                <label for="inputTEL" class="text-black">ZIP CODE</label>
                       <input type="text" class="form-control" id="zipcode" name="zipcode" data-rule-required="true" placeholder="배송지 ZIP CODE(우편번호)" maxlength="10">
                </div>
            </div>
            
            <!-- <div class="form-group row">
                <div class="col-lg-12">
                <label for="inputEmailReceiveYn"class="text-black">e-mail Reveive</label>
                    <label class="radio-inline">
                        <input type="radio" id="emailReceiveYn" name="emailReceiveYn" value="Y" checked> I Agree.
                    </label>
                    <label class="radio-inline">
                        <input type="radio" id="emailReceiveYn" name="emailReceiveYn" value="N"> 동의하지 않습니다.
                    </label>
                </div>
            </div>
            
            <div class="form-group row">
                <div class="col-lg-12">
                <label for="inputTEL"class="text-black">SMS Reveive</label>
                    <label class="radio-inline">
                        <input type="radio" id="smsReceiveYn" name="smsReceiveYn" value="Y" checked> 동의합니다.
                    </label>
                    <label class="radio-inline">
                        <input type="radio" id="smsReceiveYn" name="smsReceiveYn" value="N"> 동의하지 않습니다.
                    </label>
                </div>
            </div> -->
            
            <div class="form-group row">
                <div class="col-lg-offset-2 col-lg-10">
                    <button type="button" id="submit" class="btn btn-default" onclick="join();">Sign up</button>
                </div>
            </div>`
        
        </div>
        </form>
         
         
        <script>
         
            $(function(){
                //매치... 정규식
                $('.onlyAlphabetAndNumber').keyup(function(event){
                    if (!(event.keyCode >=37 && event.keyCode<=40)) {
                        var inputVal = $(this).val();
                        $(this).val($(this).val().replace(/[^_a-z0-9]/gi,'')); //_(underscore), 영어, 숫자만 가능
                    }
                });
                 
                $("#userNm").keyup(function(event){
                    if (!(event.keyCode >=37 && event.keyCode<=40)) {
                        var inputVal = $(this).val();
                        $(this).val(inputVal.replace(/[a-z0-9]/gi,''));
                    }
                });
             
                $(".onlyNumber").keyup(function(event){
                    if (!(event.keyCode >=37 && event.keyCode<=40)) {
                        var inputVal = $(this).val();
                        $(this).val(inputVal.replace(/[^0-9]/gi,''));
                    }
                });
                 
                //------- 검사하여 상태를 class에 적용
                $('#userId').keyup(function(event){
                     
                    var divId = $('#divId');
                     
                    if($('#userId').val()==""){
                        divId.removeClass("has-success");
                        divId.addClass("has-error");
                    }else{
                        divId.removeClass("has-error");
                        divId.addClass("has-success");
                    }
                });
                 
                $('#password').keyup(function(event){
                     
                    var divPassword = $('#divPassword');
                     
                    if($('#password').val()==""){
                        divPassword.removeClass("has-success");
                        divPassword.addClass("has-error");
                    }else{
                        divPassword.removeClass("has-error");
                        divPassword.addClass("has-success");
                    }
                });
                 
                $('#passwordCheck').keyup(function(event){
                     
                    var passwordCheck = $('#passwordCheck').val();
                    var password = $('#password').val();
                    var divPasswordCheck = $('#divPasswordCheck');
                     
                    if((passwordCheck=="") || (password!=passwordCheck)){
                        divPasswordCheck.removeClass("has-success");
                        divPasswordCheck.addClass("has-error");
                    }else{
                        divPasswordCheck.removeClass("has-error");
                        divPasswordCheck.addClass("has-success");
                    }
                });
                 
                $('#userNm').keyup(function(event){
                     
                    var divName = $('#divName');
                     
                    if($.trim($('#userNm').val())==""){
                        divName.removeClass("has-success");
                        divName.addClass("has-error");
                    }else{
                        divName.removeClass("has-error");
                        divName.addClass("has-success");
                    }
                });
                 
                /* $('#nickname').keyup(function(event){
                     
                    var divNickname = $('#divNickname');
                     
                    if($.trim($('#nickname').val())==""){
                        divNickname.removeClass("has-success");
                        divNickname.addClass("has-error");
                    }else{
                        divNickname.removeClass("has-error");
                        divNickname.addClass("has-success");
                    }
                 });*/
                 
                $('#email').keyup(function(event){
                     
                    var divEmail = $('#divEmail');
                     
                    if($.trim($('#email').val())==""){
                        divEmail.removeClass("has-success");
                        divEmail.addClass("has-error");
                    }else{
                        divEmail.removeClass("has-error");
                        divEmail.addClass("has-success");
                    }
                });
                 
                $('#TEL').keyup(function(event){
                     
                    var divTEL = $('#divTEL');
                     
                    if($.trim($('#TEL').val())==""){
                        divTEL.removeClass("has-success");
                        divTEL.addClass("has-error");
                    }else{
                        divTEL.removeClass("has-error");
                        divTEL.addClass("has-success");
                    }
                });
            });
             
        </script>
        <script>
        //모달을 전역변수로 선언
        var modalContents = $(".modal-contents");
        var modal = $("#defaultModal");
        
        //------- validation 검사
        function join() {
        	var f = $("#from");
        	var formData = {
        			userId: $("#userId").val(),
        			userNm: $("#userNm").val(),
        			userPw: $("#password").val(),
        			birth: $("#birth").val(),
        			email: $("#email").val(),
        			tel: $("#TEL").val(),
        			//state: $("#state").val(),
        			gender: $("#gender").val(),
        			emailReceiveYn: $("#emailReceiveYn").val(),
        			smsReceiveYn: $("#smsReceiveYn").val(),
        			addrfull: $("#addrfull").val(),
        			zipcode: $("#zipcode").val()
        	};
            var provision = $('#provision');
            var memberInfo = $('#memberInfo');
            var divId = $('#divId');
            var divPassword = $('#divPassword');
            var divPasswordCheck = $('#divPasswordCheck');
            var divName = $('#divName');
            var divNickname = $('#divNickname');
            var divEmail = $('#divEmail');
            var divTEL = $('#divTEL');


            
            //회원가입약관
            if($('#provisionYn:checked').val()=="N"){
                modalContents.text("회원가입약관에 동의하여 주시기 바랍니다."); //모달 메시지 입력
                modal.modal('show'); //모달 띄우기
                 
                provision.removeClass("has-success");
                provision.addClass("has-error");
                $('#provisionYn').focus();
                return false;
            }else{
                provision.removeClass("has-error");
                provision.addClass("has-success");
            }
             
            //개인정보취급방침
            if($('#memberInfoYn:checked').val()=="N"){
                modalContents.text("개인정보취급방침에 동의하여 주시기 바랍니다.");
                modal.modal('show');
                 
                memberInfo.removeClass("has-success");
                memberInfo.addClass("has-error");
                $('#memberInfoYn').focus();
                return false;
            }else{
                memberInfo.removeClass("has-error");
                memberInfo.addClass("has-success");
            }
             
            //아이디 검사
            if($("#userId").val()== ""){
                modalContents.text("Please enter your ID.");
                modal.modal('show');
                 
                divId.removeClass("has-success");
                divId.addClass("has-error");
                $('#userId').focus();
                return false;
            }else{
                divId.removeClass("has-error");
                divId.addClass("has-success");
            }
             
            //패스워드 검사
            if($('#password').val()==""){
                modalContents.text("Please enter a password.");
                modal.modal('show');
                 
                divPassword.removeClass("has-success");
                divPassword.addClass("has-error");
                $('#password').focus();
                return false;
            }else{
                divPassword.removeClass("has-error");
                divPassword.addClass("has-success");
            }
             
            //패스워드 확인
            if($('#passwordCheck').val()==""){
                modalContents.text("Please enter a password check.");
                modal.modal('show');
                 
                divPasswordCheck.removeClass("has-success");
                divPasswordCheck.addClass("has-error");
                $('#passwordCheck').focus();
                return false;
            }else{
                divPasswordCheck.removeClass("has-error");
                divPasswordCheck.addClass("has-success");
            }
             
            //패스워드 비교
            if($('#password').val()!=$('#passwordCheck').val() || $('#passwordCheck').val()==""){
                modalContents.text("Password does not match.");
                modal.modal('show');
                 
                divPasswordCheck.removeClass("has-success");
                divPasswordCheck.addClass("has-error");
                $('#passwordCheck').focus();
                return false;
            }else{
                divPasswordCheck.removeClass("has-error");
                divPasswordCheck.addClass("has-success");
            }
             
            //이름
            if($('#userNm').val()==""){
                modalContents.text("Please enter your name.");
                modal.modal('show');
                 
                divName.removeClass("has-success");
                divName.addClass("has-error");
                $('#userNm').focus();
                return false;
            }else{
                divName.removeClass("has-error");
                divName.addClass("has-success");
            }
             
            //별명
            
            /* if($('#nickname').val()==""){
                modalContents.text("별명을 입력하여 주시기 바랍니다.");
                modal.modal('show');
                 
                divNickname.removeClass("has-success");
                divNickname.addClass("has-error");
                $('#nickname').focus();
                return false;
            }else{
                divNickname.removeClass("has-error");
                divNickname.addClass("has-success");
            } */
             
            //이메일
            if($('#email').val()==""){
                modalContents.text("Please enter your E-mail.");
                modal.modal('show');
                 
                divEmail.removeClass("has-success");
                divEmail.addClass("has-error");
                $('#email').focus();
                return false;
            }else{
                divEmail.removeClass("has-error");
                divEmail.addClass("has-success");
            }
             
            //휴대폰 번호
            if($('#TEL').val()==""){
                modalContents.text("Please enter your Tel.");
                modal.modal('show');
                 
                divTEL.removeClass("has-success");
                divTEL.addClass("has-error");
                $('#TEL').focus();
                return false;
            }else{
                divTEL.removeClass("has-error");
                divTEL.addClass("has-success");
            }
            
			//id 중복검사
			$.ajax({
				url: "/member/joinProcess",
			    type: "POST",
			    data: JSON.stringify(formData),
			    contentType: 'application/json',
			    dataType: "json",
			    success: function(data){
				    if(data.MSG == "FAIL") {
					    console.log(data.MSG);
					    console.log(data.cd);
						if(data.cd == "idCheck") {
							alert("This ID is already taken. Please enter again.");
							$("#userId").focus();
							return false;
						} else if(data.cd == "telCheck") {
							alert("The mobile number is already in use. Please enter again");
							$("#TEL").focus();
							return false;
						} else if (data.cd == "join") {
							alert("Failed to join please try again.\n If you are still unable to sign up, please contact the customer center.");
							location.href="/member/join";
						} else {
							alert("Unknown error. Contact your administrator");
							location.href="/";
						}
						
					} else {
						alert("Sign up is complete.\n Congratulations on becoming Evan's Health & Beauty.");			
						location.href="/";	
					}
				},
				error : function(request,status,error){
					  alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
			       }
			});	
            }
        </script>
   	</div>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />