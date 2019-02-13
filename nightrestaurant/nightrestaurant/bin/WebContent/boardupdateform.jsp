<%@page import="vo.BoardVO"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>

<style>
	.center{text-align: center; margin: auto;}
	table.list{text-align: center; margin: auto; border: 3px solid purple;}
</style>

<script src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#up").on("click", function(){
		var up=$("#test").val();
		var newtitle=$("input[name='newtitle']").val();
		var newcontents=$("textarea[name='newcontents']").val();
		var param="action="+up+"&newtitle="+newtitle+"&newcontents="+newcontents
		alert(param);
		$.ajax({
			type: "get",
			url: "board",
			data: param,
			success: function(data) {
				$(".detail").html(data);
			}
		});
	}); // update end
	
	$(".back").on("click", function(){
		var referrer =  document.referrer;
		location.href = "main";
	});// back end
	
}); // ready end
</script>
	
</head>
<body>
<%
int seq = (Integer) session.getAttribute("boardseq");
BoardDAO dao = new BoardDAO();
BoardVO vo = (BoardVO) session.getAttribute("boardvo");
int boardviewcount = vo.getBoardviewcount();

String boardtitle = vo.getBoardtitle();
String boardcontents = vo.getBoardcontents();
String boardwriter = vo.getBoardwriter();
String boardtime = vo.getBoardtime();
%>

<div class="detail">
	<table class="list" border="2px">
		<tr>
			<td>게시물 번호</td>
			<td><%=seq%></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type=text name="newtitle" placeholder=<%=boardtitle%>></td>
		</tr>
		<tr>
			<td height = 300>내용</td>
			<td><textarea cols=70 rows=25 name="newcontents" placeholder=<%=boardcontents%>></textarea></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%=boardwriter%></td>
		</tr>
		<tr>
			<td>작성 시간</td>
			<td><%=boardtime%></td>
		</tr>
		<tr>
			<td>조회수</td>
			<td><%=boardviewcount%></td>
		</tr>
	</table>
	
	<table class="center">
	<tr>
		<td>
			<input type=button id="up" value="수정">
		</td>
		<td>
			<input type=button class='back' value="뒤로가기">
		</td>
	</tr>
	</table>
</div>

</body>
</html>