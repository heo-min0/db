package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public InsertTest() {
		
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
	
	public int insertData(String id, String name, int age) {
		// Query(String) 준비
		String sql = " INSERT INTO USERTEST(ID, NAME, AGE, JOINDATE) "
				+ " VALUES('"+id+"','"+name+"',"+age+",SYSDATE) ";
		System.out.println(sql);
		// DB Connection
		Connection conn = getConnection(); //db 연결시키는거
		Statement state = null;  
		int count = 0; //0이면 추가 안된거, 1이면 1개, 몇 개 추가됐는지 알 수 있는 것
		// DB Processing
		try {
			state = conn.createStatement(); //현재상태 얻어옴
			count = state.executeUpdate(sql); //이걸 실행하면 위의 쿼리문이 실행된다
			System.out.println("추가 성공");
		} catch (SQLException e) {e.printStackTrace();}
		finally {
			// DB Close
			try {
				if(state != null) { state.close(); }
				if(conn != null) { conn.close(); }
			} catch (SQLException e) { e.printStackTrace(); }
		}
		return count;
	}
	
}








