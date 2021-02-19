package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectTest {

	public SelectTest() {
	}
	// 1개의 취득 Connection Statement	ResultSet
	public UserDTO search(String id) {
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				   + " FROM USERTEST "
				   + " WHERE ID = '" + id + "' ";
		System.out.println(sql);
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null; //db로 부터 결과를 리턴받는 값
		UserDTO dto = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {//데이타가 있는 경우
				String userid = rs.getString("id");
				String username = rs.getString("name");
				int userage = rs.getInt("age");
				String userjoindate = rs.getString("joindate");
				
				dto = new UserDTO(userid, username, userage, userjoindate);
			}
		} catch (SQLException e) {e.printStackTrace();}
		finally {DBClose.Close(conn, stmt, rs);}
		
		return dto;
	}
	public UserDTO select(String id) {
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				   + " FROM USERTEST "
				   + " WHERE ID = ? ";
		System.out.println(sql);
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		UserDTO dto = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {//데이타가 있는 경우
				String userid = rs.getString("id");
				String username = rs.getString("name");
				int userage = rs.getInt("age");
				String userjoindate = rs.getString("joindate");
				
				dto = new UserDTO(userid, username, userage, userjoindate);
			}
		} catch (SQLException e) {e.printStackTrace();}
		finally {DBClose.Close(conn, psmt, rs);}
		
		return dto;
	}
	
	// 다수취득
	public List<UserDTO> getUserList() {
		String sql = "SELECT * "
				   + "FROM USERTEST ";
		System.out.println(sql);
		
		Connection conn = DBConnection.getConnection();//연결
		PreparedStatement psmt = null;//넣고
		ResultSet rs = null;//결과
		
		List<UserDTO> list = new ArrayList<UserDTO>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {//여러개는 while 하나는 if
				String userid = rs.getString("id");
				String username = rs.getString("name");
				int userage = rs.getInt("age");
				String userjoindate = rs.getString("joindate");
				
				UserDTO dto = new UserDTO(userid, username, userage, userjoindate);
				list.add(dto);
			}
		} catch (SQLException e) {e.printStackTrace();}
		finally {DBClose.Close(conn, psmt, rs);}
		
		return list;
	}
	
	public List<UserDTO> getUserList(int age) {
		String sql = "SELECT * FROM USERTEST WHERE AGE >= ? ";
		System.out.println(sql);
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<UserDTO> list = new ArrayList<UserDTO>();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, age);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String userid = rs.getString("id");
				String username = rs.getString("name");
				int userage = rs.getInt("age");
				String userjoindate = rs.getString("joindate");
				
				UserDTO dto = new UserDTO(userid, username, userage, userjoindate);
				list.add(dto);
			}
		} catch (SQLException e) {e.printStackTrace();}
		finally {DBClose.Close(conn, psmt, rs);}
		return list;
	}
}












