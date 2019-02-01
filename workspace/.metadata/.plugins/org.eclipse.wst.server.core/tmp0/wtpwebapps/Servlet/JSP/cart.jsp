<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 저장</title>
</head>
<body>
<%
String product = request.getParameter("product");
String productname = product.split(":")[0];
int balance = Integer.parseInt(request.getParameter("balance"));
int price = Integer.parseInt(product.split(":")[1]);
%>
<%
session.setAttribute("sessionproduct", product);
session.setAttribute("sessionname", productname);
session.setAttribute("sessionbalance", balance);
session.setAttribute("sessionprice", price);
%>

<H1> 장바구니에 저장한 제품은 <%=productname%>이고
					가격은 <%=price %>입니다.</H1>
<H1> 구입 수량은 <%=balance%> 입니다. </H1>

<form action = "/Servlet/shop">
<input type="submit" value="메인으로 이동">
</form>

</body>
</html>