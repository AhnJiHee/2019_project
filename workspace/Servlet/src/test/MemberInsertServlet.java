package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberInsertServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String result = "";
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		
		String sql = 
				"insert into member values "
				+ " ( ? , ? , ? , ? , sysdate , ?)";
		PreparedStatement pt = con.prepareStatement(sql);

		pt.setString(1, id);
		pt.setInt(2, Integer.parseInt(pw));
		pt.setString(3, name);
		pt.setString(4, phone);
		pt.setString(5, email);	
			
		int insertRow = pt.executeUpdate();
		if( insertRow==1) {
			result = "회원가입이 완료되었습니다.";			
		} else {
		}
		
		con.close();
			
		}catch(Exception e) {
			result = "회원가입 미완료되었습니다.";
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		
	} // doGet end
}
