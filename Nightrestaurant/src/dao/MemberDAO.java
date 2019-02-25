package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import vo.MemberVO;

public class MemberDAO {
	
	// ȸ������ �޼���
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
	
	// ȸ����ȸ �޼���
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
					result = "����";
				} else {
					result = "Ȯ��";
				} 
			} else {
				result = "��ȸ��";
			}
			con.close();
		}// ���� ����
		// ���� ó��
		catch(Exception e) {
			result = "����";
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
	
	// �ۼ��� check
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

