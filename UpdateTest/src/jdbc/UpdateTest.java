package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

	public UpdateTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//드라이버가 있느냐 하는 것
			
			System.out.println("Driver Loading Success");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			System.out.println("Oracle Connection Success");
		} catch (SQLException e) {
			System.out.println("DB를 연결하지 못했습니다.");
		}
		return conn;
	}
	
	public int update(String id, int age) {
		//query
		String sql = " UPDATE USERTEST "
				   + " SET AGE = " + age + " "
				   + " WHERE ID = '" + id + "' ";
		System.out.println(sql);
		Connection conn = getConnection();
		Statement stmt = null;
		int count = 0;
		//db conn
		try {
			stmt = conn.createStatement();
			//db process
			count = stmt.executeUpdate(sql);
			System.out.println("수정 성공");
		} catch (SQLException e) {e.printStackTrace();}
		finally {
			//db close
			try {
				if (stmt != null) {stmt.close();}
				if (conn != null) {conn.close();}
			} catch (SQLException e) {e.printStackTrace();}
		}
		return count;
	}
}
