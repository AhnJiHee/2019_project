<%@page import="vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 검색</title>

<style>
table{text-align: center; margin: auto; border: 1px solid purple;}
</style>

<!-- Jquery 작성부 -->
<script src="jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#write").on('click', function(){
		location.href="boardwriteform.jsp"
	}); // onclick end
}); // ready end
</script>
</head>

<body>
<h1 align = center>검색된 내용입니다.</h1>

<table border="2px">
<tr>
<td>번호</td><td width="250">제목</td><td>작성자</td><td>작성시간</td><td>조회수</td>
</tr>
<% 
	String tag = (String) request.getParameter("tag");
	String word = (String) request.getParameter("word");
	BoardDAO dao = new BoardDAO();
	ArrayList<BoardVO> list = dao.getBoardList(tag, word);
	
	for (int i = 0; i < list.size(); i++) {
	BoardVO vo = list.get(i);
	out.println ("<tr><td>" + vo.getBoardseq() + "</td><td>"
						+ "<a href = 'boarddetails.jsp?boardseq="+vo.getBoardseq()+" '>"
						+ vo.getBoardtitle() + "</a></td><td>"
						+ vo.getBoardwriter() + "</td><td>"
						+ vo.getBoardtime() + "</td><td>"
						+ vo.getBoardviewcount() + "</td></tr>");
	} // for문 end
%>
</table> 

<table>
<tr>
	<td>
		<form action="boardlist.jsp">
		<input type=submit value="목록으로 돌아가기">
		</form>
	</td>
</tr>
</table>

</body>
</html>