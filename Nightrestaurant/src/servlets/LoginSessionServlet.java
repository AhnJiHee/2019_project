package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

@WebServlet("/login")
public class LoginSessionServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		MemberDAO mdao = new MemberDAO();
		String result = mdao.ifmember(id, password);
		String html = "";
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (result.equals("정상")){
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("password", password);
			html = "<table>" +
					"	<tr>" +
					"		<td><h3>성공적으로 로그인 되었습니다!</h3></td>" + 
					"	</tr>" +
					"</table>";
		}else if (result.equals("확인")){
			html = "<h1>비밀번호를 확인하세요.</h1>"
					+ "<a href = test.jsp>돌아가기</a>";
		}else if (result.equals("비회원")){
			html = "<h1>회원이 아닙니다.</h1>"
					+ "<a href = signin.jsp>회원가입 하러 가기</a>";
		}else {
			html = "<h1>오류가 발생했습니다.</h1>"
					+ "<a href = test.jsp>돌아가기</a>";
		}
		
		out.println(html);

		
	}

}
