<%@page import="vo.BoardVO"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 완료</title>
<style>
	.center{text-align: center; margin: auto;}
	input{margin: auto;}
</style>
</head>
<body>
<%
int seq = (Integer) session.getAttribute("boardseq");
BoardDAO dao = new BoardDAO();
dao.deleteBoard(seq);
%>
<h1 align="center">삭제가 완료되었습니다.</h1>

<form class="center" action="mainpage.jsp">
<input type=submit value="메인으로 돌아가기">
</form>
</body>
</html>