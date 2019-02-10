<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<script type="text/javascript" src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#login").click(function() {
		var id=$("#id").val();
		var pw=$("#pw").val();
		var param="id="+id+"&pw="+pw;
		$.ajax({
			type: "get",
			url: "login",
			data: param,
			success: function(data) {
				$(".login").html(data);
			}
		});
	}); // login end
}); // ready end
</script>
</head>
<body>

<div class="login">
	<table class="left" border="2">
		<tr>
			<td><input type=text id="id" name="id" placeholder="아이디"></td>
			<td rowspan=2><input type="button" id="login" value="로그인"></td>
		</tr>
		<tr>
			<td><input type=text id="pw" name="pw" placeholder="비밀번호"></td>
		</tr>
	</table> 
<a class="left" href = "signin.jsp">회원가입 하러 가기</a>
</div>

</body>
</html>