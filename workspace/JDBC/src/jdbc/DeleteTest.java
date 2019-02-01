package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteTest {

	public static void main(String[] args) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 1. DB 연결
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		/* jdbc:oracle:thin:@ip:port:이름, 계정, 비밀번호
		 String sql = "select id, password, to_char(indate, 'mm-dd-yyyy') from member";
		 PreparedStatement pt = con.prepareStatement(sql); sql문 실행
		 pt.setXXX(index, XXX)g
		 
		 int row = pt.executeUpdate();
		 => insert, delete, update 횟수
		 ResultSet rs = pt.executeQuery();
		 while(rs.next()){
		 	rs.getString(1)
		 	int pw = rs.getInt("password")
		 	String indate = rs.getString(indate);
		 }
		 => select 내용
		 
		 con.close(); 연결 해제 
		 */
		System.out.println("연결 성공");
		
		// 2. SQL 전송
		// member 테이블 수정
		// java 22222 염정아 010-444-5555 sysdate yum@multi.com
	
		//키보드 입력 기능 구현
		Scanner sc = new Scanner(System.in);		
		System.out.print("아이디 : ");
		String id = sc.next();

		String sql = 
				"delete member where to_char(indate, 'yy/mm/dd') = "
				+ "(select to_char(indate, 'yy/mm/dd') from member where id = ?)";
		// sql 저장 / 전송 역할하는 객체 api
		PreparedStatement pt = con.prepareStatement(sql);
		// ? 값을 setting 해주어야 한다
		
		pt.setString(1, id);

		// 3. SQL 결과 검색
		int insertRow = pt.executeUpdate();
		System.out.println("삭제 행의 개수 = " + insertRow);
		
		// 4. DB 연결 해제
		con.close();
		System.out.println("연결 해제 성공");
		} catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
