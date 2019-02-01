package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public static void main(String[] args) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 1. DB 연결
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		System.out.println("연결 성공");
		String sql = "select id, to_char(nvl(indate, sysdate), 'YYYY/MM/DD') 날짜 from member where id like ?";
		PreparedStatement pt = con.prepareStatement(sql);
		
		pt.setString(1, "ora%" );
		ResultSet rs = pt.executeQuery();
		
		// rs 생성 시 레코드 포인터는 첫번째 이전에 위치해있기 때문에
		// next 사용 시 첫문장으로 간다
		 while(rs.next()){
		 	String id = rs.getString("id");
//		 	int pw = rs.getInt("password");
//		 	String name = rs.getString("name");
//		 	String phone = rs.getString("phone");
		 	String indate = rs.getString("날짜");		 	
//		 	String email = rs.getString("email");
//		 	System.out.println(id+"-"+pw+"-"+name+"-"+phone+"-"+indate+"-"+email);
		 	System.out.println(id + ":" + indate);
		 }
		
		
		
		// 4. DB 연결 해제
		con.close();
		System.out.println("연결 해제 성공");
		} catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(SQLException e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
