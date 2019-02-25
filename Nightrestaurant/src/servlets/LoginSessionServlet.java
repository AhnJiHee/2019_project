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
		
		if (result.equals("����")){
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("password", password);
			html = "<table>" +
					"	<tr>" +
					"		<td><h3>���������� �α��� �Ǿ����ϴ�!</h3></td>" + 
					"	</tr>" +
					"</table>";
		}else if (result.equals("Ȯ��")){
			html = "<h1>��й�ȣ�� Ȯ���ϼ���.</h1>"
					+ "<a href = test.jsp>���ư���</a>";
		}else if (result.equals("��ȸ��")){
			html = "<h1>ȸ���� �ƴմϴ�.</h1>"
					+ "<a href = signin.jsp>ȸ������ �Ϸ� ����</a>";
		}else {
			html = "<h1>������ �߻��߽��ϴ�.</h1>"
					+ "<a href = test.jsp>���ư���</a>";
		}
		
		out.println(html);

		
	}

}
