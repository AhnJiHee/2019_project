package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 데이터 : 한글 처리 안해도 됨
		// post 데이터 : 한글 인코딩 필요함 (읽어올 때에도 인코딩)(항상 제일 먼저하기)
		request.setCharacterEncoding("utf-8");
		// id와 pw값 전송 받기 - form에서 정한 name 속성값
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		// <input type = checkbox>, <select multiple = "multiple">이 대표적 gPV 사용값
		String[] hobby = request.getParameterValues("hobby");
		String total = "";
		for(String s : hobby) {
			total += s + "--";
		}
		// 출력(응답) - servlet의 실행 결과를 브라우저로 전송
		response.setContentType("text/html;charset=utf-8");
		// 이떄 charset은 아래 전송하는 한글에만 적용, 브라우저에서 읽어오는 값은 적용 X
		PrintWriter out = response.getWriter();
		out.println("<h1>입력한 아이디는 " + id + "이고 ");
		out.println("암호는 " + pw + "입니다.");
		out.println("취미는 " + total + "입니다.</h1>");
		
		
	
	}

}
