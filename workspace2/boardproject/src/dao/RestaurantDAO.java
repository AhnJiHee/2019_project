package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import vo.RestaurantVO;

public class RestaurantDAO {

	// 선택 지역 음식점 목록 조회 메소드
		public ArrayList<RestaurantVO> getSelectedList(HttpServletRequest request, int pagenum, int each){
			ArrayList<RestaurantVO> list = new ArrayList<RestaurantVO>();
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","board","board");
				String sql = "select X.r, X.province 구, X.address 주소, X.closetime 마감시간, X.name 가게명, X.tag 종목, X.keyword 키워드"
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
					vo.setProvince((rs.getString("구")));
					vo.setAddress((rs.getString("주소")));
					vo.setClosetime((rs.getString("마감시간")));
					vo.setName((rs.getString("가게명")));
					vo.setTag((rs.getString("종목")));
					vo.setKeyword((rs.getString("키워드")));
					list.add(vo);
				}
				 
				con.close();
			}catch(Exception e) {
					e.printStackTrace();
			}
			return list;
		}
		
		// 목록 페이징 메소드
		// 보여주고 싶은 페이지 번호 / 페이지마다 보여주려는 식당 개수
		public ArrayList<RestaurantVO> getRestaurantList(int pagenum, int each){
			ArrayList<RestaurantVO> list = new ArrayList<RestaurantVO>();
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","board","board");
				String sql = "select X.r, X.province 구, X.address 주소, X.closetime 마감시간, X.name 가게명, X.tag 종목, X.keyword 키워드"
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
					vo.setProvince((rs.getString("구")));
					vo.setAddress((rs.getString("주소")));
					vo.setClosetime((rs.getString("마감시간")));
					vo.setName((rs.getString("가게명")));
					vo.setTag((rs.getString("종목")));
					vo.setKeyword((rs.getString("키워드")));
					list.add(vo);
				}
				 
				con.close();
			}catch(Exception e) {
					e.printStackTrace();
			}
			return list;
		}
		
		// 총 식당 수 조회
		
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
