package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DBClose;
import db.DBConnection;
import dto.AccountDto;

//singleton
public class AccountDao { //DB 와 접속하는 class

	private static AccountDao dao = null;
		
	private AccountDao() {
		DBConnection.initConnection();
	}
	
	public static AccountDao getInstance() {
		if(dao == null) {
			dao = new AccountDao();
		}
		return dao;
	}
	// 날짜,  사용처,  분류, int 돈,  memo
	public boolean insert(AccountDto dto) {
		String sql = "INSERT INTO ACCOUNT01 VALUES(SYSDATE,?,?,?,?)";
		System.out.println(sql);
		int count = 0;
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		
		try { //"식비", "지출", 12000, "점심식사"
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUse());
			psmt.setString(2, dto.getClassify());
			psmt.setInt(3, dto.getMoney());
			psmt.setString(4, dto.getMemo());
			
			count = psmt.executeUpdate();
			System.out.println("추가 성공");
			
		} catch (SQLException e) {System.out.println("추가 실패");}
		finally {DBClose.Close(conn, psmt, null);}
		return count>0? true:false;
	}
	
	public void delete(String suse) {
		String sql = "DELETE FROM ACCOUNT01 WHERE ACCUSE = ?";
		System.out.println(sql);
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		
		try { //"식비", "지출", 12000, "점심식사"
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, suse);

			psmt.executeUpdate();
			System.out.println("삭제 성공");
			
		} catch (SQLException e) {System.out.println("삭제 실패");}
		finally {DBClose.Close(conn, psmt, null);}
	}
	
	public void update(String suse, int smoney) {
		String sql = "UPDATE ACCOUNT01 SET ACCMONEY = ? WHERE ACCUSE = ?";
		System.out.println(sql);
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		
		try { //"식비", "지출", 12000, "점심식사"
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, smoney);
			psmt.setString(2, suse);
			
			psmt.executeUpdate();
			System.out.println("수정 성공");
			
		} catch (SQLException e) {System.out.println("수정 실패");}
		finally {DBClose.Close(conn, psmt, null);}
	}
	
	public void selete() {
		List<AccountDto> list = new ArrayList<AccountDto>();
		 
		String sql = "SELECT * FROM ACCOUNT01";
		System.out.println(sql);
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String date = rs.getString("ACCDATE");
				String use = rs.getString("ACCUSE");
				String classify = rs.getString("ACCCLASSIFY");
				int money = rs.getInt("ACCMONEY");
				String memo = rs.getString("ACCMEMO");
				
				AccountDto dto = new AccountDto(date, use, classify, money, memo);
				list.add(dto);
			}
			for (AccountDto dto : list) { System.out.println(dto.toString()); }
			
		} catch (SQLException e) {e.printStackTrace();}
		finally {DBClose.Close(conn, psmt, null);}
	}
	
	public void selete(String sdate, String suse) {//날짜로 검색하기, 제목으로 검색하기
		List<AccountDto> list = new ArrayList<AccountDto>();
		 
		String sql = "SELECT * FROM ACCOUNT01 WHERE TO_CHAR(ACCDATE,'YYMMDD') = ? OR ACCUSE = ?";
		System.out.println(sql);
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sdate);
			psmt.setString(2, suse);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String date = rs.getString("ACCDATE");
				String use = rs.getString("ACCUSE");
				String classify = rs.getString("ACCCLASSIFY");
				int money = rs.getInt("ACCMONEY");
				String memo = rs.getString("ACCMEMO");
				
				AccountDto dto = new AccountDto(date, use, classify, money, memo);
				list.add(dto);
			}
			for (AccountDto dto : list) { System.out.println(dto.toString()); }
			
		} catch (SQLException e) {e.printStackTrace();}
		finally {DBClose.Close(conn, psmt, null);}
	}
	
	public void sort() {//지출 많은 순으로
		List<AccountDto> list = new ArrayList<AccountDto>();
		 
		String sql = "SELECT * FROM ACCOUNT01 WHERE ACCCLASSIFY = '지출' ORDER BY ACCMONEY DESC";
		System.out.println(sql);
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String date = rs.getString("ACCDATE");
				String use = rs.getString("ACCUSE");
				String classify = rs.getString("ACCCLASSIFY");
				int money = rs.getInt("ACCMONEY");
				String memo = rs.getString("ACCMEMO");
				
				AccountDto dto = new AccountDto(date, use, classify, money, memo);
				list.add(dto);
			}
			for (AccountDto dto : list) { System.out.println(dto.toString()); }
			
		} catch (SQLException e) {e.printStackTrace();}
		finally {DBClose.Close(conn, psmt, null);}
	}
	
	public void totalSum() {
		String sql = "SELECT ACCCLASSIFY, SUM(ACCMONEY) AS SUM FROM ACCOUNT01 GROUP BY ACCCLASSIFY";
		System.out.println(sql);
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			int totalsum = 0;
			
			while (rs.next()) {
				String key = rs.getString("ACCCLASSIFY");
				int value = rs.getInt("SUM");
				if (key.equals("지출")) {value = -value;}
				System.out.println(key + " : " + String.format("%,d", value )  + "원");
				totalsum += value;
			}
			System.out.println("잔액 : " + String.format("%,d", totalsum ) + "원");
			
		} catch (SQLException e) {e.printStackTrace();}
		finally {DBClose.Close(conn, psmt, null);}
	}
	
}
