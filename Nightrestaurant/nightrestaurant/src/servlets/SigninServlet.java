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
		
		result = "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n"
				+ "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>\n"
				+ "<title>CSS</title>\n" + "<style>\n" + "div {\n" + "	text-align: center;\n" + "}\n"
				+ "\n" + "\n" + ".button {\n" + "	background-color: #4CAF50; /* Green */\n"
				+ "	border: none;\n" + "	color: white;\n" + "	padding: 15px 32px;\n"
				+ "	text-align: center;\n" + "	text-decoration: none;\n" + "	display: inline-block;\n"
				+ "	font-size: 16px;\n" + "}\n" + "</style>\n" + "</head>\n"
				+ "<body background='images/background.png'>\n"
				+ "	<font size='2em' color='silver'>*ȸ�����ԿϷ�</font>\n" + "	<br>\n" + "	<div>\n"
				+ "	<img src='images/Mark.png' width='130px' height='150px' alt=''><br>\n"
				+ "	<font size='7em'>�ɾ߽Ĵ� </font> <font size='7em'\n"
				+ "		style='font-weight: bold'>ȸ�������� �Ϸ�</font> <font size='7em'>�Ǿ����ϴ�.</font><br>\n"
				+ "	<br> <font size='4em' color=#6E6E6E>ȸ������ �ɾ߽Ĵ��� ��� ����� �̿���\n"
				+ "		�� �ֽ��ϴ�.</font><br> <font size='4em' color=#6E6E6E>�α��� �� �̿��� ��\n"
				+ "		�ֽ��ϴ�.</font><br> <br>\n" + "		<form method='get'\n"
				+ "		action='http://localhost:8081/nightrestaurant/test.jsp'>\n"
				+ "		<button class='button' type='submit'>������������</button>\n" + "		</form>\n"
				+ "\n" + "	</div>\n" + "</body>\n" + "</html>\n";
		
		out.print(result);
		
	}


}
