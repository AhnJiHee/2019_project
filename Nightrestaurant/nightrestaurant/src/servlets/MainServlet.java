package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// ��� ��ºκ�
		String html = "<div class = 'banner_div'></div>";
		out.println(html);
		
		
		// �α���+�׺������ ��ºκ�
		request.getRequestDispatcher("lognavi.jsp").include(request, response);
		
		// ���� ��ºκ�
		if ( request.getParameter("branch").equals("1")) {
			request.getRequestDispatcher("boardlist.jsp").include(request, response);
		} else if ( request.getParameter("branch").equals("2")) {
			request.getRequestDispatcher("restaurantlist.jsp").include(request, response);
		}
		else if(request.getParameter("branch").length()==0){
			request.getRequestDispatcher("R").include(request, response);
		}
	}



}
