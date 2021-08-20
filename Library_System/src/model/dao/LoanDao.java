package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import db.DBConnector;
import model.dto.Loan;

public class LoanDao {
	private static LoanDao instance;
	ArrayList<Loan> loanList;
	
	private LoanDao() {}
	 
	public static LoanDao getInstance() {
		if(instance == null) {
			instance = new LoanDao();
		}
		return instance;
	}

	public ArrayList<Loan> listAllLoan() {
		String sql = "SELECT * FROM loan";
		loanList = new ArrayList<>();
		

		try( 
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			){

			while (rs.next()) {
				loanList.add(new Loan(
						rs.getInt("loan_num"),
						rs.getString("student_num"),
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
	
	// listByLoanNum은 매개변수를 받도록 수정했습니다
	public ArrayList<Loan> listByLoanNum(int loan_num)  {
		loanList = new ArrayList<>();
		String sql = "SELECT * FROM loan "
				+ "WHERE loan_num = ?";
		
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				){
			/*
			 	pstmt.setString(0,sql) X 잘못된 문법으로 pstmt.setInt(1,loan_num)으로 수정하였습니다 
			 	set을 하실때 sql문은 index가 0이 아닌 1부터 시작입니다
			 	resultSet의 위치가 바뀌었습니다. 바뀐 위치로 인해 rs.close() 새로 생겼습니다
			*/
			pstmt.setInt(1, loan_num);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				loanList.add(new Loan(
						rs.getInt("loan_num"),
						rs.getString("student_num"),
						rs.getInt("book_id"),
						rs.getDate("loan_date"),
						rs.getDate("return_date"),
						rs.getInt("extend")
						));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loanList;
		
	}
	
	public ArrayList<Loan> listByStudentNum(String student_num)  {
		loanList = new ArrayList<>();
		String sql = "SELECT l.*,s.student_name,b.book_name,o.\"overdue_period\" FROM "
				+ "loan l INNER JOIN allbookinfo b ON l.book_id = b.book_id "
				+ "INNER JOIN student s ON l.student_num = s.student_num "
				+ "INNER JOIN overdue o ON l.loan_num = o.loan_num WHERE s.student_num = ? AND return_date IS NULL";
		 
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				){
			
			pstmt.setString(1,student_num);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				loanList.add(new Loan(
						rs.getInt("loan_num"),
						rs.getString("student_num"),
						rs.getString("student_name"),
						rs.getString("book_name"),
						rs.getDate("loan_date"),
						rs.getDate("deadline"),
						rs.getDate("return_date"),
						rs.getInt("extend"),
						rs.getInt("overdue_period")
						));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loanList;
		
	}
	
	public int insertLoan(int student_num, int book_id) {
		String sql = "INSERT INTO loan(loan_num, student_num, book_id)"
				+ " VALUES(LOAN_NUM_SEQ.nextval, ?, ?)";
		int row = 0;
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			 ){
			
			pstmt.setInt(1, student_num);
			pstmt.setInt(2, book_id);
			
			row = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
		
	}
	
	public int updateReturnDate(int loan_num) {
		String sql = "UPDATE loan SET return_date = ? WHERE loan_num = ?";
		int rows = 0;
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setDate(1, sqlDate);
			pstmt.setInt(2, loan_num);
			
			rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public int updateExtend(int loan_num) {
		String sql = "UPDATE loan SET extend = extend + 1 WHERE loan_num = ?";
		int rows = 0;
		
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
			){
			pstmt.setInt(1, loan_num);
			rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public int updateDeadline(int loan_num) {
		String sql = "UPDATE loan SET deadline = deadline + 7 WHERE loan_num = ?";
		int rows = 0;
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			pstmt.setInt(1, loan_num);
			rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public int deleteLoan(int loan_num) {
		String sql = "DELETE FROM loan WHERE loan_num = ?";
		int rows = 0;
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			pstmt.setInt(1, loan_num);
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	
	}
}