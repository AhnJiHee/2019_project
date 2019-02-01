<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 확인 화면</title>
<style type="text/css">

h3{
	text-align : center;
	font-size : 25px;
	width : 500px;
	border : 1px dashed red;
	background-color : pink;
}
</style>
</head>
<body>

<h1> login 2. jsp 파일 영역입니다 </h1>
<h2> <%=request.getParameter("a") %> </h2>

<h1> 입력한 회원가입 정보는 다음과 같습니다 </h1>
<% MemberVO vo = (MemberVO) request.getAttribute("memberinfo"); %>
<h3>  <%= vo %>  </h3>

</body>
</html>