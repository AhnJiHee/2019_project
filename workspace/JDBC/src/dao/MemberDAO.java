package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.MemberVO;

public class MemberDAO {
	public ArrayList<MemberVO> selectMember(){
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			String sql = "select id, password, "
					+ "nvl(name, 'no name') 이름, "
					+ "nvl(name, '010') 연락처, "
					+ "nvl(indate, sysdate) 가입일, "
					+ "nvl(email, 'none') 이메일 "
					+ "from member";
			PreparedStatement pt = con.prepareStatement(sql);
						ResultSet rs = pt.executeQuery();
			
			while(rs.next()){
				 	String id = rs.getString("id");
				 	int password = rs.getInt("password");
				 	String name = rs.getString("이름");
				 	String phone = rs.getString("연락처");
				 	String indate = rs.getString("가입일");		 	
				 	String email = rs.getString("이메일");
				 	MemberVO vo = new MemberVO(id, password, name, phone, indate, email);
				 	list.add(vo);
			}
			con.close();
			} catch(ClassNotFoundException e) {
				System.out.println(e.getMessage());
			} catch(SQLException e) {
//				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		
		return list;
	}
	
	
}
