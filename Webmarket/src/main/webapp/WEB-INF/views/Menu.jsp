<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value='/'/>">HOME</a>
				<a class="navbar-brand" href="<c:url value='/products.do'/>"> PRODUCT</a>
				<a class="navbar-brand" href="<c:url value='/addProduct.do'/>"> ADDPRODUCT</a>
			</div>
		</div>
	</nav>
</body>
</html>