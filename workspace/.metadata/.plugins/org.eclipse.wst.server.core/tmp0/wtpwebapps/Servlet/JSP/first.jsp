<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.DriverManager, dao.BoardDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> html 태그 영역입니다. </h1>
<% System.out.println("jsp 태그 영역입니다.");
	 out.println("<h1>브라우저 출력 jsp 문장 영역입니다.</h1>"); %>
	 <!-- out이라는 PrintWriter 객체가 jsp에 내장되어 있다. -->
	 
<%= "<H2>브라우저 출력 전용 태그입니다.</H2>"
+ request.getParameter("id") %>
<% out.println("<H2>브라우저 출력 전용 태그입니다.</H2>"); %>
<H2>브라우저 출력 전용 태그입니다.</H2>

<input type = text name = "n" value = "<%=request.getParameter("id")%>">
<%=request.getMethod() %>
<%
if(request.getMethod().equals("GET")){
	/* GET방식일 때 처리할 메소드 작성 */
}
%>
</body>
</html>