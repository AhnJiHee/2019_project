package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import dao.MemberDAO;
import vo.BoardVO;

@WebServlet("/board")
public class BoardCRUDServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDAO mdao = new MemberDAO();
		BoardDAO bdao = new BoardDAO();
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String html = "";

		String action = request.getParameter("action");
		if (action.equals("����")) {
			int seq = (Integer) session.getAttribute("boardseq");
			bdao.deleteBoard(seq);
			html = "<!DOCTYPE html>" + "<html>" + "<head>"
					+ "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>" + "<title>CSS</title>"
					+ "<style>" + "div {" + "	text-align: center;" + "}" + "" + "" + ".button {"
					+ "	background-color: #4CAF50;" + "	border: none;" + "	color: white;" + "	padding: 15px 32px;"
					+ "	text-align: center;" + "	text-decoration: none;" + "	display: inline-block;"
					+ "	font-size: 16px;" + "}" + "</style>" + "</head>" + "<body background='images/background.png'>"
					+ "	<font size='2em' color='silver'>*�Խñ� ����</font><br><div>"
					+ "	<img src='images/Mark.png' width='130px' height='150px' alt=''><br>"
					+ "	<font size='7em' color='black'>�Խñ��� </font> <font size='7em'"
					+ "	style='font-weight: bold'>����</font> <font size='7em'>�Ǿ����ϴ�.</font><br><br>"
					+ "<form class='center' action='test.jsp'>" + "<input type=submit value='�������� ���ư���'>"
					+ "</form></div></body></html>";

		} else if (action.equals("����")) {
			BoardVO vo = (BoardVO) session.getAttribute("boardvo");
			int seq = vo.getBoardseq();
			String boardwriter = vo.getBoardwriter();
			String newtitle = (String) request.getParameter("newtitle");
			String newcontents = (String) request.getParameter("newcontents");
			bdao.updateBoard(seq, newtitle, newcontents);
			html = "<!DOCTYPE html>" + "<html>" + "<head>"
					+ "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>" + "<title>CSS</title>"
					+ "<style>" + "div {" + "	text-align: center;" + "}" + "" + "" + ".button {"
					+ "	background-color: #4CAF50;" + "	border: none;" + "	color: white;" + "	padding: 15px 32px;"
					+ "	text-align: center;" + "	text-decoration: none;" + "	display: inline-block;"
					+ "	font-size: 16px;" + "}" + "</style>" + "</head>" + "<body background='images/background.png'>"
					+ "	<font size='2em' color='silver'>*�Խñ� ����</font><br><div>"
					+ "	<img src='images/Mark.png' width='130px' height='150px' alt=''><br>"
					+ "	<font size='7em' color='black'>�Խñ��� </font> <font size='7em' color='black'"
					+ "	style='font-weight: bold'>����</font> <font size='7em' color='black'>�Ǿ����ϴ�.</font><br><br>"
					+ "<table class='list' border='2px'><tr>" + "<td>����</td><td>" + newtitle + "</td>"
					+ "	</tr>" + "	<tr>" + "		<td>�ۼ���</td><td>" + boardwriter + "</td>" + "	</tr>" + "	<tr>"
					+ "		<td height='300'>����</td><td width=500>" + newcontents + "</td>" + "	</tr>" + "</table>"
					+ "<form class='center' action='test.jsp'><input type=submit value='�������� ���ư���'></form>";

		} else if (action.equals("����")) {
			String boardtitle = (String) request.getParameter("boardtitle");
			String boardcontents = (String) request.getParameter("boardcontents");
			String boardwriter = (String) session.getAttribute("id");
			BoardVO vo = new BoardVO(boardtitle, boardcontents, boardwriter);
			bdao.insertBoard(vo);
			html = "<!DOCTYPE html>" + "<html>" + "<head>"
					+ "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>" + "<title>CSS</title>"
					+ "<style>" + "div {" + "	text-align: center;" + "}" + "" + "" + ".button {"
					+ "background-color: #4CAF50;" + "	border: none;" + "	color: white;" + "	padding: 15px 32px;"
					+ "text-align: center;" + "	text-decoration: none;" + "	display: inline-block;" + "font-size: 16px;"
					+ "}" + "</style>" + "</head>" + "<body background='images/background.png'>"
					+ "<font size='2em' color='silver'>*�Խñ� ����</font><br><div>"
					+ "<img src='images/Mark.png' width='130px' height='150px' alt=''><br>"
					+ "<font size='7em' color='black'>�Խñ��� </font> <font size='7em'"
					+ "style='font-weight: bold'>����</font> <font size='7em'>�Ǿ����ϴ�.</font><br><br>"
					+ "<table class='list' border='2px'>" + "<tr>" + "<td>����</td><td>" + boardtitle + "</td>" + "</tr>"
					+ "<tr>" + "<td>�ۼ���</td><td>" + boardwriter + "</td>" + "</tr>" + "<tr>"
					+ "<td height='300'>����</td><td width=500>" + boardcontents + "</td>" + "</tr>" + "</table>" + ""
					+ "<form class='center' action='test.jsp'><input type=submit value='�������� ���ư���'></form>";
		}
		out.println(html);

	}
}