<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑목록</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<script>
	function fn_detail(id){
		var frm = document.forms['detailform'];
		document.getElementById("productPk").value=id;
		frm.submit();
	}
</script>
<body>
	<jsp:include page="Menu.jsp"/>
	<form name="detailform" method="post" action="/detail.do">
		<div class="jumbotron">
			<div class="container">
				<h1 class="display-3">상품 목록</h1>
			</div>
		</div>
		<div class="container" >
			<div class="row" align="center">
				<c:forEach items="${list}" var="dto">
					<div class="col-md-6">		
						<img src="/images/${dto.filename}" style="width:50%"/>
						<h3>${dto.pname}</h3>
						<p>${dto.description}</p>
						<p>${dto.unitPrice}원</p>				
							<a href="#"
								class="btn btn-secondary" role="button" onclick="fn_detail('${dto.productId}');">상세정보 &raquo;</a>
							<input type="hidden" id="productPk" name="productPk" value="${dto.productId}"/>
					</div>
				</c:forEach>
			</div>
		</div>
		</form>		
	<jsp:include page="Footer.jsp"/>
</body>
</html>