<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.Base64"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>R 시각화 결과 표현하기</h1>
<hr>
<%
if(request.getAttribute("img_content") != null) {      
   byte src[] = (byte[])request.getAttribute("img_content");
%>
   <img src="
      data:image/jpg;base64, <%= Base64.getEncoder().encodeToString(src) %>"
      width="400" height="300">
<%
} 
%>   

</body>
</html>