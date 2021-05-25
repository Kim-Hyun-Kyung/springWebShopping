<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>	
	<div class="jumbotron">
		<div class="container">
			<div class="col-md-5">
				<img src="/images/${dto.filename}">
				<h3>${dto.pname}</h3>
				<p>${dto.description}</p>
				<p><b>상품코드</b> : 
					<span class="badge badge-danger">
						${dto.productId}
					</span>
				</p>
				<p><b>제조사</b> : ${dto.manufacturer }</p>
				<p><b>분류</b>: ${dto.category }</p>
				<p><b>재고 수</b>:${dto.unitsInStock }</p>
				<h4>${dto.unitPrice}원</h4>
				<p><a href="#" class="btn btn-info" onclick="fn_order">상품 주문 &raquo;</a></p>
				<a href="#" class="btn btn-secondary" onclick="fn_list">상품 목록 &raquo;</a>
			</div>
		</div>
	</div>
	<hr>
	<jsp:include page="Footer.jsp"/>
</body>
</html>