package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 1. DB 연결
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		System.out.println("연결 성공");
		
		// 2. SQL 전송
		// member 테이블 수정
		// java 22222 염정아 010-444-5555 sysdate yum@multi.com
	
		//키보드 입력 기능 구현
		Scanner sc = new Scanner(System.in);		
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();

		String sql = 
				"update member set name = ? where id = ?";
		// sql 저장 / 전송 역할하는 객체 api
		PreparedStatement pt = con.prepareStatement(sql);
		// ? 값을 setting 해주어야 한다
		
		pt.setString(1, name);
		pt.setString(2, id);

		// 3. SQL 결과 검색
		int insertRow = pt.executeUpdate();
		System.out.println("변경 행의 개수 = " + insertRow);
		
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
