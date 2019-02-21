<%@page import="dao.MemberDAO"%>
<%@page import="vo.BoardVO"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 보기</title>

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

div table tr, td {
	border: 1px solid #444444;
	border-spacing: 2px;
}

div table tr {
	border: 1px solid #444444;
	border-spacing: 2px;
}
</style>

<script src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#update").on("click", function() {
			if ($("#authority").val() == "TRUE") {
				location.href = "boardupdateform.jsp"
			} else {
				alert("작성자만 수정할 수 있습니다.");
			}
		}); // update end

		$("#delete").on("click", function() {
			if ($("#authority").val() == "TRUE") {
				var del = $("#delete").val();
				var param = "action=" + del
				$.ajax({
					type : "get",
					url : "board",
					data : param,
					success : function(data) {
						$(".detail").html(data);
					}
				});
			} else {
				alert("작성자만 삭제할 수 있습니다.");
			}
			return false;
		}); // delete end

		$(".back").on("click", function() {
			var referrer = document.referrer;
			location.href = referrer;
		});// back end

	}); // ready end
</script>

<link rel="stylesheet" href="assets/css/form.css" />
<style>
table {
	width: 50%;
	min-width: 500px;
	margin: 2px 20% 2px 25%;
	color: #2E2E2E;
}

div.detail td {
	padding: 20px;
	border: 2px solid #FAFAFA;
	width: 30px;
	text-align: center;
}

table.center {
	border: 1px solid #FAFAFA;
}
</style>

</head>
<body style="overflow-x: hidden;">
	<div class="detail">
		<p class="write"
			style="text-align: center; font-size: 1.5em; color: #585858; font-family: 'NEXEN TIRE_Regular';">게시물
			작성완료</p>
		<%
			int seq = Integer.parseInt(request.getParameter("boardseq"));
			session.setAttribute("boardseq", seq);
			BoardDAO dao = new BoardDAO();
			dao.viewCount(seq);
			BoardVO vo = dao.getBoardDetail(seq);
			session.setAttribute("boardvo", vo);

			String boardwriter = vo.getBoardwriter();
			String boardtitle = vo.getBoardtitle();
			String boardcontents = vo.getBoardcontents();
			String boardtime = vo.getBoardtime();
			int boardviewcount = vo.getBoardviewcount();
		%>

		<div class="detail">
			<table>

				<tr>
					<td>게시물 번호</td>
					<td><%=seq%></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><%=boardtitle%></td>
				</tr>
				<tr>
					<td height=300>내용</td>
					<td width=500><%=boardcontents%></td>
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

			<div style="margin-left: 330px; margin-top: 20px;">
				<form action="boardupdate.jsp"
					style="display: inline; float: left; width: 20%;">
					<input type=button id='update' value="수정" style="width: 100px">
				</form>

				<form action="boarddetailsdelete.jsp"
					style="display: inline; float: left; width: 20%;">
					<input type=button id='delete' value="삭제" style="width: 100px">
				</form>
				<form style="display: inline; float: left; width: 20%;">
					<input type=button class='back' value="뒤로가기" style="width: 100px;">
				</form>
			</div>
		</div>
		<%
		MemberDAO mdao = new MemberDAO();
		String authority = mdao.authority(session, boardwriter);
		%>
		<input type=hidden id="authority" value= <%=authority%>>
		
</body>
</html>