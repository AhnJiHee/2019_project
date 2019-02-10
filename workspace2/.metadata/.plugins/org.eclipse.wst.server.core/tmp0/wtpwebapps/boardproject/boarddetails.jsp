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
	.center{text-align: center; margin: auto;}
	table.list{text-align: center; margin: auto; border: 3px solid purple;}
</style>

<script src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	$("#update").on("click", function(){
		if($("#authority").val() == "TRUE") {
			location.href = "boardupdate.jsp"
		} else{
			alert("작성자만 수정할 수 있습니다.");
		}
	}); // update end
	$("#delete").on("click", function(){
		if($("#authority").val() == "TRUE") {
			location.href = "boarddetailsdelete.jsp"
		} else{
			alert("작성자만 삭제할 수 있습니다.");
		}
	}); // delete end
	}); // ready end
</script>
</head>
<body>
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

<table class="list" border="2px">

<tr>
<td>게시물 번호</td><td><%=seq%></td>
</tr>
<tr>
<td>제목</td><td><%=boardtitle%></td>
</tr>
<tr>
<td height = 300>내용</td><td width = 500><%=boardcontents%></td>
</tr>
<tr>
<td>작성자</td><td><%=boardwriter%></td>
</tr>
<tr>
<td>작성 시간</td><td><%=boardtime%></td>
</tr>
<tr>
<td>조회수</td><td><%=boardviewcount%></td>
</tr>
</table>
<table class="center">
<tr>
	<td>
		<form action="boardupdate.jsp">
		<input type=button id='update' value="수정">
		</form>
	</td>
	<td>
		<form action="boarddetailsdelete.jsp">
		<input type=button id='delete' value="삭제">
		</form>
	</td>
	<td>
		<form action="mainpage.jsp">
		<input type=submit value="메인으로 돌아가기">
		</form>
	</td>
</tr>
</table>

<!-- 로그인 상태 확인 태그-->
<%! MemberDAO dao2 = new MemberDAO(); %>
<%String authority = dao2.authority(session, boardwriter); %>   
<input type="hidden" id="authority" value=<%=authority%>>

</body>
</html>