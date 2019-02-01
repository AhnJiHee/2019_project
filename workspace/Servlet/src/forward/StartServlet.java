package forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*1. 사용자 id, pw 입력 받
		 *2. id가 대소문자 상관없이 system 이거나 admin 이면
		 *   admin servlet으로 이동
		 *3. 이 외의 경우는 user servlet 이동, id, pw 전달*/
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		for( int i = 0; i <pw.length(); i++) {
			pw = pw.replace(pw.charAt(i), '*');
		}
		RequestDispatcher rd = null;
		if ( id.equalsIgnoreCase("system") || id.equalsIgnoreCase("admin")) {
			rd = request.getRequestDispatcher("admin");
		} else {
			request.setAttribute("userID", id);
			request.setAttribute("userPW", pw);
			rd = request.getRequestDispatcher("user");
		}
		rd.forward(request, response);
			
	}

}
