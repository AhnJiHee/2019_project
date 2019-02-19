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
	table.list{text-align: center; margin: auto; border: 3px solid purple;}
</style>

<script src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("input[name=write]").on("click", function(){
		var up=$("input[name=write]").val();
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

</head>
<body>
<div class="detail">

	<table class="list">
		<tr>
			<td><input type=text name="boardtitle" placeholder = "제목을 입력하세요"></td>
		</tr>
		<tr>
			<td><textarea rows=20 cols=100 name="boardcontents" placeholder = "내용을 입력하세요"></textarea></td>
		</tr><tr>
			<td><p>작성자 : <%=session.getAttribute("id") %></p></td>
		</tr>
		<tr>
			<td><input type=button name="write" value="저장"></td>
		</tr>
	</table>
	
	<input type=button class='back' value="뒤로가기">
</div>




</body>
</html>