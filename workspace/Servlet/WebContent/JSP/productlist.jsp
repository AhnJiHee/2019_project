<%@page import="java.util.ArrayList" import = "vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--1. ArrayList 타입의 productlist 속성값 읽어오기
	2. 1번 조회
	3. xxx.getName() : select - option 태그로 구성
	4. 선택 상품명 구입 수량 입력  
	<input type = text name = balance
	5. option 태그 선택 상품명, 구입 수량 => cart.jsp로 전송 ... 
	-->
<% 
ArrayList<ProductVO> list = (ArrayList<ProductVO>) request.getAttribute("productlist");
%>
<form action = "JSP/cart.jsp">
<select name="product">
<% for (ProductVO vo : list){ %>
	<option value =	'<%=vo.getName() +":"+vo.getPrice()%>'>
	<%=vo.getName()%> 
	</option> 
<%
}
%>
</select>
<input type = text name = "balance" placeholder = "원하는 수량을 입력하세요">
<input type = submit value ="장바구니 저장">
</form>

</body>
</html>