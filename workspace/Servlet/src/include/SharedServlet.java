package include;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SharedServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dev = (String) request.getAttribute("devname");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<hr/>");
		Date now = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초");
		out.println(f.format(now));
		out.println("연락처 - 010-222-3333, 개발자 - " + dev);
		out.println("<hr/>");
		
		
	}

}
