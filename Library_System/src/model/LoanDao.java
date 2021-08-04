package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import db.DBConnector;

public class LoanDao {
	
	private Connection conn;
	private PreparedStatement pstmt = null;
	
	
	String sql;
	int res = 0;

	// 추가
	public int insert(int loan_num, int student_num, int book_id,
			Date loan_date, Date return_date, int extend) {
		sql = "INSERT INTO loan VALUES(?, ?, ?, ?, ?, ?)";
		try {
			conn = DBConnector.getConnection();
			pstmt = conn.prepareStatement(sql);
			 
			pstmt.setInt(1, loan_num);
			pstmt.setInt(2, student_num);
			pstmt.setInt(3, book_id);
			pstmt.setDate(4, (java.sql.Date) loan_date);
			pstmt.setDate(5, (java.sql.Date) return_date);
			pstmt.setInt(6, extend);
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
		
	}
	
	
	//삭제
	public int delete(int loan_num) {
		sql = "DELETE FROM loan WHERE loan_num = ?";
		try {
			conn = DBConnector.getConnection();
			pstmt = conn.prepareStatement(sql);
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	
	}
	
	public ArrayList<LoanDto> list(int loan_num) {
		sql = "SELECT FROM loan WHERE lona_num = ?";
			ArrayList loanList = new ArrayList<>();
		
		try {
				conn = DBConnector.getConnection();
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			

			while (rs.next()) {
				loanList.add(new LoanDto(
						rs.getInt("loan_num"),
						rs.getInt("student_num"),
						rs.getInt("book_id"),
						rs.getDate("loan_date"),
						rs.getDate("return_date"),
						rs.getInt("extend")
						
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loanList;
		
		}
	
	}
