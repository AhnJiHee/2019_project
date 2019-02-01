package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.BoardVO;

public class BoardDAO {
	public void insertBoard(BoardVO vo) throws Exception {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		
		String sql = "insert into board values ((select max(seq)+1 from board), ?, ?, ?)";
		PreparedStatement pt = con.prepareStatement(sql);
		
//		pt.setInt(1, vo.getSeq());
		pt.setString(1, vo.getTitle());
		pt.setString(2, vo.getContents());
		pt.setInt(3, vo.getViewcount());
		
		pt.executeUpdate();
		con.close();

		} catch(Exception e) {
			e.printStackTrace();
		} 
		System.out.println("게시판에 저장을 완료했습니다.");
		}
	
	public BoardVO selectBoard(int seq) throws Exception{
		BoardVO vo = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			String sql = "select title, contents, viewcount from board where seq = ?";
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, seq);
			ResultSet rs = pt.executeQuery();
			
			if (rs.next()) {
				vo = new BoardVO(seq,
						rs.getString("title"),
						rs.getString("contents"),
						rs.getInt("viewcount"));
				// 숙제 : 조회수 1개씩 증가시키기 => update 기능 이용
			}
			else {
				vo = new BoardVO(0,"0","0",0);
			}
			
			con.close();
			} catch(Exception e) {
				e.printStackTrace();
			} 
		
		return vo;
	}
	
	public void updateBoard(String oldString, String newString) throws Exception {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			String sql = "update board" + 
					" set title = substr(title, 0, instr(title, ?)-1)" + 
					" || ? || substr(title, instr(title, ?)+length(?), length(title))" +
					" where instr(title, ? ) >0 ";
			String sql2 = "update board" + 
					" set contents = substr(contents, 0, instr(contents, ?)-1)" + 
					" || ? || substr(contents, instr(contents, ?)+length(?), length(contents))" +
					" where instr(contents, ?) >0";
					
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, oldString);
			pt.setString(2, newString);
			pt.setString(3, oldString);
			pt.setString(4, newString);
			pt.setString(5, oldString);
			
			PreparedStatement pt2 = con.prepareStatement(sql2);
			pt2.setString(1, oldString);
			pt2.setString(2, newString);
			pt2.setString(3, oldString);
			pt2.setString(4, newString);
			pt2.setString(5, oldString);

			pt.executeUpdate();
			pt2.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("게시물 수정을 완료했습니다.");

		
	}
		
}