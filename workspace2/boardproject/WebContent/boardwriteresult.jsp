<%@page import="dao.BoardDAO"%>
<%@page import="vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 저장 결과</title>

<style>
table{text-align: center; margin: auto; border: 1px solid purple;}
</style>

</head>
<body>

<%
String boardtitle = (String) request.getParameter("boardtitle");
String boardcontents = (String) request.getParameter("boardcontents");
String boardwriter = (String) session.getAttribute("id");
BoardVO vo = new BoardVO(boardtitle, boardcontents, boardwriter);
BoardDAO dao = new BoardDAO();
dao.insertBoard(vo);

%>

<table border="2px">
<tr>
<td>제목</td><td><%=boardtitle %></td>
</tr>
<tr>
<td>작성자</td><td><%=boardwriter %></td>
</tr>
<tr>
<td height="300">내용</td><td width=500><%=boardcontents %></td>
</tr>
</table>

<h1 align="center"> 저장되었습니다. </h1>

<form action="boardlist.jsp">
<input type=submit value="목록으로 돌아가기">
</form>

</body>
</html>