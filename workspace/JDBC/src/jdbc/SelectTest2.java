package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest2 {

	public static void main(String[] args) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 1. DB 연결
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		System.out.println("연결 성공");
		String sql = "select count(id) from member";
		PreparedStatement pt = con.prepareStatement(sql);
		
//		pt.setString(1, "ora%" );
		ResultSet rs = pt.executeQuery();
		rs.next();
		// 불러오고 싶은 데이터가 하나밖에 없어도
		// next로 값을 불러와야 첫번째 레코드로 이동할 수 있다
		System.out.println(rs.getInt(1));
		
		// 4. DB 연결 해제
		con.close();
		System.out.println("연결 해제 성공");
		// 연결 해제 이후에는 DB로부터 어떤 데이터도 가져올 수 없다
		// 또한 Oracle DB 자체에 최대 접근자 수가 제한되어있으므로
		// 상황에 따라 아예 접속을 못할 수도 있다
		// + 제한 넘기면 아예 연결이 다 끊어져버림 
		// 그러므로 연결 중에 불러온 값을 JAVA 객체 내에 저장해두면
		// 연결이 끊어진 뒤에도 사용할 수 있다
		// 배열, 리스트, 셋, 맵 ... 리스트가 제일 적합 (순서o/개수미정) 
		
		// 4. sql 결과 검색 
		
		} catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(SQLException e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
