package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

public class LoginSessionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		MemberDAO dao = new MemberDAO();
		String result = dao.ifmember(id, password);
		String html = "";

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (result.equals("정상")){
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("password", password);
			RequestDispatcher rd = request.getRequestDispatcher("loginstatus.jsp");
			rd.forward(request, response);
		}else if (result.equals("확인")){
			html = "<h1>비밀번호를 확인하세요.</h1>"
					+ "<a href = mainpage.jsp>돌아가기</a>";
		}else if (result.equals("비회원")){
			html = "<h1>회원이 아닙니다.</h1>"
					+ "<a href = signin.jsp>회원가입 하러 가기</a>";
		}else {
			html = "<h1>오류가 발생했습니다.</h1>"
					+ "<a href = mainpage.jsp>돌아가기</a>";
		}
		
		out.println(html);

		
	}

}