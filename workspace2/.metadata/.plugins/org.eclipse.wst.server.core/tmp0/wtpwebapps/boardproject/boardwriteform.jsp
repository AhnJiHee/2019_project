<%@page import="vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 입력</title>

<style>
table{text-align: center; margin: auto; border: 1px solid purple;}
</style>

</head>
<body>
<table>
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
<form action="boardlist.jsp"><input type=submit value="목록으로 돌아가기"></form>




</body>
</html>