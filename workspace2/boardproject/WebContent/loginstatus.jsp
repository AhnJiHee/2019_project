<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보창</title>
<script src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	$("#logout").on("click", function(){
		alert("로그아웃 되었습니다");
	}); // logout end
	}); // ready end
</script>
</head>
<body>

<%
String result ="";
	if ( session.getAttribute("id") != null && session.getAttribute("password") != null){
		String id = (String) session.getAttribute("id");
		String pw = (String) session.getAttribute("password");
		result = id + " 회원님 환영합니다.<br>"
			+ "<form id='logout' action = 'logout.jsp'> <input type=submit value='로그아웃'> </form>";
	} else{
		result = "로그인이 필요합니다.<br>"
			+ "<a href = login.jsp>돌아가기</a>";
	}
%>
<table id="left" border=1>
<tr>
<td><h3><%=result %></h3></td>
</tr>
</table>


</body>
</html>