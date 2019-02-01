package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginSessionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 1. HttpSession 생성
		HttpSession session = request.getSession();
		System.out.println(session.isNew());

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String html = "";
	// 2. 입력 id를 전송 받아 session 내부에 저장
		String id = request.getParameter("id");
		if(	session.getAttribute("sessionid") != null
			&&
			((String)session.getAttribute("sessionid")).equals(id)) {
			html = "<h1>이미 로그인하셨습니다.</h1>";
		} else {
			session.setAttribute("sessionid", id);
			html = "<h1>아이디를 세션에 저장했습니다.</h1>";
		}
		out.println(html);
		out.println("<a href = 'mypagesession'> 마이 페이지로 이동하기</a><br>");
		out.println("<a href = 'logoutsession'> 로그아웃 하러 가기</a><br>");
		out.println("<a href = '../Servlet/JSP/boardwrite_session.jsp'> 글쓰러 가기</a>");
	}

}
