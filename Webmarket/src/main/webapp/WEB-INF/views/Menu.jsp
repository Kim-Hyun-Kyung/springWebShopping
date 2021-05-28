<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value='/'/>">HOME</a>
				<a class="navbar-brand" href="<c:url value='/products.do'/>"> 상품목록</a>
				<a class="navbar-brand" href="<c:url value='/addmin/addProduct'/>">상품등록</a>
			</div>
			<div>
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link" href="<c:url value='/user/login'/>">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/addMember'/>">회원가입</a></li>
					
					<li style="padding-top:7px; color:white">님</li>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/logout.do'/>">로그아웃</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/updateMember.do'/>">회원정보 수정</a></li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>