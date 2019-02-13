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
		
		result="<h1 align='center'>ȸ�������� �Ϸ�Ǿ����ϴ�.</h1>" +
				"<form class='center' action='mainpage.jsp'>" + 
				"<input type=submit value='�������� ���ư���'>" + 
				"</form>";
		
		out.print(result);
		
	}


}