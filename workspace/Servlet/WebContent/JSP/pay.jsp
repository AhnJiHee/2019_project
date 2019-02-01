<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 화면</title>
</head>
<body>
<h1>지불 수단을 선택하세요.</h1>
<form action="pay.jsp">
<input type="radio" name="pay" value = "현금">현금
<input type="radio" name="pay" value = "신용카드">신용카드
<input type="radio" name="pay" value = "핸드폰 소액 결제">핸드폰 소액 결제
<input type="submit" value="선택">
</form>

<%
String payment = (String) request.getParameter("pay");
String product = (String) session.getAttribute("sessionproduct");
String productname = (String) session.getAttribute("sessionname");
int balance = (Integer) session.getAttribute("sessionbalance");
int price = (Integer) session.getAttribute("sessionprice");
%>

<h1>선택한 제품은  <%=productname%> 이고 가격은 <%=price%>입니다. </h1>
<H1>구입 수량은 <%=balance%> 입니다. </H1>
<h1>총 지불 가격은 <%=balance * price%> 입니다. </h1>

<%
	if( payment != null) {
		out.println("<h1>선택하신 결제 수단은 " + payment + "입니다<h1>");
		session.removeAttribute("sessionproduct");
		session.removeAttribute("sessionbalance");
		out.println("<h1>장바구니를 비웠습니다. </h1>");%>
		
	<form action = "/Servlet/shop">
	<input type="submit" value="메인으로 이동">
	</form>	
<%}%>


</body>
</html>