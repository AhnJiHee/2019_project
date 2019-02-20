package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String result = "";

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		MemberVO vo = new MemberVO(id, pw, name, phone, email);
		MemberDAO dao = new MemberDAO();
		dao.signIn(vo);
		
		result="<h1 align='center'>회원가입이 완료되었습니다.</h1>" +
				"<form class='center' action='test.jsp'>" + 
				"<input type=submit value='메인으로 돌아가기'>" + 
				"</form>";
		
		out.print(result);
		
	}


}
