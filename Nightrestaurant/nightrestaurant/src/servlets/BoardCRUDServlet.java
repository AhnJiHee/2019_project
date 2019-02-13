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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			html = "<h1 align='center'>������ �Ϸ�Ǿ����ϴ�.</h1>" +
					 "<form class='center' action='mainpage.jsp'>" +
					 "<input type=submit value='�������� ���ư���'>";			
		} else if (action.equals("����")) {
			BoardVO vo = (BoardVO) session.getAttribute("boardvo");
			int seq = vo.getBoardseq();
			String boardwriter = vo.getBoardwriter();
			String newtitle = (String) request.getParameter("newtitle");
			String newcontents = (String) request.getParameter("newcontents");
			bdao.updateBoard(seq, newtitle, newcontents);
			html = "<table class='list' border='2px'>" + 
					"	<tr>" + 
					"		<td>����</td><td>"+newtitle+"</td>" + 
					"	</tr>" + 
					"	<tr>" + 
					"		<td>�ۼ���</td><td>"+boardwriter+"</td>" + 
					"	</tr>" + 
					"	<tr>" + 
					"		<td height='300'>����</td><td width=500>"+newcontents+"</td>" + 
					"	</tr>" + 
					"</table>" +
					"<h1 align='center'> �����Ǿ����ϴ�. </h1>" + 
					"<form class='center' action='mainpage.jsp'>" + 
					"<input type=submit value='�������� ���ư���'>";
		} else if (action.equals("����")) {
			String boardtitle = (String) request.getParameter("boardtitle");
			String boardcontents = (String) request.getParameter("boardcontents");
			String boardwriter = (String) session.getAttribute("id");
			BoardVO vo = new BoardVO(boardtitle, boardcontents, boardwriter);
			bdao.insertBoard(vo);
			html = "<table class='list' border='2px'>" + 
					"<tr>" + 
					"<td>����</td><td>"+boardtitle+"</td>" + 
					"</tr>" + 
					"<tr>" + 
					"<td>�ۼ���</td><td>"+boardwriter+"</td>" + 
					"</tr>" + 
					"<tr>" + 
					"<td height='300'>����</td><td width=500>"+boardcontents+"</td>" + 
					"</tr>" + 
					"</table>" + 
					"" + 
					"<h1 align='center'> ����Ǿ����ϴ�. </h1>" + 
					"<form class='center' action='mainpage.jsp'>" + 
					"<input type=submit value='�������� ���ư���'>" + 
					"</form>";
		} 
		out.println(html);
			

	}
}
