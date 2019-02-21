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
.center {
	text-align: center;
	margin: auto;
}

table.list {
	text-align: center;
	margin: 50px;
}

@font-face {
	font-family: 'NEXEN TIRE_Regular';
	src: url('assets/fonts/NEXEN TIRE_Regular.ttf') format('truetype');
}
</style>

<script src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#up").on(
						"click",
						function() {
							var up = $("#up").val();
							var newtitle = $("input[name='newtitle']").val();
							var newcontents = $("textarea[name='newcontents']")
									.val();
							var param = "action=" + up + "&newtitle="
									+ newtitle + "&newcontents=" + newcontents
							alert(param);
							$.ajax({
								type : "get",
								url : "board",
								data : param,
								success : function(data) {
									$(".detail").html(data);
								}
							});
						}); // update end

				$(".back").on("click", function() {
					var referrer = document.referrer;
					location.href = "test.jsp";
				});// back end

			}); // ready end
</script>
<link rel="stylesheet" href="assets/css/main.css?after">
<link rel="stylesheet" href="assets/css/form.css" />
</head>

<body style="overflow-x: hidden;">
	<p class="write"
		style="text-align: center; font-size: 1.5em; color: #585858; font-family: 'NEXEN TIRE_Regular';">수정하기
	</p>
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
		<p class="write"
			style="text-align: center; font-size: 1.5em; color: #585858; font-family: 'NEXEN TIRE_Regular';">게시물
			수정</p>
		<table class="list">
			<tr>
				<td rows=1 cols=100 name="boardtitle" placeholder="제목을 입력하세요"
					style="font-family: 'NEXEN TIRE_Regular';">게시물 번호</td>
				<td><%=seq%></td>
			</tr>
			<tr>
				<td rows=1 cols=100 name="boardtitle" placeholder="제목을 입력하세요"
					style="font-family: 'NEXEN TIRE_Regular';">제목</td>
				<td><input type=text name="newtitle"
					placeholder=<%=boardtitle%>></td>
			</tr>
			<tr>
				<td height=300>내용</td>
				<td><textarea cols=70 rows=25 name="newcontents"
						placeholder=<%=boardcontents%>></textarea></td>
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
				<td><input type=button name="write" id="up" value="수정"
					style="font-family: 'NEXEN TIRE_Regular';"><br>
					<center>
						<input type=button class='back' value="뒤로가기"
							style="font-family: 'NEXEN TIRE_Regular';">
					</center></td>
				<td><input type=button class='back' value="뒤로가기"></td>
			</tr>


		</table>
	</div>

</body>
</html>