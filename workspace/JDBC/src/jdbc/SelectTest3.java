package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.MemberDAO;
import vo.MemberVO;

public class SelectTest3 {

	public static void main(String[] args) {
		
	MemberDAO dao = new MemberDAO();
	ArrayList<MemberVO> list = dao.selectMember();
	
	for(MemberVO vo : list) {
		System.out.println(vo);
	}
	
	
		
		
	}

}
