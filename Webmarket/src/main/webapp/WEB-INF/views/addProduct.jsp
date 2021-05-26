<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	
function ValidationProduct(){
	var productId = document.getElementById("productId");
	var name = document.getElementById("name");
	var unitPrice = document.getElementById("unitPrice");
	var unitsInStock=document.getElementById("unitsInStock");
	
	if(!check(/^P[0-9]{4,11}$/,productId,"[상품코드]\nP와 숫자를 조합하여 5~12자 까지 입력하세요 \n 첫 글자는 반드시 P로 시작하세요"))
		return false;
	
	if(name.value.length<4 || name.value.length>20){
		alert("[상품명]\n 최소 4자에서 20자 까지 입력하세요.");
		name.select();
		name.focus();
			return false;
	}
		if(unitPrice.value.length==0 || isNaN(unitPrice.value)){
		alert("[가격]\n 숫자만 입력이 가능합니다.");
		unitPrice.select();
		unitPrice.focus();
		return false;
	}
	
	if(unitPrice.value<0){
		alert("[가격]\n 음수는 입력할 수 없습니다.");
		unitPrice.select();
		unitPrice.focus();
		return false;
	}else if(!check(/^\d+(?:[.]?[\d]?[\d])?$/,unitPrice,"[가격]\n 소수점 둘째 자리까지만 입력할 수 있습니다."))
		return false;
	
	if(isNaN(unitsInStock.value)){
		alert("[재고 수]\n 숫자만 입력해주세요.");
		unitsInStock.select();
		unitsInStock.focus();
		return false;
	}
	
	function check(regExp,e,msg){
		if(regExp.test(e.value)){return true;}
		
		alert(msg);
		e.select();
		e.focus();	
		return false;		
	}
	document.newProduct.submit()
}
</script>
<body>
	<jsp:include page="Menu.jsp"/>
	<div class="jumbotron">
		<div class="conainer">
			<h1 class="display-3">상품 등록</h1>			
		</div>
	</div>
	<div class="container">
		<form name="newProduct" action="/processAddProduct.do"
			class="form-forizontal" method="post" enctype="multipart/form-data">
			<div class="form-group row">
				<label class="col-sm-2">상품코드</label>
				<div class="col-sm-3">
					<input type="text" id="productId" name="productId" class="form-control">
				</div>
			</div>
				<div class="form-group row">
				<label class="col-sm-2">상품 명</label>
				<div class="col-sm-3">
					<input type="text" id="name" name="name" class="form-control">
				</div>
			</div>
				
			<div class="form-group row">
				<label class="col-sm-2">가격</label>
				<div class="col-sm-3">
					<input type="text" id="unitPrice" name="unitPrice" class="form-control">
				</div>
			</div>
				
			<div class="form-group row">
				<label class="col-sm-2">상세정보</label>
				<div class="col-sm-5">
					<textarea name="description" cols="50" rows="2" class="form-control"></textarea>
				</div>
			</div>
					
			<div class="form-group row">
				<label class="col-sm-2">제조사</label>
				<div class="col-sm-3">
					<input type="text" name="manufacturer" class="form-control">
				</div>
			</div>
				
			<div class="form-group row">
				<label class="col-sm-2">분류</label>
				<div class="col-sm-3">
					<input type="text" name="category" class="form-control">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">재고 수</label>
				<div class="col-sm-3">
					<input type="text" id="unitsInStock" name="unitsInStock" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상태</label>
				<div class="col-sm-5">
					<input type="radio" name="pcondition" value="New">신규 제품
					<input type="radio" name="pcondition" value="Old">중고 제품
					<input type="radio" name="pcondition" value="Refurbished">재생 제품
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">이미지</label>
				<div class="col-sm-5">
					<input type="file" name="productImage" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-2 col-sm-10">
					<input type="button" class="btn btn-primary" onclick="ValidationProduct()" value="등록">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="Footer.jsp"/>
</body>
</html>