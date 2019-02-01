<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
try {
		// 1. 현재 시작하는 servlet 프로젝트의 설정 내용을 기억함
	Context initContext = new InitialContext();
		// 2. context.xml 파일의 설정 내용을 찾아옴
	Context envContext = 
		(Context)initContext.lookup("java:/comp/env");
		// 3. 아까 context.xml에 썼던 datasource 변수 이름 (jdbc/myoracle) 찾아옴
		// 이때 이 ds가 connectionpool 객체이다
	DataSource ds = 
		(DataSource)envContext.lookup("jdbc/myoracle");
	for(int i= 1; i <= 1000; i++){
		// 4. 이후 사용법은 con과 동일
		Connection con = ds.getConnection();
		System.out.println(i + "번째 " + con + " 성공");
		// 5. close는 con을 반납하라는 의미
		con.close();
	}
}catch(Exception e){
	e.printStackTrace();
}
%>

<%-- <% 
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	for (int i=1 ; i<=100; i++){
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		System.out.println(i +"번째" + con +  " 연결 성공");
		con.close();
		System.out.println("연결 해제 성공");
	}

	
} catch (Exception e){
	e.printStackTrace();
}
%> --%>


</body>
</html>