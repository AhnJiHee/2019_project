<%@page import="vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> usebean 태그 연습 </title>
</head>
<body>

<%-- <%
BoardVO vo = new BoardVO();
vo.setSeq(10);
vo.setTitle("10번 게시물");
vo.setContents("10번 게시물 내용입니다");
vo.setViewcount(500);
%>

<h1>
번호 : <%= vo.getSeq()  %> <br>
제목 : <%= vo.getTitle()  %> <br>
내용 : <%= vo.getContents()  %> <br>
조회수 : <%= vo.getViewcount()  %>
</h1> --%>

<hr>
<h1> 액션 태그 이용 </h1>

<jsp:useBean id="vo2" class="vo.BoardVO" scope="request"/>
<%-- <jsp:setProperty name="vo2" property="seq" />
<jsp:setProperty name="vo2" property="title" />
<jsp:setProperty name="vo2" property="contents" />
<jsp:setProperty name="vo2" property="viewcount" /> --%>
<jsp:setProperty property="*" name="vo2"/>
<jsp:forward page="usebean2.jsp"/>

</body>
</html>