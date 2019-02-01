<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" import = "vo.MemberVO"%>

<%
String id = request.getParameter("id");
int pw = Integer.parseInt(request.getParameter("pw"));
String name = request.getParameter("name");
String phone = request.getParameter("phone");
String email = request.getParameter("email");
String result = "";
request.setCharacterEncoding("utf-8");
MemberVO vo = new MemberVO(id, pw, name, phone, email);

try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
	
	String sql = 
			"insert into member values "
			+ " ( ? , ? , ? , ? , sysdate , ?)";
	PreparedStatement pt = con.prepareStatement(sql);

	pt.setString(1, id);
	pt.setInt(2, pw);
	pt.setString(3, name);
	pt.setString(4, phone);
	pt.setString(5, email);	
		
	int insertRow = pt.executeUpdate();
	if( insertRow==1) {
		result = "회원가입이 완료되었습니다.";			
	} else {
	}
	
	con.close();
		
	}catch(Exception e) {
		result = "회원가입 미완료되었습니다.";
		e.printStackTrace();
	}
%>

<% request.setAttribute("memberinfo", vo); %>
<jsp:forward page="login2.jsp">
</jsp:forward>

<%-- 	<jsp:param value="<%=result%>" name="a"/>--%>
<!-- param tag는 String 데이터만 처리가 가능하다 
  자바 객체를 전달하고 싶다면 forward하기 전에 session에 setAttribute로 저장-->
  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>

</body>
</html>