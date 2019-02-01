package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MyPageSessionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. HttpSession 생성
		HttpSession session = request.getSession();
		// 2. 세션 정보 추출 조회
		String sessionid = (String) session.getAttribute("sessionid");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String html = 
							sessionid + " 회원님 페이지입니다."
							+"<h1> 내 정보 화면 </h1>"
							+"<h1>"
							+"		<ul> "	
							+"			<li> 암호 변경 </li>"
							+"			<li> 구매 목록 </li>"
							+"			<li> 쿠폰 </li>"
							+"		</ul>"
							+"</h1>";
		out.println(html);
		
		
		
		
	}

}
