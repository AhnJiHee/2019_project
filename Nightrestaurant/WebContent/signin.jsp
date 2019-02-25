<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" initial-scale="1.0">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>회원가입 화면</title>
</head>
<body>
	<div class="container">

		<form class="well form-horizontal" action="signin" method="post"
			id="contact_form">
			<fieldset>

				<!-- Form Name -->
				<legend>
					<center>
						<h2>
							<b>심야식당 회원가입</b>
						</h2>
					</center>
				</legend>
				<br>

				<!-- 아이디 input-->

				<div class="form-group">
					<label class="col-md-4 control-label">아이디</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="id"
								placeholder="아이디" class="form-control" type="text">
						</div>
					</div>
				</div>

				<!-- 패스워드 input-->

				<div class="form-group">
					<label class="col-md-4 control-label">패스워드</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input
								name="pw" placeholder="숫자+문자"
								class="form-control" type="password">
						</div>
					</div>
				</div>

				<!-- 이름 input-->

				<div class="form-group">
					<label class="col-md-4 control-label">이름</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="name"
								placeholder="이름" class="form-control" type="text">
						</div>
					</div>
				</div>



				<!-- 이메일 input-->
				<div class="form-group">
					<label class="col-md-4 control-label">이메일</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span> <input name="email"
								placeholder="E-Mail주소" class="form-control" type="email">
						</div>
					</div>
				</div>


				<!-- 전화번호입력 input-->

				<div class="form-group">
					<label class="col-md-4 control-label">전화번호입력 </label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-earphone"></i></span> <input name="phone"
								placeholder="010-0000-0000" class="form-control" type="tel"
								pattern="010-[0-9]{3,4}-[0-9]{4}">
						</div>
					</div>
				</div>



				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<br>
						&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<button type="submit" class="btn btn-warning">
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSUBMIT <span
								class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						</button>
					</div>
				</div>

			</fieldset>
		</form>
	</div>
	</div>
	<!-- /.container -->
	
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>




</body>
</html>
