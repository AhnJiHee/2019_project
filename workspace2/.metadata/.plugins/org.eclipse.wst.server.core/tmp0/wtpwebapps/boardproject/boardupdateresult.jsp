<%@page import="vo.BoardVO"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 완료</title>

<style>
table{text-align: center; margin: auto; border: 1px solid purple;}
</style>

</head>
<body>

<%
int seq = (Integer) session.getAttribute("boardseq");
BoardVO vo = (BoardVO) session.getAttribute("boardvo");
String boardwriter = vo.getBoardwriter();

String newtitle = (String) request.getParameter("newtitle");
String newcontents = (String) request.getParameter("newcontents");
BoardDAO dao = new BoardDAO();

dao.updateBoard(seq, newtitle, newcontents);

%>

<table border="2px">
<tr>
	<td>제목</td><td><%=newtitle %></td>
</tr>
<tr>
	<td>작성자</td><td><%=boardwriter %></td>
</tr>
<tr>
	<td height="300">내용</td><td width=500><%=newcontents %></td>
</tr>
</table>

<h1> 수정되었습니다. </h1>
<form action="boardlist.jsp">
<input type=submit value="목록으로 돌아가기">
</form>



</body>
</html>