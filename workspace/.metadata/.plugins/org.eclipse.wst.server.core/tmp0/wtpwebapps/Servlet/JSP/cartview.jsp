<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 조회</title>
</head>
<body>

<h1> 장바구니 저장 내용은 다음과 같습니다. </h1>
<%
String product = (String) session.getAttribute("sessionproduct");
String productname = (String) session.getAttribute("sessionname");
int balance = (Integer) session.getAttribute("sessionbalance");
int price = (Integer) session.getAttribute("sessionprice");
%>

<H1> <%=productname %> :  <%=price %> </H1>
<H1> 구입 수량은 <%=balance%> 입니다. </H1>

<form action = "/Servlet/shop">
<input type="submit" value="메인으로 이동">
</form>

</body>
</html>