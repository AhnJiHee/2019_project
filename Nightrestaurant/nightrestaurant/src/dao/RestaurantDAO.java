package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import vo.RestaurantVO;

public class RestaurantDAO {
	public static final int EACH = 5;

	// ���� ���� ������ ��� ��ȸ �޼ҵ�
		public ArrayList<RestaurantVO> getSelectedList(HttpServletRequest request, int pagenum, int each){
			ArrayList<RestaurantVO> list = new ArrayList<RestaurantVO>();
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","board","board");
				String sql = "select X.r, X.province ��, X.address �ּ�, X.closetime �����ð�, X.name ���Ը�, X.tag ����, X.keyword Ű����"
						 + " from (select rownum r, A.province, A.address, A.closetime, A.name, A.tag, A.keyword"
						 + " from (select * from restaurant order by name) A"
						 + " where rownum <= ?) X"
						 + " where X.r >=? and province=? and closetime=?";
		
				PreparedStatement pt = con.prepareStatement(sql);
				int start = (pagenum-1)*each +1;
				int end = pagenum*each;		
				pt.setInt(2, start);
				pt.setInt(1, end);			
				pt.setString(3, request.getParameter("province"));
				pt.setString(4, request.getParameter("closetime"));
				pt.executeUpdate();
				ResultSet rs = pt.executeQuery();
					
				while(rs.next()){
					RestaurantVO vo = new RestaurantVO();
					vo.setProvince((rs.getString("��")));
					vo.setAddress((rs.getString("�ּ�")));
					vo.setClosetime((rs.getString("�����ð�")));
					vo.setName((rs.getString("���Ը�")));
					vo.setTag((rs.getString("����")));
					vo.setKeyword((rs.getString("Ű����")));
					list.add(vo);
				}
				 
				con.close();
			}catch(Exception e) {
					e.printStackTrace();
			}
			return list;
		}
		
		// ��� ����¡ �޼ҵ�
		// �����ְ� ���� ������ ��ȣ / ���������� �����ַ��� �Ĵ� ����
		public ArrayList<RestaurantVO> getRestaurantList(int pagenum, int each){
			ArrayList<RestaurantVO> list = new ArrayList<RestaurantVO>();
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","board","board");
				String sql = "select X.r, X.province ��, X.address �ּ�, X.closetime �����ð�, X.name ���Ը�, X.tag ����, X.keyword Ű����"
						 + " from (select rownum r, A.province, A.address, A.closetime, A.name, A.tag, A.keyword"
						 + " from (select * from restaurant order by name) A"
						 + " where rownum <= ?) X"
						 + " where X.r >=?";
				PreparedStatement pt = con.prepareStatement(sql);
				int start = (pagenum-1)*each +1;
				int end = pagenum*each;		
				pt.setInt(2, start);
				pt.setInt(1, end);			
				ResultSet rs = pt.executeQuery();	
				while(rs.next()){
					RestaurantVO vo = new RestaurantVO();
					vo.setProvince((rs.getString("��")));
					vo.setAddress((rs.getString("�ּ�")));
					vo.setClosetime((rs.getString("�����ð�")));
					vo.setName((rs.getString("���Ը�")));
					vo.setTag((rs.getString("����")));
					vo.setKeyword((rs.getString("Ű����")));
					list.add(vo);
				}
				 
				con.close();
			}catch(Exception e) {
					e.printStackTrace();
			}
			return list;
		}
		
		// �� �Ĵ� �� ��ȸ
		
		public int getTotalRestaurants() {
			int count = 0;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","board","board");
				String sql = "select count(*) from restaurant";
				PreparedStatement pt = con.prepareStatement(sql);
				ResultSet rs = pt.executeQuery();
				rs.next();
				count = rs.getInt("count(*)");
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return count;
		}
		
		public int getTotalRestaurants(HttpServletRequest request) {
			int count = 0;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","board","board");
				String sql = "select count(*) from restaurant where province=? and closetime=?";
				PreparedStatement pt = con.prepareStatement(sql);
				pt.setString(1, request.getParameter("province"));
				pt.setString(2, request.getParameter("closetime"));
				pt.executeUpdate();
				ResultSet rs = pt.executeQuery();
				rs.next();
				count = rs.getInt("count(*)");
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return count;
		}
	
}
