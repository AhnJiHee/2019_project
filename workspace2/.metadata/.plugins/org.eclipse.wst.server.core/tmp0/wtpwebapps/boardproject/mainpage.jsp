<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>

<script type="text/javascript" src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#toboard").click(function() {
		$("#div4").html(null);
		var page = 1;
		var param="page="+page;
		$.ajax({
			type: "get",
			url: "boardlist.jsp",
			data: param,
			success: function(data) {
				$("#div4").html(data);
			}
		});
	}); // toboard end
	$("#tores").click(function() {
		$("#div4").html(null);
		var page = 1;
		var param="page="+page;
		$.ajax({
			type: "get",
			url: "restaurantlist.jsp",
			data: param,
			success: function(data) {
				$("#div4").html(data);
			}
		});
	}); // tores end
}); // ready end

</script>

</head>
<body>

<!-- 배너 -->
<div id="div1"></div>

<!-- 로그인창 -->
<div id="div2">
	<% if ( session.getAttribute("id") == null) { %>
	<jsp:include page="login.jsp"></jsp:include>
	<% } else { %>
	<jsp:include page="loginstatus.jsp"></jsp:include>
	<% } %>
</div>

<!-- 메뉴선택 -->
<div id="div3">
	<input type="button" id="toboard" value="게시판으로 가기">
	<input type="button" id="tores" value="심야식당 보러 가기">
</div>

<!-- 메인 -->
<div id="div4">
	<jsp:include page="boardlist.jsp"></jsp:include>
</div>
	

</body>
</html>