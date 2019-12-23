<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<script>

function getParam(name) {
	var se = location.search;
	if (se.length > 0) {
		var params = se
			.substring(1)
			.split('&')
			.map(function(e) { return e.split('='); })
			.filter(function(e) { return e[0] == name; });
		if (params.length > 0) {
			return decodeURIComponent(params[0][1]);
		}
	}
	return null;
}
</script>

<style type="text/css">
	body {
		color: #fff;
		background: #3598dc;
	}
	.form-control {
		min-height: 41px;
		background: #f2f2f2;
		box-shadow: none !important;
		border: transparent;
	}
	.form-control:focus {
		background: #e2e2e2;
	}
	.form-control, .btn {        
        border-radius: 2px;
    }
	.login-form {
		width: 350px;
		margin: 30px auto;
		text-align: center;
	}
	.login-form h2 {
        margin: 10px 0 25px;
    }
    .login-form form {
		color: #7a7a7a;
		border-radius: 3px;
    	margin-bottom: 15px;
        background: #fff;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form .btn {        
        font-size: 16px;
        font-weight: bold;
		background: #3598dc;
		border: none;
        outline: none !important;
    }
	.login-form .btn:hover, .login-form .btn:focus {
		background: #2389cd;
	}
	.login-form a {
		color: #fff;
		text-decoration: underline;
	}
	.login-form a:hover {
		text-decoration: none;
	}
	.login-form form a {
		color: #7a7a7a;
		text-decoration: none;
	}
	.login-form form a:hover {
		text-decoration: underline;
	}
</style>
</head>
<body>
<div class="login-form">
        <h2 class="text-center">Login</h2>   
        <div class="form-group has-error">
        	<input type="text" class="form-control" name="loginId" placeholder="Username" required="required" id="loginId">
        </div>
		<div class="form-group">
            <input type="password" class="form-control" name="userPw" placeholder="Password" required="required" id="userPw">
        </div>        
        <div class="form-group">
            <button type="button" onclick="doLogin()" class="btn btn-primary btn-lg btn-block">Sign in</button>
        </div>
        <!-- <p><a href="#">Lost your Password?</a></p>  -->
    <p class="text-center small">Don't have an account? <a href="#">Sign up here!</a></p>
</div>

 <script type="text/javascript">
      function doLogin(){
    		var formData = {
    				userId: $("#loginId").val(),
    				userPw: $("#userPw").val(),
    				url: getParam('url')+"?"+window.location.search.replace().split("&")[1]
    		};
    		$.ajax({
    			url: "/login",
    			method: "post",
    		    cache: false,
    		    type: "json",
    		    dataType: "json",
    		    contentType: 'application/json',
    		    data: JSON.stringify(formData),
    		    success: function(data){
        		    location.href=formData.url;
    			}
    		});	
    	}
      </script>

</body>
</html>