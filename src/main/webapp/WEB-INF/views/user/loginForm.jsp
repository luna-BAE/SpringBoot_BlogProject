<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

	<form action="/auth/loginProc" method="post">
	
		<div class="form-group">
			<label for="username">Username</label> <input type="text"
				class="form-control" name = "username" placeholder="Enter username" id="username">
		</div>
		
		<div class="form-group">
			<label for="password">Password</label> <input type="password"
				class="form-control" name = "password" placeholder="Enter password" id="password">
		</div>
		
		<button id="btn-login" class="btn btn-primary">Login</button>
		<a href = "https://kauth.kakao.com/oauth/authorize?client_id=49697cd67d300c5c29caa16b6a5cf812&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code">
		<img height = "38px" src = "/image/kakao_login_button.png"/></a>
	</form>

		
</div>

<%@ include file="../layout/footer.jsp"%>