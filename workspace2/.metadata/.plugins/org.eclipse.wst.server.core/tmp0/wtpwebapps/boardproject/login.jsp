<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
</head>
<body>
<%



%>

<table border="1">
<form action="login">
	<tr>
		<td><input type=text name="id" placeholder="아이디"></td>
		<td rowspan=2><input type="submit" value="로그인"></td>
	</tr>
	<tr>
		<td><input type=text name="pw" placeholder="비밀번호"></td>
	</tr>
</form>
</table> <!-- 로그인 창 -->
<a href = "signin.jsp">회원가입 하러 가기</a>
</body>
</html>