<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 메인</title>
<script src=
"http://localhost:8081/Servlet/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	  $("#list").on('click', function(){
		  location.href=
		  "http://localhost:8081/Servlet/shop?menu=productlist";
	  });
	  $("#view").on('click', function(){
		  location.href="JSP/cartview.jsp";
	  });
	  $("#pay").on('click', function(){
		  location.href="JSP/pay.jsp";
	  });
})
</script>

</head>
<body>
<h1> 우리 쇼핑몰에 오신 것을 환영합니다! </h1>
<input type="button" id = "list" value="상품 리스트 보기">
<input type="button" id = "view" value="장바구니 조회">
<input type="button" id = "pay" value="결제">
<h1> 오늘은 생필품을 세일하고 있습니다. </h1>

</body>
</html>