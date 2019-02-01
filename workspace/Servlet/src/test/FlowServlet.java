package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FlowServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메소드 호출");
	}

	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}

	public void init() throws ServletException {
		System.out.println("수정init 메소드 호출");
	}

}
