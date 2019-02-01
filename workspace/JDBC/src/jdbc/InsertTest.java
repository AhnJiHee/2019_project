package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest {

	public static void main(String[] args) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 1. DB 연결
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		System.out.println("연결 성공");
		
		// 2. SQL 전송
		// member 테이블 저장
		// java 22222 염정아 010-444-5555 sysdate yum@multi.com

		//키보드 입력 기능 구현
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("암호 : ");
		int pw = sc.nextInt();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("폰번호 : ");
		String phone = sc.next();	
		
		String sql = 
				"insert into member values "
				+ " ( ? , ? , ? , ? , sysdate , ?)";
		// sql 저장 / 전송 역할하는 객체 api
		PreparedStatement pt = con.prepareStatement(sql);
		// ? 값을 setting 해주어야 한다
		
		pt.setString(1, id);
		pt.setInt(2, pw);
		pt.setString(3, name);
		pt.setString(4, phone);
		pt.setString(5, email);

//		String line = sc.nextLine();
//		String[] tokens = line.split(" ");
//		
//		pt.setString(1,  tokens[0]);
//		pt.setInt(2,  Integer.parseInt(tokens[1]));
//		pt.setString(3,  tokens[2]);
//		pt.setString(4,  tokens[3]);
//		pt.setString(5,  tokens[4]);
		
		// 3. SQL 결과 검색
		int insertRow = pt.executeUpdate();
		System.out.println("삽입 행의 개수 = " + insertRow);
		
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
