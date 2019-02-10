<%@page import="vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 입력</title>

<style>
	.center{text-align: center; margin: auto;}
	table.list{text-align: center; margin: auto; border: 3px solid purple;}
</style>

</head>
<body>
<table class="list">
<form action="boardwriteresult.jsp">
<tr>
<td><input type=text name="boardtitle" placeholder = "제목을 입력하세요"></td>
</tr>
<tr>
<td><textarea rows=20 cols=100 name="boardcontents" placeholder = "내용을 입력하세요"></textarea></td>
</tr><tr>
<td><p>작성자 : <%=session.getAttribute("id") %></p></td>
</tr>
<tr>
<td><input type=submit value="저장"></td>
</tr>
</form>
</table>
<form class="center" action="mainpage.jsp"><input type=submit value="메인으로 돌아가기"></form>




</body>
</html>