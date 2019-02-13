<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" initial-scale="1">

<script src="js/bootstrap.js"></script>
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
				$(".login_div").html(data);
			}
		});
	}); // login end
	
	$("#logout").on("click", function(){
		location.href = "logout";
		alert("로그아웃 되었습니다");
	}); // logout end
	
	

}); // ready end

</script>

<head>
<link rel="stylesheet" href="css/login.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css?after" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<link rel="stylesheet" href="css/navigation.css?after">
<link rel="stylesheet" href="css/bootstrap.css?after"">
<link rel="stylesheet" href="css/custom.css">


<link rel="stylesheet" href="css/myStyle.css?after">


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/login.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
<title>메인 화면</title>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>
</head>

<body>
<!-- <div class="container">
	<div class="row">

<div class="container">
  <div class="card"></div>
  <div class="card">
    <h1 class="title">Login</h1>
    <form>
      <div class="input-container">
        <input type="text" id="Username" required="required"/>
        <label for="Username">Username</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="password" id="Password" required="required"/>
        <label for="Password">Password</label>
        <div class="bar"></div>
      </div>
      <div class="button-container">
        <button><span>Go</span></button>
      </div>
      <div class="footer"><a href="#">Forgot your password?</a></div>
    </form>
  </div>
  <div class="card alt">
    <div class="toggle"></div>
    <h1 class="title">Register
      <div class="close"></div>
    </h1>
    <form>
      <div class="input-container">
        <input type="text" id="Username" required="required"/>
        <label for="Username">Username</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="password" id="Password" required="required"/>
        <label for="Password">Password</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="password" id="Repeat Password" required="required"/>
        <label for="Repeat Password">Repeat Password</label>
        <div class="bar"></div>
      </div>
      <div class="button-container">
        <button><span>Next</span></button>
      </div>
    </form>
  </div>
</div>
	</div>
</div> -->

<!-- 로그인 + 메뉴 영역  -->
<div id = "div3">

	<!-- 로그인창-->
	<div class = "login_div">
		<% if (session.getAttribute("id") == null & session.getAttribute("pw") ==null) { %>
		<!-- 비로그인 상황-->
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
		<!-- 로그인 상황 -->
		<% } else { %>
			<h3> <%=session.getAttribute("id") %> 회원님 환영합니다. </h3>
			<input type=button id="logout" value="로그아웃">
		<% } %>
	</div> <!--로그인창 end-->
	
	<!-- 네비게이터 -->
	<div class = "snb">
		<ul>
	      <li><a href="main?branch=1">게시판으로 가기"></a></li>
	      <li><a href="main?branch=2">심야식당 보러 가기"></a></li>
	      <li><a href="#">어쩌구</a></li>
	      <li><a href="#">저쩌구</a></li>
	      </ul>
	</div> <!-- 네비게이터 end -->
	
</div>
	
</body>
</html>
