<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
<script src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	alert("로그아웃 되었습니다");
	}); // ready end
</script>
</head>
<body>
<%
session.invalidate();
response.sendRedirect("mainpage.jsp");
%>


</body>
</html>