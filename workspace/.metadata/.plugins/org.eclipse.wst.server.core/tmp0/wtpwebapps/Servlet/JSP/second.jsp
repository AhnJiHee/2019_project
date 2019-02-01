<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
<% 
out.println(out.getBufferSize());
out.println(new Date()); 
out.println(out.getRemaining());
// 버퍼 내용 초과 시 일단 브라우저에 출력 + 비움 + 다시 출력 (buffer flushing)
// 사실 auto flush 해주니까 신경 안써도 된다
%>


</h1>
</body>
</html>