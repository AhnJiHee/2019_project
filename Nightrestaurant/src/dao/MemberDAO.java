package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import vo.MemberVO;

public class MemberDAO {
	
	// 회원가입 메서드
	public void signIn (MemberVO vo){
		String result = "";
		String id = vo.getId();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.111.108:1521:xe","board","board");
				
			String sql = 
					"insert into member values "
					+ " ( ? , ? , ? , ? , sysdate , ?)";
			PreparedStatement pt = con.prepareStatement(sql);

			pt.setString(1, vo.getId());
			pt.setString(2, vo.getPassword());
			pt.setString(3, vo.getName());
			pt.setString(4, vo.getPhone());
			pt.setString(5, vo.getEmail());	
				
			int insertRow = pt.executeUpdate();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 회원조회 메서드
	public String ifmember (String id, String password) {
		String result = "";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.111.108:1521:xe","board","board");
				
			String sql = 
					"select password from member where id = ?";
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, id);
			pt.executeUpdate();
			ResultSet rs = pt.executeQuery();
			if (rs.next()) {
				String pwcheck = rs.getString("password");
				if( pwcheck.equals(password)) {
					result = "정상";
				} else {
					result = "확인";
				} 
			} else {
				result = "비회원";
			}
			con.close();
		}// 연결 해제
		// 오류 처리
		catch(Exception e) {
			result = "오류";
			e.printStackTrace();
		}
		return result;
	}
	
	// login/off
	public String loginstatus(HttpSession session) {
		String status = "";
		
		if (session.getAttribute("id") != null) {
			status = "on";
		} else {
			status = "off";
		}
		return status;
	}
	
	// 작성자 check
	public String authority(HttpSession session, String boardwriter) {
		String authority = "";
		try {
			String userID = (String) session.getAttribute("id");
			if (userID.equals(boardwriter) || userID.equals("admin")) {
				authority = "TRUE";
			} else {
				authority = "FALSE";
			}
		} catch (NullPointerException e) {
			authority = "FALSE";
		}
		return authority;
	}
	
} //MemberDAO end

