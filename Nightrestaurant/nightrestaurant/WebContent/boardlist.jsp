<%@page import="dao.MemberDAO"%>
<%@page import="vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 리스트</title>

<script src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#write").on("click", function() {
			if ($("#status").val() == "on") {
				location.href = "boardwriteform.jsp"
			} else {
				alert("로그인이 필요합니다");
			}
		}); // write end

		$("#search").click(function() {
			var tag = $("#tag").val();
			var word = $("#word").val();
			var param = "tag=" + tag + "&word=" + word;
			$.ajax({
				type : "POST",
				url : "boardlistsearch.jsp",
				data : param,
				success : function(data) {
					$("#div5").html(data);
				}
			});
			return false;
		}); // search end

		$(".Page").on('click', function(e) {
			var branch = 1
			var page = $(e.target).html();
			var param = "branch=" + branch + "&page=" + page;
			$.ajax({
				type : "get",
				url : "boardlist.jsp",
				data : param,
				success : function(data) {
					$("#div5").html(data);
				}
			});
		}); //.page end

	}); // ready end
</script>
<style>
a {
	color: black;
}

table {
	width: 100%;
	border-top: 3px solid #98c593;
	border-collapse: collapse;
}

th, td {
	border-bottom: 1px solid #BDBDBD;
	padding: 10px;
	text-align: center;
}

th {
	background-color: #bbdefb;
}

td {
	background-color: #FAFAFA;
}
</style>
</head>
<body>

	<div id="div5">
		<!--게시판 제목-->
		<div class="center" id="div1">
			<h1>게시판 목록입니다.</h1>
			<table class="list" border="2px">
				<tr>
					<td>번호</td>
					<td width="250">제목</td>
					<td>작성자</td>
					<td>작성시간</td>
					<td>조회수</td>
				</tr>
				<!--게시물 목록 출력-->
				<%
					BoardDAO dao = new BoardDAO();
					int pagenumb = 1; // 기본으로 보여줄 페이지
					if (request.getParameter("page") != null) {
						pagenumb = Integer.parseInt(request.getParameter("page"));
					}
					ArrayList<BoardVO> list = dao.getBoardList(pagenumb);
					for (int i = 0; i < list.size(); i++) {
						BoardVO vo = list.get(i);
						out.println("<tr><td>" + vo.getBoardseq() + "</td><td>" + "<a href = 'boarddetails.jsp?boardseq="
								+ vo.getBoardseq() + " '>" + vo.getBoardtitle() + "</a></td><td>" + vo.getBoardwriter()
								+ "</td><td>" + vo.getBoardtime() + "</td><td>" + vo.getBoardviewcount() + "</td></tr>");
					}
				%>
			</table>
			<table>
				<tr>
					<td colspan="2"><input type=text id="word" name="word"
						placeholder="검색할 내용을 입력하세요."></td>
					<td><select id="tag" name="tag">
							<option value="boardtitle">제목</option>
							<option value="boardcontents">내용</option>
							<option value="boardwriter">작성자</option>
					</select></td>
					<td><input type=button id="search" value="검색 버튼" /></td>
					<td><input type=button id="write" value="글쓰기 버튼"></td>
				</tr>
			</table>
		</div>

		<!-- 로그인 상태 확인 태그-->
		<%!MemberDAO dao2 = new MemberDAO();%>
		<input type="hidden" id="status" value=<%=dao2.loginstatus(session)%>>

		<!--페이지 번호-->
		<table class="center">
			<tr>
				<form action="main">
					<%
						int totalcont = dao.getTotalContents();
						if (totalcont % BoardDAO.EACH == 0) {
							pagenumb = totalcont / BoardDAO.EACH;
						} else {
							pagenumb = totalcont / BoardDAO.EACH + 1;
						}
						for (int i = 1; i <= pagenumb; i++) {
							out.print("<td><span class='Page'>" + i + "</span></td>");
						}
					%>
				</form>
			</tr>
		</table>
	</div>


</body>
</html>