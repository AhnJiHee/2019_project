package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginDBServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 처리
		// 1. id, pw 파라미터 입력
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String result = "";
		
		// pw length check start
		if (pw.length() > 5) {
			result = "<h1>암호 자리수를 확인하세요.</h1>";
		} 
		else {
			// id, pw check start
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
				// 2. member 테이블 id, pw 조사 (sql)
				String sql = "select password from member where id = ?";
				PreparedStatement pt = con.prepareStatement(sql);
				pt.setString(1, id);
				ResultSet rs = pt.executeQuery();
	
				// 3. id, pw 일치 시 : 정상 사용자입니다. (JDBC)
				//    id 일치, pw 불일치 시 : 비밀번호를 확인하세요.
				//    완전 틀렸을 시 : 회원이 아닙니다.
				
				if (rs.next()) {
					String dbPW = rs.getString("password");
					if (dbPW.equals(pw)) {
						result = "<h1>정상 사용자입니다.</h1>";
					}
					else{
						result = "<h1>비밀번호를 확인하세요.</h1>";
					}
				} else {
						result = "<h1>회원이 아닙니다.</h1>"
								+ "<h3><a href = 'insertForm_DB.html'> 회원가입하러 가기 </a></h3>";
				}
				con.close(); 
			} catch(Exception e) {
				e.printStackTrace();
			} // id, pw check end
		}// pw length check end
		
		// 응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);
	
	}

}
