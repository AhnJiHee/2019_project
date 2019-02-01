<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="vo2" class="vo.BoardVO" scope="request"/>
<h1>
번호 : <jsp:getProperty name="vo2" property="seq"/> <br>
제목 : <jsp:getProperty name="vo2" property="title"/> <br>
내용 : <jsp:getProperty name="vo2" property="contents"/> <br>
조회수 : <jsp:getProperty name="vo2" property="viewcount"/> 
</h1>

</body>
</html>