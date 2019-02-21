<%@page import="vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 입력</title>

<style>
 	.center{text-align: center; margin: auto;}
	table.list{text-align: center; margin: 50px; } 
	@font-face {
 font-family: 'NEXEN TIRE_Regular';
 src: url('assets/fonts/NEXEN TIRE_Regular.ttf') format('truetype');
}
	
</style>

<script src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("input[name='write']").on("click", function(){
		var up=$("input[name='write']").val();
		var boardtitle=$("input[name='boardtitle']").val();
		var boardcontents=$("textarea[name='boardcontents']").val();
		var param="action="+up+"&boardtitle="+boardtitle+"&boardcontents="+boardcontents
		$.ajax({
			type: "get",
			url: "board",
			data: param,
			success: function(data) {
				$(".detail").html(data);
			}
		});
	}); // update end
	
	$("#back").on("click", function(){
		var referrer =  document.referrer;
		location.href = "test.jsp";
	});// back end
}); // ready end
</script>
<link rel="stylesheet" href="assets/css/main.css?after">
<link rel="stylesheet" href="assets/css/form.css" />
</head>
<body style="overflow-x:hidden">
<div class="detail" >
	<p class = "write" style = "text-align: center; font-size: 1.5em; color: #585858; font-family: 'NEXEN TIRE_Regular';" >게시물 작성</p>
	<table class="list">
		<tr>
			<td><input rows=1 cols=100 name="boardtitle" placeholder = "제목을 입력하세요" style = " font-family: 'NEXEN TIRE_Regular';"></textarea></td>
		</tr>
		<tr>
			<td><textarea rows=10 cols=100 name="boardcontents" placeholder = "내용을 입력하세요 "  style = " font-family: 'NEXEN TIRE_Regular';"></textarea></td>
		</tr>
		<tr>
			<td><p style = " font-family: 'NEXEN TIRE_Regular';s">작성자 : <%=session.getAttribute("id") %></p></td>
		</tr>
		<tr>
			<td><input type=button name="write" value="저장" style = "font-family: 'NEXEN TIRE_Regular';"><br>
			
			<center><input type=button class='back' value="뒤로가기" style = "font-family: 'NEXEN TIRE_Regular';" ></center>
			</td>
		</tr>
		<tr></tr>
	</table>
	
	
</div>




</body>
</html>