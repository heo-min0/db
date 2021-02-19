package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {

	public boolean delete(String name) {
		String sql = " DELETE FROM USERTEST "
				   + " WHERE NAME = '" + name + "' ";
		System.out.println(sql);
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		int count = 0;
		try {
			stmt = conn.createStatement();
			count = stmt.executeUpdate(sql);
			System.out.println("삭제 성공");
		} catch (SQLException e) {e.printStackTrace();}
		finally {
			DBClose.Close(conn, stmt, null);
		}
		return     count>0? true:false         ;
	}
}
