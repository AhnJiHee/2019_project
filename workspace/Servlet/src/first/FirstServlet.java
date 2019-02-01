package first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		/*텍스트의 태그는 html로 인식해라; 글자는 UTF-8로 인식해라*/
		PrintWriter out = response.getWriter();
		out.println("<h1>hello 서블릿 실행 결과입니다</h1>");
		out.println("<h3>hello servlet complete</h3>");

	}

}
