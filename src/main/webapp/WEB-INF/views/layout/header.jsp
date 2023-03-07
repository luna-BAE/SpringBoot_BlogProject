<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
	 
	System.out.println("==============");
	//System.out.println("" + session.getAttribute(principal.get("id")));
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- 자바스크립트는 인터프리터 언어이기 때문에 순서대로 실행함. 따라서 스크립트는 하단에 작성해야 하는 경우가 발생 -->
</head>
<body>

	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="/">홈</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">

			<c:choose>
				<c:when test="${empty sessionScope.principal}">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/loginForm">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="/joinForm">회원가입</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/board/form">글쓰기</a></li>
						<li class="nav-item"><a class="nav-link" href="/user/form">회원정보</a></li>
						<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
					</ul>
				</c:otherwise>
			</c:choose>
			
		</div>
	</nav>
	<br />