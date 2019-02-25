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
	width: 50%;
	margin-left: auto;
	margin-right: auto;
}

@font-face {
	font-family: 'NEXEN TIRE_Regular';
	src: url('assets/fonts/NEXEN TIRE_Regular.ttf') format('truetype');
}

div table tr, td {
	border: 1px solid #444444;
	border-spacing: 2px;
}

div table tr {
	border: 1px solid #444444;
	border-spacing: 2px;
}

table {
	width: 50%;
	min-width: 500px;
	margin: 2px 20% 2px 25%;
	color: #2E2E2E;
}

div.detail td {
	padding: 5px;
	border: 2px solid #FAFAFA;
	width: 160px;
	text-align: center;
}

table.center {
	border: 1px solid #FAFAFA;
}
</style>
<link rel="stylesheet" href="assets/css/form.css" />
<script src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#up").on("click",
						function() {
							var up = $("#up").val();
							var newtitle = $("input[name='newtitle']").val();
							var newcontents = $("textarea[name='newcontents']")
									.val();
							var param = "action=" + up + "&newtitle="
									+ newtitle + "&newcontents=" + newcontents
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

</head>
<body style="overflow-x: hidden;">

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
         style="text-align: center; font-size: 1.5em; color: #585858; font-family: 'NEXEN TIRE_Regular';">수정하기</p>
		<table class="list">
			<tr>
				<td  style="font-family: 'NEXEN TIRE_Regular';">게시물 번호</td>
				<td><%=seq%></td>
			</tr>
			<tr>
				<td  style="font-family: 'NEXEN TIRE_Regular';">제목</td>
				<td><input type=text name="newtitle" placeholder=<%=boardtitle%>
					style="margin-left: auto; margin-right: auto;"></td>
			</tr>
			<tr>
				<td height=300 style="font-family: 'NEXEN TIRE_Regular';">내용</td>
				<td><textarea cols=70 rows=25 name="newcontents"
						placeholder=<%=boardcontents%>
						style="margin-left: auto; margin-right: auto; height: 300px;"></textarea></td>
			</tr>
			<tr>
				<td style="font-family: 'NEXEN TIRE_Regular';">작성자</td>
				<td><%=boardwriter%></td>
			</tr>
			<tr>
				<td style="font-family: 'NEXEN TIRE_Regular';">작성 시간
				</td>
				<td><%=boardtime%></td>
			</tr>
			<tr>
				<td style="font-family: 'NEXEN TIRE_Regular';">조회수</td>
				<td><%=boardviewcount%></td>
			</tr>
		</table>

		<div style="margin-left: 500px; margin-top: 20px;">
			<form style="display: inline; float: left; width: 20%;">
				<input type=button id="up" value="수정" style="width: 100px;
				font-family: 'NEXEN TIRE_Regular';">
			</form>

			<form style="display: inline; float: left; width: 20%;">
				<input type=button class='back' value="뒤로가기" style="width: 100px;
				font-family: 'NEXEN TIRE_Regular';">
			</form>
		</div>

	</div>

</body>
</html>