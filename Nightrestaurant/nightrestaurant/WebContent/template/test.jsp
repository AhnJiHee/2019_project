<%@page import="dao.MemberDAO"%>
<%@page import="vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Big Picture by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>심야식당</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="../js/login.js"></script>
	    <script src="js/bootstrap.min.js"></script>
	    <link rel="stylesheet" href="../css/login.css?after">
	    <link rel="stylesheet" href="../css/tab.css?after">
	    
    
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<nav>
					<ul>
						<li><a href="#intro">심야 식당</a></li>
						<li><a href="#one">메뉴</a></li>
						<li><a href="#two">추천 식당</a></li>
						<li><a href="#work"><b>로그인</b></a></li>
						<li><a href="#contact">문의</a></li>
					</ul>
				</nav>
			</header>

		<!-- Intro -->
			<section id="intro" class="main style1 dark fullscreen">
				<div class="content">
					<header>
						<h2>WELCOME <br>심야식당</h2>
					</header>
					
					<p><strong>심야식당</strong>에 오신 것을 환영합니다.<br />
					</p>
					<footer>
						<a href="#one" class="button style2 down">More</a>
					</footer>
				</div>
			</section>

		<!-- One -->
			<section id="one" class="main style2 right dark fullscreen">
			

<div class="content box style2">
				
				
				<div class="tabs">
					  <div class="tab-2">
					    <label for="tab2-1" id="tores">심야 식당 찾기</label>
					    <input id="tab2-1" name="tabs-two" type="radio" checked="checked">
					    <div>
					    	<jsp:include page="../restaurantlist.jsp"></jsp:include>
					    </div>
					  </div>
					  <div class="tab-2">
					    <label for="tab2-2"  id="toboard">게시판 보기</label>
					    <input id="tab2-2" name="tabs-two" type="radio">
					    <div>
					    	<jsp:include page="../boardlist.jsp"></jsp:include>
					    
					    </div>
					  </div>
				</div>
				
				
				
					
				</div>

				<a href="#two" class="button style2 down anchored">Next</a>
			</section>

		<!-- Two -->
			<section id="two" class="main style2 left dark fullscreen">




		<!-- Gallery  -->
						<div class="gallery">
							<article class="from-left">
								<a href="https://store.naver.com/restaurants/detail?id=1127738824"  target="_blank" class="image fit"><img src="images/aps2.jpg" width="300" height = "250" title="The Anonymous Red" alt="" /></a>
								<figcaption>
							    <h3><b>알프스 식당</b><br>
							    <font size ="2">영업시간 - 16:00~24:00</font><br>
							    <img src = "images/right-arrow.png" width = "30px" height = "30px">
							    </h3>
							  </figcaption>
							</article>
							<article class="from-right">
								<a href="https://store.naver.com/restaurants/detail?entry=plt&id=1224219974&query=%EB%B0%B1%EC%88%98%EC%94%A8%EC%8B%AC%EC%95%BC%EC%8B%9D%EB%8B%B9" target="_blank" class="image fit"><img src="images/baek.png"  width="300" height = "250"  title="Airchitecture II" alt="" /></a>
							</article>
							<article class="from-left">
								<a href="https://store.naver.com/restaurants/detail?entry=plt&id=38009356&query=%EB%B8%8C%EB%A1%9C%EC%BD%9C%EB%A6%AC%EC%8B%9D%EB%8B%B9" target="_blank" class="image fit"><img src="images/bro.png"  width="300" height = "250" title="Air Lounge" alt="" /></a>
							</article>
							<article class="from-right">
								<a href ="https://store.naver.com/restaurants/detail?id=1540634517" target="_blank"  class="image fit"><img src="images/dong.png"  width="300" height = "250" /></a>
							</article>
							<article class="from-left">
								<a href="https://store.naver.com/restaurants/detail?entry=plt&id=35326713&query=%EC%8B%AC%EC%95%BC%EC%8B%9D%EB%8B%B9%20%EC%8B%9C%EC%A6%8C2%20%EC%A3%BC%EB%B0%94%EB%A6%AC%20%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8" target="_blank" class="image fit"><img src="images/jblee.png"  width="300" height = "250" title="The sparkling shell" alt="" /></a>
							</article>
							<article class="from-right">
								<a href="https://store.naver.com/restaurants/detail?id=37524875" target="_blank" class="image fit"><img src="images/kitchen.png"  width="300" height = "250" title="Bent IX" alt="" /></a>
							</article>
						</div>

				</div>
				
				
				
				
				
				<a href="#work" class="button style2 down anchored">Next</a>
			</section>

		<!-- Work -->
			<section id="work" class="main style3 primary">
				<div class="content">
				
				
	<% if (session.getAttribute("id") == null & session.getAttribute("pw") ==null) { %>
		<div class="container">
			<div class="row">
		
		<div class="container">
		  <div class="card"></div>
		  <div class="card">
		    <h1 class="title">Login</h1>
		    <form>
		      <div class="input-container">
		      <input type=text id="id" name="id" required="required">
		        <!-- <input type="text" id="Username" required="required"/> -->
		        <label for="Username">Username</label>
		        <div class="bar"></div>
		      </div>
		      <div class="input-container">
		      <input type="password" id="pw" name="pw"  required="required"/>
		       <!--  <input type="password" id="Password" required="required"/> -->
		        <label for="Password">Password</label>
		        <div class="bar"></div>
		      </div>
		      <div class="button-container">
		      <input type="button" id="login" value="로그인">
		      <!--   <button><span>Go</span></button> -->
		      </div>
		     
		    </form>
		  </div>
		  <% } else { %>
					<h3> <%=session.getAttribute("id") %> 회원님 환영합니다. </h3>
					<input type=button id="logout" value="로그아웃">
				<% } %> 
		  <div class="card alt">
		    <div class="toggle"></div>
		    <h1 class="title">회원가입
		      <div class="close"></div>
		    </h1>
		 
		    
		    <form action = "signin" method="post">
		      <div class="input-container">
		        <input type="text" name ="id" id="Username" required="required"/>
		        <label for="Username">Username</label>
		        <div class="bar"></div>
		      </div>
		      <div class="input-container">
		        <input type="password" id="Password" required="required"/>
		        <label for="Password">Password</label>
		        <div class="bar"></div>
		      </div>
		      <div class="input-container">
		        <input type="name" name = "name" required="required"/>
		        <label for="Name">Name</label>
		        <div class="bar"></div>
		      </div>
		      <div class="input-container">
		        <input type="tel" name = "phone" pattern = "010-[0-9]{3,4}-[0-9]{4}" required="required"/>
		        <label for="tel">Tel</label>
		        <div class="bar"></div>
		      </div>
		      <div class="input-container">
		        <input type="email"  name = "email" required="required"/>
		        <label for="email">email</label>
		        <div class="bar"></div>
		      </div>
		      <div class="button-container">
		       <input type="submit" value = "회원가입">
		      </div>
		    </form>
		  </div>
		</div>
			</div>
		</div>
				
			
			</section>

		<!-- Contact -->
			<section id="contact" class="main style3 secondary">
				<div class="content">
					<header>
						<h2>See you again</h2>
						<p>Lorem ipsum dolor sit amet et sapien sed elementum egestas dolore condimentum.</p>
					</header>
					<div class="box">
						<form method="post" action="#">
							<div class="fields">
								<div class="field half"><input type="text" name="name" placeholder="Name" /></div>
								<div class="field half"><input type="email" name="email" placeholder="Email" /></div>
								<div class="field"><textarea name="message" placeholder="Message" rows="6"></textarea></div>
							</div>
							<ul class="actions special">
								<li><input type="submit" value="Send Message" /></li>
							</ul>
						</form>
					</div>
				</div>
			</section>

		<!-- Footer -->
			<footer id="footer">

				<!-- Icons -->
					<ul class="icons">
						<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
						<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
						<li><a href="#" class="icon fa-linkedin"><span class="label">LinkedIn</span></a></li>
						<li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
						<li><a href="#" class="icon fa-pinterest"><span class="label">Pinterest</span></a></li>
					</ul>

				<!-- Menu -->
					<ul class="menu">
						<li>&copy; Untitled</li><li>Design: <a href="https://html5up.net">HTML5 UP</a></li>
					</ul>

			</footer>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.poptrox.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			

	</body>
</html>