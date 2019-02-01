<%@page import="java.sql.*"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원가입 </title>
</head>
<body>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String phone = request.getParameter("phone");
String email = request.getParameter("email");
String result = "";
request.setCharacterEncoding("utf-8");
MemberVO vo = new MemberVO(id, pw, name, phone, email);

try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","board","board");
	
	String sql = 
			"insert into member values "
			+ " ( ? , ? , ? , ? , sysdate , ?)";
	PreparedStatement pt = con.prepareStatement(sql);

	pt.setString(1, id);
	pt.setString(2, pw);
	pt.setString(3, name);
	pt.setString(4, phone);
	pt.setString(5, email);	
		
	int insertRow = pt.executeUpdate();
	if( insertRow==1) {
		result = "회원가입이 완료되었습니다.";			
		session.setAttribute("id", id);
		session.setAttribute("password", pw);
	} 
	con.close();
		
	}catch(Exception e) {
		result = "회원가입 미완료되었습니다.";
		e.printStackTrace();
	}
%>

<h1> <%=result%></h1>
<a href = boardlist.jsp>게시판으로 이동</a>
</body>
</html>
