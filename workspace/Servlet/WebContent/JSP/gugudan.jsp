<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
<style type = "text/css">
table, td {border : 2px solid olive; text-align : center;}
tr {font-family: 맑은고딕; font-size: 1.5em}
</style>
</head>

<body>

<%
int dan = 0;
String inputdan = request.getParameter("dan");
	
if (inputdan == null){
	dan = 2;
} else{
	dan = Integer.parseInt(request.getParameter("dan"));
}

%>

<form action = "gugudan.jsp" method = "post">
단을 입력하세요 : <input type = text name = dan>
<input type = submit value = "계산">
</form>

<table>
<%
for(int i = 1; i<10; i++){
	out.println("<tr>");
	for(int j = 2; j <= dan; j++){
	out.println("<td>" + j + "*" + i + "=" + j*i + "</td>");		
	}
	out.println("</tr>");
}
%>
</table>

<h1> 클라이언트 ip : <%= request.getRemoteAddr() %></h1>

</body>
</html>